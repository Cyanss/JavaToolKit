package cyan.toolkit.zuul.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * <p>ZuulRouterProperties</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:15 2021/6/1
 */
@Component
@ConfigurationProperties(prefix = "cyan.toolkit.zuul.route")
public class ZuulRouteProperties {
    private Boolean enabled = true;
    private Set<String> whites;

    public ZuulRouteProperties() {
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<String> getWhites() {
        return whites;
    }

    public void setWhites(Set<String> whites) {
        this.whites = whites;
    }
}
