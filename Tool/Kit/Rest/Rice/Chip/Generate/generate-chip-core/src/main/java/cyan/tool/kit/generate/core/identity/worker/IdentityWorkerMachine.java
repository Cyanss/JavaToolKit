package cyan.tool.kit.generate.core.identity.worker;

import cyan.tool.kit.generate.core.error.IdentityWorkerException;
import cyan.tool.kit.generate.core.identity.IdentityErrorStatus;
import cyan.tool.kit.rice.core.rice.error.natives.IdentityErrorException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
    private Long lastTag = IdentityWorkerConfig.TAG;
    private Long sequence = IdentityWorkerConfig.SEQUENCE;
    private Long workerId;
    private Long centerId;

    public IdentityWorkerMachine(Long workerId, Long centerId) throws IdentityWorkerException {
        if (workerId == null || workerId > IdentityWorkerConfig.MAX_WORKER_ID || workerId < IdentityWorkerConfig.MIN_WORKER_ID) {
            log.error("worker Id can't be greater than {} or less than {}",IdentityWorkerConfig.MAX_WORKER_ID,IdentityWorkerConfig.MIN_WORKER_ID);
            throw new IdentityWorkerException(IdentityErrorStatus.WORKER_ID_INVALID);
        }
        if (centerId == null || centerId > IdentityWorkerConfig.MAX_CENTER_ID || centerId < IdentityWorkerConfig.MIN_CENTER_ID) {
            log.error("center Id can't be greater than {} or less than {}",IdentityWorkerConfig.MAX_CENTER_ID,IdentityWorkerConfig.MIN_CENTER_ID);
            throw new IdentityWorkerException(IdentityErrorStatus.CENTER_ID_INVALID);
        }
        this.workerId = workerId;
        this.centerId = centerId;
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
            this.sequence = (this.sequence + IdentityWorkerConfig.TAG) & IdentityWorkerConfig.SEQUENCE_MASK;
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
