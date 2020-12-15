package cyan.toolkit.rest.identity.worker;


import cyan.toolkit.rest.identity.IdentityErrorStatus;
import cyan.toolkit.rest.identity.error.IdentityWorkerError;
import cyan.toolkit.rest.identity.error.IdentityWorkerException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

/**
 * <p>IdentityWorkerMachine</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:52 2020/1/13
 */
@Data
@Slf4j
class IdentityWorkerMachine implements IdentityWorker{
    private Long lastTime = IdentityWorkerConfig.TIMESTAMP;
    private Long sequence = null;
    private Long workerId;
    private Long centerId;

    public IdentityWorkerMachine(@NonNull Long workerId, @NonNull Long centerId, Long sequence) throws IdentityWorkerError {
        if (workerId > IdentityWorkerConfig.MAX_WORKER_ID || workerId < IdentityWorkerConfig.MIN_WORKER_ID) {
            log.error("worker Id can't be greater than {} or less than {}",IdentityWorkerConfig.MAX_WORKER_ID,IdentityWorkerConfig.MIN_WORKER_ID);
            throw new IdentityWorkerError(IdentityErrorStatus.WORKER_ID_INVALID);
        }
        if (centerId > IdentityWorkerConfig.MAX_CENTER_ID || centerId < IdentityWorkerConfig.MIN_CENTER_ID) {
            log.error("center Id can't be greater than {} or less than {}",IdentityWorkerConfig.MAX_CENTER_ID,IdentityWorkerConfig.MIN_CENTER_ID);
            throw new IdentityWorkerError(IdentityErrorStatus.CENTER_ID_INVALID);
        }
        this.workerId = workerId;
        this.centerId = centerId;
        if (sequence != null && sequence >= IdentityWorkerConfig.SEQUENCE) {
            this.sequence = sequence;
        }
        IDENTITY_WORKER_MAP.put(WorkerType.CENTER_WORKER,this);
    }

    public IdentityWorkerMachine(@NonNull Long workerId, @NonNull Long centerId) throws IdentityWorkerError {
        this(workerId,centerId,null);
    }

    @Override
    public synchronized Long generate() throws IdentityWorkerException {
        return generate(this.sequence);
    }

    @Override
    public synchronized Long generate(Long date) throws IdentityWorkerException {
        Long time = new IdentityWorkerTime().getTime();
        if (date != null) {
            time = new IdentityWorkerTime(date).getTime();
        }

        if (time < this.lastTime) {
            log.error("clock is moving backwards. Rejecting requests until {}", this.lastTime);
            throw new IdentityWorkerException("{} milliseconds is error time" + (this.lastTime- time));
        }
        if (this.lastTime.equals(time)) {
            this.sequence = (this.sequence + IdentityWorkerConfig.DEFAULT_TAG) & IdentityWorkerConfig.SEQUENCE_MASK;
            if (this.sequence.equals(IdentityWorkerConfig.SEQUENCE)) {
                time = IdentityWorkerTime.next(this.lastTime);
            }
        } else {
            this.sequence = IdentityWorkerConfig.SEQUENCE;
        }
        this.lastTime = time;

        return (time << IdentityWorkerConfig.TIMESTAMP_SHIFT)
                | (centerId << IdentityWorkerConfig.CENTER_ID_SHIFT)
                | (workerId << IdentityWorkerConfig.WORKER_ID_SHIFT)
                | sequence;
    }
}
