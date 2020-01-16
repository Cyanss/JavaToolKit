package cyan.tool.kit.generate.core.identity.worker;

import cyan.tool.kit.generate.core.error.IdentityWorkerException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>IdentityWorkerArtificial</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:55 2020/1/13
 */
@Data
@Slf4j
class IdentityWorkerArtificial implements IdentityWorker{
    private Long lastTime = IdentityWorkerConfig.TIMESTAMP;
    private Long lastTag = IdentityWorkerConfig.DEFAULT_TAG;
    private Long sequence = IdentityWorkerConfig.SEQUENCE;
    public IdentityWorkerArtificial() {
        IDENTITY_WORKER_MAP.put(WorkerType.TAG_WORKER,this);
    }

    public IdentityWorkerArtificial(Long sequence) {
        if (sequence > IdentityWorkerConfig.SEQUENCE) {
            this.sequence = sequence;
        }
        IDENTITY_WORKER_MAP.put(WorkerType.TAG_SEQUENCE_WORKER,this);
    }

    @Override
    public synchronized Long generate(Long tag) throws IdentityWorkerException {
        long time = new IdentityWorkerTime().getTime();
        if(tag < IdentityWorkerConfig.SEQUENCE){
            tag = -tag;
        }
        if (time < IdentityWorkerConfig.TIMESTAMP) {
            log.error("clock is moving backwards. Rejecting requests until {}", this.lastTime);
            throw new IdentityWorkerException("{} milliseconds is error time" + (this.lastTime- time));
        }
        if (this.lastTime == time) {
            this.sequence = (this.sequence + IdentityWorkerConfig.DEFAULT_TAG) & IdentityWorkerConfig.SEQUENCE_MASK;
            if (this.sequence.equals(IdentityWorkerConfig.SEQUENCE)) {
                time = IdentityWorkerTime.next(this.lastTime);
            }
        } else {
            this.sequence = IdentityWorkerConfig.SEQUENCE;
        }
        if(tag.equals(lastTag)){
            this.sequence = (this.sequence + IdentityWorkerConfig.DEFAULT_TAG) & IdentityWorkerConfig.SEQUENCE_MASK;
            if (this.sequence.equals(IdentityWorkerConfig.SEQUENCE)) {
                time = IdentityWorkerTime.next(this.lastTime);
            }
        }
        this.lastTag = tag;
        this.lastTime = time;

        return (time << (IdentityWorkerConfig.ALL_BIT_SIZE - IdentityWorkerConfig.TIMESTAMP_BIT_SIZE))
                | ((tag % IdentityWorkerConfig.MAX_REGION_SIZE) << (IdentityWorkerConfig.ALL_BIT_SIZE - IdentityWorkerConfig.TIMESTAMP_BIT_SIZE - IdentityWorkerConfig.REGION_BIT_SIZE))
                | sequence;
    }
}
