package cyan.toolkit.chief.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * <p>RestExceptionProperties</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:50 2021/7/2
 */
@Component
@ConfigurationProperties(prefix = "cyan.toolkit.chief.name")
public class ChiefNameProperties {
    private Boolean uniqueEnabled = true;

    private Boolean nonullEnabled = true;

    public ChiefNameProperties() {
    }

    public Boolean getUniqueEnabled() {
        return uniqueEnabled;
    }

    public void setUniqueEnabled(Boolean uniqueEnabled) {
        this.uniqueEnabled = uniqueEnabled;
    }

    public Boolean getNonullEnabled() {
        return nonullEnabled;
    }

    public void setNonullEnabled(Boolean nonullEnabled) {
        this.nonullEnabled = nonullEnabled;
    }
}
