package cyan.toolkit.widget.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>ZuulRouterProperties</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:15 2021/6/1
 */
@Component
@ConfigurationProperties(prefix = "cyan.toolkit.widget.zuul.router")
public class ZuulRouterProperties {
    private Boolean enable = true;

    public ZuulRouterProperties() {
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
