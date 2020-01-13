package cyan.tool.kit.generate.core.identity.worker;

import cyan.tool.kit.rice.core.rice.error.natives.IdentityErrorException;
import lombok.Data;

/**
 * <p>IdentityWorker</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:06 2020/1/13
 */

public class IdentityWorker {
    Long lastTime;
    Long lastTag;
    Long sequence;

    IdentityWorker(){
        this.lastTime = IdentityWorkerConfig.TIMESTAMP;
        this.lastTag = IdentityWorkerConfig.TAG;
        this.sequence = IdentityWorkerConfig.SEQUENCE;
    }

    public static IdentityWorker get() {
        return new IdentityWorkerArtificial();
    }

    public static IdentityWorker get(Long sequence) {
        return new IdentityWorkerArtificial(sequence);
    }

    public static IdentityWorker get(Long workerId, Long centerId) throws IdentityErrorException {
        return new IdentityWorkerMachine(workerId,centerId);
    }
}
