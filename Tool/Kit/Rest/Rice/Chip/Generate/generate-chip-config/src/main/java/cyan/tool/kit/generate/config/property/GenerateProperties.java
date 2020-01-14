package cyan.tool.kit.generate.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>GenerateProperties</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:19 2020/1/13
 */
@Data
@ConfigurationProperties(prefix = "tool.kit.generate.identity")
public class GenerateProperties {
    private Long workerId;
    private Long centerId;

    public GenerateProperties() {
    }
}
