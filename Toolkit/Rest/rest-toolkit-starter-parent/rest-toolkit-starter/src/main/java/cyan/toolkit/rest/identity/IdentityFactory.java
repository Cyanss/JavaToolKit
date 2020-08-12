package cyan.toolkit.rest.identity;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.configure.IdentityProperties;
import cyan.toolkit.rest.identity.error.IdentityWorkerException;
import cyan.toolkit.rest.identity.worker.IdentityWorker;
import cyan.toolkit.rest.identity.worker.WorkerType;
import cyan.toolkit.rest.util.EmptyUtils;
import cyan.toolkit.rest.util.JsonUtils;
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
    private IdentityProperties properties;

    private static IdentityFactory instance = null;

    public static IdentityFactory getInstance() {
        return instance;
    }

    public IdentityWorker get(WorkerType workerType) throws RestError {
        if (workerType != null) {
            return IdentityWorker.get(workerType);
        } else {
            log.error("workerType cannot be null when getting identityWorker from it's!");
            throw new RestError(IdentityErrorStatus.WORKER_TYPE_IS_NULL);
        }
    }

    @Override
    public void afterPropertiesSet() {
        log.debug("identity properties: {}", JsonUtils.parserJson(properties));
        IdentityWorker.get();
        IdentityWorker.get(properties.getWorkerId(),properties.getCenterId());
        instance = this;
    }
}
