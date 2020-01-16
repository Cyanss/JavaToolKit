package cyan.tool.kit.generate.starter.identity;

import cyan.tool.kit.generate.starter.error.IdentityWorkerException;
import cyan.tool.kit.generate.starter.identity.worker.IdentityWorker;

import java.util.UUID;

/**
 * <p>IdentityGenerate</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:59 2020/1/14
 */
public class IdentityGenerate {

    public static Long generate(IdentityWorker.WorkerType workerType, Long arg) throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(workerType).generate(arg);
    }

    public static Long generate() throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(IdentityWorker.WorkerType.CENTER_WORKER).generate(null);
    }

    public static Long generate(Long tag) throws IdentityWorkerException {
        return IdentityFactory.getInstance().get(IdentityWorker.WorkerType.TAG_WORKER).generate(tag);
    }

    public static synchronized String generateUuid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

}
