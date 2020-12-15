package cyan.toolkit.rest.identity;

import cyan.toolkit.rest.identity.error.IdentityWorkerException;
import cyan.toolkit.rest.identity.worker.WorkerType;

/**
 * <p>IdentityUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:59 2020/1/14
 */
public class IdentityHelper {

    public static Long generate(WorkerType workerType, Long sequence) throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(workerType).generate(sequence);
    }

    public static Long generate(WorkerType workerType) throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(workerType).generate();
    }

    public static Long generate() throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(WorkerType.CENTER_WORKER).generate();
    }

    public static Long offset() throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(WorkerType.TAG_WORKER).generate();
    }

    public static Long offset(Long offset) throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(WorkerType.TAG_WORKER).generate(offset);
    }

    public static Long sequence() throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(WorkerType.TAG_SEQUENCE_WORKER).generate();
    }

    public static Long sequence(Long sequence) throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(WorkerType.TAG_SEQUENCE_WORKER).generate(sequence);
    }

}
