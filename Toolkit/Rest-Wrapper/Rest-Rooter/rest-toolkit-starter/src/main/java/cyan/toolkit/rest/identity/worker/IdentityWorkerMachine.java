package cyan.toolkit.rest.identity.worker;


import cyan.toolkit.rest.identity.IdentityErrorStatus;
import cyan.toolkit.rest.identity.error.IdentityWorkerError;
import cyan.toolkit.rest.identity.error.IdentityWorkerException;
import cyan.toolkit.rest.util.common.GeneralUtils;
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
    private Long sequence = IdentityWorkerConfig.SEQUENCE;
    private Long cacheId = IdentityWorkerConfig.SEQUENCE;
    private Long workerId;
    private Long centerId;

    public IdentityWorkerMachine(@NonNull Long workerId, @NonNull Long centerId, Long sequence) {
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
            IDENTITY_WORKER_MAP.put(WorkerType.SEQUENCE_WORKER,this);
        }
        IDENTITY_WORKER_MAP.put(WorkerType.COMMON_WORKER,this);
    }

    public IdentityWorkerMachine(@NonNull Long workerId, @NonNull Long centerId) {
        this(workerId,centerId,null);
    }

    @Override
    public synchronized Long generate() {
        Long time = new IdentityWorkerTime().getTime();
        if (GeneralUtils.isNotEmpty(this.sequence)) {
            time = new IdentityWorkerTime().sequence(sequence);
        }
        if (time < this.lastTime) {
            this.sequence ++;
            time = new IdentityWorkerTime().sequence(Math.abs(this.lastTime - time) * this.sequence);
            log.warn("clock is moving backwards. Rejecting requests until {}", this.lastTime);
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

        long generateId = (time << IdentityWorkerConfig.TIMESTAMP_SHIFT)
                | (centerId << IdentityWorkerConfig.CENTER_ID_SHIFT)
                | (workerId << IdentityWorkerConfig.WORKER_ID_SHIFT)
                | sequence;
        if (this.cacheId == generateId) {
            return generate();
        } else {
            this.cacheId = generateId;
            return generateId;
        }
    }
}
