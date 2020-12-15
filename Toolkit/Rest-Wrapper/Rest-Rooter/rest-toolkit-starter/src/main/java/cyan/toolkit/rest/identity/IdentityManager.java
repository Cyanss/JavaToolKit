package cyan.toolkit.rest.identity;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.RestTemplates;
import cyan.toolkit.rest.configure.RestIdentityProperties;
import cyan.toolkit.rest.helper.OptionalHelper;
import cyan.toolkit.rest.identity.error.IdentityWorkerException;
import cyan.toolkit.rest.identity.worker.IdentityWorker;
import cyan.toolkit.rest.identity.worker.WorkerConfig;
import cyan.toolkit.rest.util.common.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

/**
 * <p>IdentityManager</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:22 2020/12/15
 */
@Slf4j
@Component
public class IdentityManager implements InitializingBean, ApplicationRunner {

    @Autowired
    private RestIdentityProperties identityProperties;

    @Autowired
    private Environment environment;

    private static IdentityManager instance = null;

    public static IdentityManager getInstance() {
        return instance;
    }

    public static Environment getEnvironment() {
        return IdentityManager.getInstance().environment;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (IdentityType.SERVER == identityProperties.getType()) {
            WorkerConfig workerConfig = workerConfig();
            OptionalHelper.nullable(workerConfig,"the worker config is parse error",IdentityWorkerException::new);
            log.debug("worker config: {}", JsonUtils.parseJson(workerConfig));
            IdentityManager.config(workerConfig);
        }
    }

    public static void config(@NonNull Long workerId, @NonNull Long centerId) throws RestError {
        IdentityWorker.get(workerId, centerId);
    }

    public static void config(WorkerConfig config) throws RestError {
        IdentityManager.config(config.getWorkerId(), config.getCenterId());
    }

    public static ServerConfig serverConfig() {
        String ip = IdentityManager.getEnvironment().getProperty(ServerConfig.IP_ADDRESS);
        String port = IdentityManager.getEnvironment().getProperty(ServerConfig.SERVER_PORT);
        String name = IdentityManager.getEnvironment().getProperty(ServerConfig.APP_NAME);
        return ServerConfig.builder().ip(ip).port(port).name(name).build();
    }

    public static WorkerConfig workerConfig() throws RestException {
        String server = IdentityManager.serverConfig().toServer();
        MultiValueMap<String, String> serverId = RestTemplates.singletonMap("serverId", server);
        String response = RestTemplates.get(IdentityManager.getInstance().identityProperties.getServer().uri(), serverId);
        OptionalHelper.nullable(response,"the worker config is got failed from server",IdentityWorkerException::new);
        return RestTemplates.parser(response, WorkerConfig.class);
    }


}
