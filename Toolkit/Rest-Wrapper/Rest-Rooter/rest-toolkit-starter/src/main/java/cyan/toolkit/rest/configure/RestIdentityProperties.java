package cyan.toolkit.rest.configure;

import cyan.toolkit.rest.error.supply.ParamMissingException;
import cyan.toolkit.rest.identity.IdentityType;
import cyan.toolkit.rest.util.common.GeneralUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * <p>IdentityProperties</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:32 2020/1/16
 */
@Component
@ConfigurationProperties(prefix = "cyan.toolkit.identity")
public class RestIdentityProperties {
    private IdentityType type = IdentityType.CONFIG;
    @NestedConfigurationProperty
    private Config config;
    @NestedConfigurationProperty
    private Server server;

    public RestIdentityProperties() {
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public IdentityType getType() {
        return type;
    }

    public void setType(IdentityType type) {
        this.type = type;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public static class Server {
        private Long sequence = System.currentTimeMillis();
        private String url;
        private String api;

        public Server() {
        }

        public Long getSequence() {
            return sequence;
        }

        public void setSequence(Long sequence) {
            this.sequence = sequence;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getApi() {
            return api;
        }

        public void setApi(String api) {
            this.api = api;
        }

        public String uri() throws ParamMissingException {
            if (GeneralUtils.isNotEmpty(url)) {
                return url.concat(api);
            } else {
                throw new ParamMissingException("cyan.toolkit.identity.server.url");
            }

        }
    }

    public static class Config {
        private Long workerId = 1L;
        private Long centerId = 2L;
        private Long sequence = System.currentTimeMillis();
        public Config() {
        }

        public Long getWorkerId() {
            return workerId;
        }

        public void setWorkerId(Long workerId) {
            this.workerId = workerId;
        }

        public Long getCenterId() {
            return centerId;
        }

        public void setCenterId(Long centerId) {
            this.centerId = centerId;
        }

        public Long getSequence() {
            return sequence;
        }

        public void setSequence(Long sequence) {
            this.sequence = sequence;
        }
    }
}
