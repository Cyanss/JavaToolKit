package cyan.tool.kit.generate.starter.configure;

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
@ComponentScan(basePackages = {"cyan.tool.kit.generate.starter"})
public class GenerateAutoConfigure {
    public GenerateAutoConfigure() {
    }
}
