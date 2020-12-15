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

    public static Long generate(WorkerType workerType)  {
        try {
            return IdentityHelper.generate(workerType);
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

    public static Long offset() {
        try {
            return IdentityHelper.offset();
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Long offset(Long offset) {
        try {
            return IdentityHelper.offset(offset);
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Long sequence() {
        try {
            return IdentityHelper.sequence();
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Long sequence(Long sequence) {
        try {
            return IdentityHelper.sequence(sequence);
        } catch (IdentityWorkerException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
