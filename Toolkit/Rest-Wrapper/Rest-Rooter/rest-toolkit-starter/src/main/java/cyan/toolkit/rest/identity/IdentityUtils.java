package cyan.toolkit.rest.identity;

import cyan.toolkit.rest.identity.error.IdentityWorkerException;
import cyan.toolkit.rest.identity.worker.WorkerType;

/**
 * <p>IdentityHelper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:58 2020/8/12
 */
public class IdentityUtils {

    public static Long generate(WorkerType workerType, Long offset)  {
        try {
            return IdentityHelper.generate(workerType,offset);
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Long generate() {
        try {
            return IdentityHelper.generate();
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Long generate(Long tag) {
        try {
            return IdentityHelper.generate(tag);
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
