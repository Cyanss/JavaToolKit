package cyan.toolkit.rest.identity;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.configure.RestIdentityProperties;
import cyan.toolkit.rest.identity.error.IdentityWorkerException;
import cyan.toolkit.rest.identity.worker.IdentityWorker;
import cyan.toolkit.rest.identity.worker.WorkerType;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.rest.util.common.LoggerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IdentityFactory implements InitializingBean {

    @Autowired
    private RestIdentityProperties properties;

    private static IdentityFactory instance = null;

    public static IdentityFactory getInstance() {
        return instance;
    }

    public IdentityWorker get(WorkerType workerType) throws RestError {
        if (workerType != null) {
            IdentityWorker identityWorker = IdentityWorker.get(workerType);
            if (identityWorker != null) {
                return identityWorker;
            } else {
                LoggerUtils.error("identity worker maybe haven't initiated!");
                throw new RestError(IdentityErrorStatus.IDENTITY_WORKER_UNAVAILABLE);
            }
        } else {
            log.error("workerType cannot be null when getting identityWorker from it's!");
            throw new RestError(IdentityErrorStatus.WORKER_TYPE_IS_NULL);
        }
    }

    @Override
    public void afterPropertiesSet() {
        log.debug("identity properties: {}", JsonUtils.parseJson(properties));
        IdentityType type = properties.getType();
        IdentityWorker.get();
        if (IdentityType.SERVER == type) {
            Long sequence = properties.getServer().getSequence();
            IdentityWorker.get(sequence);
            LoggerUtils.warn("waiting for identity config to initiate!");
        } else {
            Long sequence = properties.getConfig().getSequence();
            IdentityWorker.get(sequence);
            Long workerId = properties.getConfig().getWorkerId();
            Long centerId = properties.getConfig().getCenterId();
            IdentityWorker.get(workerId, centerId);
        }
        instance = this;
    }
}
