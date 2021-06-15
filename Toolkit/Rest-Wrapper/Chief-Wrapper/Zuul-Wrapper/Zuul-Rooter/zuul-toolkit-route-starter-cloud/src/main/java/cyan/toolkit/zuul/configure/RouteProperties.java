package cyan.toolkit.zuul.configure;

import cyan.toolkit.zuul.route.RouteType;
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
public class RouteProperties {
    private Boolean enable = true;
    private RouteType type = RouteType.LOCAL;
    private Set<String> whites;

    public RouteProperties() {
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public RouteType getType() {
        return type;
    }

    public void setType(RouteType type) {
        this.type = type;
    }

    public Set<String> getWhites() {
        return whites;
    }

    public void setWhites(Set<String> whites) {
        this.whites = whites;
    }
}
