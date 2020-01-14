package cyan.tool.kit.generate.config.identity;

import cyan.tool.kit.chip.core.chip.often.RiceRange;
import cyan.tool.kit.generate.core.error.IdentityWorkerException;
import cyan.tool.kit.rice.core.rice.error.natives.IdentityErrorException;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * <p>IdentityGenerate</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:59 2020/1/14
 */
public class IdentityGenerate {

    public static Long generate(IdentityFactory.WorkerType workerType, Long arg) throws IdentityWorkerException {
        return IdentityFactory.worker(workerType).generate(arg);
    }

    public static Long generate() throws IdentityWorkerException {
        return IdentityFactory.worker(IdentityFactory.CENTER_WORKER).generate(null);
    }

    public static Long generate(Long tag) throws IdentityWorkerException {
        return IdentityFactory.worker(IdentityFactory.TAG_WORKER).generate(tag);
    }

    public static synchronized String generateUuid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

}
