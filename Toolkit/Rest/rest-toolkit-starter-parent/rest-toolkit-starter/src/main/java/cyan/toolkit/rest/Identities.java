package cyan.toolkit.rest;

import cyan.toolkit.rest.identity.error.IdentityWorkerException;
import cyan.toolkit.rest.identity.worker.WorkerType;

/**
 * <p>Identities</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:58 2020/8/12
 */
public class Identities {

    public static Long generate(WorkerType workerType, Long offset)  {
        try {
            return Identity.generate(workerType,offset);
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Long generate() {
        try {
            return Identity.generate();
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Long generate(Long tag) {
        try {
            return Identity.generate(tag);
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
