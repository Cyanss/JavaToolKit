package cyan.toolkit.image.configure;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>ImageStarterProperties</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:46 2020/8/14
 */
@Component
@ConfigurationProperties(prefix = "cyan.toolkit.image")
public class ImageStarterProperties {
    private String active = "default";
    private String path = "/default/image";

    public ImageStarterProperties() {
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
