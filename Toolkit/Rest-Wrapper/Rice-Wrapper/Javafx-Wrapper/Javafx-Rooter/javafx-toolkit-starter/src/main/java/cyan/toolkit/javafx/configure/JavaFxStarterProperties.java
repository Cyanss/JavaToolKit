package cyan.toolkit.javafx.configure;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
    private String localCache = "/local/local-cache.properties";

    public JavaFxStarterProperties() {
    }

    public String getLocalCache() {
        return localCache;
    }

    public void setLocalCache(String localCache) {
        this.localCache = localCache;
    }
}
