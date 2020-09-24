package cyan.toolkit.javafx.configure;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * <p>JavaFxStarterProperties</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:46 2020/8/14
 */
@Component
@ConfigurationProperties(prefix = "cyan.toolkit.javafx")
public class JavaFxStarterProperties {
    @NestedConfigurationProperty
    private LocalCache localCache;
    @NestedConfigurationProperty
    private RestInfo restInfo;

    public JavaFxStarterProperties() {
    }

    public static class LocalCache {
        private String path = "/local-cache.properties";

        public LocalCache() {
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

    public static class RestInfo {
        private Boolean enable = false;

        public RestInfo() {
        }

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }
    }


    public LocalCache getLocalCache() {
        return localCache;
    }

    public void setLocalCache(LocalCache localCache) {
        this.localCache = localCache;
    }

    public RestInfo getRestInfo() {
        return restInfo;
    }

    public void setRestInfo(RestInfo restInfo) {
        this.restInfo = restInfo;
    }
}
