package cyan.tool.kit.generate.core.identity.worker;

import cyan.tool.kit.generate.core.error.IdentityWorkerException;
import cyan.tool.kit.rice.core.rice.error.natives.IdentityErrorException;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>IdentityWorker</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:06 2020/1/13
 */

public interface IdentityWorker {

    Long generate(Long arg) throws IdentityWorkerException;

    static IdentityWorker get() {
        return new IdentityWorkerArtificial();
    }

    static IdentityWorker get(Long sequence) {
        return new IdentityWorkerArtificial(sequence);
    }

    static IdentityWorker get(Long workerId, Long centerId) throws IdentityWorkerException {
        return new IdentityWorkerMachine(workerId,centerId);
    }
}
