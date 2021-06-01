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
    private Boolean enable = false;
    private Boolean logEnable = false;
    private Boolean beanEnable = false;

    public RestInterceptProperties() {
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getLogEnable() {
        return logEnable;
    }

    public void setLogEnable(Boolean logEnable) {
        this.logEnable = logEnable;
    }

    public Boolean getBeanEnable() {
        return beanEnable;
    }

    public void setBeanEnable(Boolean beanEnable) {
        this.beanEnable = beanEnable;
    }
}
