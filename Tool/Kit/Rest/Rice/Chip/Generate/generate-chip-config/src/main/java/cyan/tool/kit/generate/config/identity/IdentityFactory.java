package cyan.tool.kit.generate.config.identity;

import cyan.tool.kit.generate.core.error.IdentityWorkerException;
import cyan.tool.kit.generate.core.identity.worker.IdentityWorker;
import cyan.tool.kit.rice.core.rice.error.natives.IdentityErrorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>IdentityFactory</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:30 2020/1/13
 */
@Component
public class IdentityFactory {
    @Value("${tool.kit.generate.identity.workerId}")
    private static Long workerId;
    @Value("${tool.kit.generate.identity.centerId}")
    private static Long centerId;

    private static final Map<WorkerType,IdentityWorker> IDENTITY_WORKER_MAP = new HashMap<>();

    public static final WorkerType TAG_WORKER = WorkerType.TAG_WORKER;

    public static final WorkerType CENTER_WORKER = WorkerType.CENTER_WORKER;

    private static IdentityWorker identityWorker;

    private IdentityFactory() {
        identityWorker = IdentityWorker.get();
        if (IDENTITY_WORKER_MAP.containsKey(TAG_WORKER)) {
            IDENTITY_WORKER_MAP.replace(TAG_WORKER,identityWorker);
        } else {
            IDENTITY_WORKER_MAP.put(TAG_WORKER,identityWorker);
        }
    }

    public IdentityFactory(Long sequence) {
        identityWorker = IdentityWorker.get(sequence);
        if (IDENTITY_WORKER_MAP.containsKey(TAG_WORKER)) {
            IDENTITY_WORKER_MAP.replace(TAG_WORKER,identityWorker);
        } else {
            IDENTITY_WORKER_MAP.put(TAG_WORKER,identityWorker);
        }
    }

    private IdentityFactory(Long workerId, Long centerId) throws IdentityWorkerException {
        identityWorker = IdentityWorker.get(workerId,centerId);
        if (IDENTITY_WORKER_MAP.containsKey(CENTER_WORKER)) {
            IDENTITY_WORKER_MAP.replace(CENTER_WORKER,identityWorker);
        } else {
            IDENTITY_WORKER_MAP.put(CENTER_WORKER,identityWorker);
        }
    }

    private static IdentityFactory build(WorkerType workerType) throws IdentityWorkerException {
        if (workerType != null) {
            if (workerType == WorkerType.CENTER_WORKER) {
                return new IdentityFactory(workerId, centerId);
            } else {
                return new IdentityFactory();
            }
        } else {
            return new IdentityFactory();
        }
    }

    public static IdentityWorker worker(WorkerType workerType) throws IdentityWorkerException {
        IdentityWorker worker;
        if (workerType != null) {
            worker = IDENTITY_WORKER_MAP.get(workerType);
            if (worker == null) {
                worker = build(workerType).worker();
            }
        } else {
            worker = new IdentityFactory().worker();
        }
        return worker;
    }

    public IdentityWorker worker() {
        return identityWorker;
    }

    public enum WorkerType {
        TAG_WORKER,
        CENTER_WORKER
    }

}
