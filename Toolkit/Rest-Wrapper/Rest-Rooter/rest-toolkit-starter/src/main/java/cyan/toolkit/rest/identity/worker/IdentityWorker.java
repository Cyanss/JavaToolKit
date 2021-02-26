package cyan.toolkit.rest.identity.worker;



import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.identity.error.IdentityWorkerException;

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
    Map<WorkerType,IdentityWorker> IDENTITY_WORKER_MAP = new HashMap<>();

    Long generate();

    static IdentityWorker get(WorkerType workerType) {
       return IDENTITY_WORKER_MAP.get(workerType);
    }

    static IdentityWorker get() {
        if (IDENTITY_WORKER_MAP.containsKey(WorkerType.BASE_WORKER)) {
            return IDENTITY_WORKER_MAP.get(WorkerType.BASE_WORKER);
        } else {
            return new IdentityWorkerArtificial();
        }
    }

    static IdentityWorker get(Long offset) {
        if (IDENTITY_WORKER_MAP.containsKey(WorkerType.OFFSET_WORKER)) {
            return IDENTITY_WORKER_MAP.get(WorkerType.OFFSET_WORKER);
        } else {
            return new IdentityWorkerArtificial(offset);
        }
    }

    static IdentityWorker get(Long workerId, Long centerId) {
        if (IDENTITY_WORKER_MAP.containsKey(WorkerType.COMMON_WORKER)) {
            return IDENTITY_WORKER_MAP.get(WorkerType.COMMON_WORKER);
        } else {
            return new IdentityWorkerMachine(workerId, centerId);
        }
    }

    static IdentityWorker get(Long workerId, Long centerId, Long sequence) {
        if (IDENTITY_WORKER_MAP.containsKey(WorkerType.SEQUENCE_WORKER)) {
            return IDENTITY_WORKER_MAP.get(WorkerType.SEQUENCE_WORKER);
        } else {
            return new IdentityWorkerMachine(workerId, centerId, sequence);
        }
    }
}
