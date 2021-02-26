package cyan.toolkit.rest.identity.worker;

import cyan.toolkit.rest.identity.error.IdentityWorkerException;
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
    private Long offset = IdentityWorkerConfig.OFFSET;
    public IdentityWorkerArtificial() {
        IDENTITY_WORKER_MAP.put(WorkerType.BASE_WORKER,this);
    }

    public IdentityWorkerArtificial(Long offset) {
        if (offset > IdentityWorkerConfig.SEQUENCE) {
            this.sequence = offset;
        }
        if (offset > IdentityWorkerConfig.OFFSET) {
            this.offset = offset;
        }
        IDENTITY_WORKER_MAP.put(WorkerType.OFFSET_WORKER,this);
    }

    @Override
    public synchronized Long generate() {
        long time = new IdentityWorkerTime().getTime();
        if(this.offset < IdentityWorkerConfig.SEQUENCE){
            offset = -offset;
        }
        if (time < IdentityWorkerConfig.TIMESTAMP) {
            time = new IdentityWorkerTime().sequence((Math.abs(this.lastTime - time) * this.sequence) + this.offset);
            log.error("clock is moving backwards. Rejecting requests until {}", this.lastTime);
        }
        if (this.lastTime == time) {
            this.sequence = (this.sequence + IdentityWorkerConfig.DEFAULT_TAG) & IdentityWorkerConfig.SEQUENCE_MASK;
            if (this.sequence.equals(IdentityWorkerConfig.SEQUENCE)) {
                time = IdentityWorkerTime.next(this.lastTime);
            }
        } else {
            this.sequence = IdentityWorkerConfig.SEQUENCE;
        }
        if(offset.equals(lastTag)){
            this.sequence = (this.sequence + IdentityWorkerConfig.DEFAULT_TAG) & IdentityWorkerConfig.SEQUENCE_MASK;
            if (this.sequence.equals(IdentityWorkerConfig.SEQUENCE)) {
                time = IdentityWorkerTime.next(this.lastTime);
            }
        }
        this.lastTag = offset;
        this.lastTime = time;

        return (time << (IdentityWorkerConfig.ALL_BIT_SIZE - IdentityWorkerConfig.TIMESTAMP_BIT_SIZE))
                | ((offset % IdentityWorkerConfig.MAX_REGION_SIZE) << (IdentityWorkerConfig.ALL_BIT_SIZE - IdentityWorkerConfig.TIMESTAMP_BIT_SIZE - IdentityWorkerConfig.REGION_BIT_SIZE))
                | sequence;
    }
}
