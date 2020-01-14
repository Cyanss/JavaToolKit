package cyan.tool.kit.generate.config.auto;

import cyan.tool.kit.generate.config.property.GenerateProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>GenerateAutoConfig</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:18 2020/1/13
 */
@Configuration
@ComponentScan(basePackages = {"cyan.tool.kit.generate.config"})
@EnableConfigurationProperties({GenerateProperties.class})
@ConditionalOnProperty(
        prefix = "tool.kit.generate.identity",
        name = {"workerId","centerId"}
)
public class GenerateAutoConfig {
    public GenerateAutoConfig() {
    }
}
