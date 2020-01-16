package cyan.tool.kit.generate.starter.identity;
import cyan.tool.kit.generate.starter.configure.GeneratePropertyConfigure;
import cyan.tool.kit.generate.starter.identity.worker.IdentityWorker;
import cyan.tool.kit.rice.core.rice.defaults.RestError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>IdentityFactory</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:30 2020/1/13
 */
@Slf4j
@Component
public class IdentityFactory {
    private static Long workerId = Long.parseLong(GeneratePropertyConfigure.getInstance().getProperty("cyan.tool.kit.generate.identity.workerId"));
    private static Long centerId = Long.parseLong(GeneratePropertyConfigure.getInstance().getProperty("cyan.tool.kit.generate.identity.centerId"));

    private static IdentityFactory instance = new IdentityFactory();

    public static IdentityFactory getInstance() {
        return instance;
    }

    private IdentityFactory() throws RestError {
        IdentityWorker.get();
        IdentityWorker.get(workerId,centerId);
    }

    public IdentityWorker get(IdentityWorker.WorkerType workerType) throws RestError {
        if (workerType != null) {
            return IdentityWorker.get(workerType);
        } else {
            log.error("workerType cannot be null when getting identityWorker from it's!");
            throw new RestError(IdentityErrorStatus.WORKER_TYPE_IS_NULL);
        }
    }

}
