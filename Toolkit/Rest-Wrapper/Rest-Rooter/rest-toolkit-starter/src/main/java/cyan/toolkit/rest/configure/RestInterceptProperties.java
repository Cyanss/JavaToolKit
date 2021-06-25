package cyan.toolkit.rest.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>IdentityProperties</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:32 2020/1/16
 */
@Component
@ConfigurationProperties(prefix = "cyan.toolkit.rest.intercept")
public class RestInterceptProperties {
    private Boolean enabled = false;
    private Boolean logEnabled = false;
    private Boolean beanEnabled = false;

    public RestInterceptProperties() {
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLogEnabled() {
        return logEnabled;
    }

    public void setLogEnabled(Boolean logEnabled) {
        this.logEnabled = logEnabled;
    }

    public Boolean getBeanEnabled() {
        return beanEnabled;
    }

    public void setBeanEnabled(Boolean beanEnabled) {
        this.beanEnabled = beanEnabled;
    }
}
