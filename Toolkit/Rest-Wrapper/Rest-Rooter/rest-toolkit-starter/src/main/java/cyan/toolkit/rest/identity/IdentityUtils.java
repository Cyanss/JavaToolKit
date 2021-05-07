package cyan.toolkit.rest.identity;

import cyan.toolkit.rest.identity.worker.WorkerType;

/**
 * <p>IdentityUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:59 2020/1/14
 */
public class IdentityUtils {

    public static Long generate(WorkerType workerType) {
        return IdentityFactory.getInstance().get(workerType).generate();
    }

    public static Long base() {
        return generate(WorkerType.BASE_WORKER);
    }

    public static Long common() {
        return generate(WorkerType.COMMON_WORKER);
    }

    public static Long offset() {
        return generate(WorkerType.OFFSET_WORKER);
    }

    public static Long sequence() {
        return generate(WorkerType.SEQUENCE_WORKER);
    }

    public static Long generate() {
        return generate(WorkerType.COMMON_WORKER);
    }


}
