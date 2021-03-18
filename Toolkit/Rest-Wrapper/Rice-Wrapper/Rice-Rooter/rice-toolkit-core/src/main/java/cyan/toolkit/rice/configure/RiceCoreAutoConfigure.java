package cyan.toolkit.rice.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>RiceStarterAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:18 2020/1/13
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.rice"})
public class RiceCoreAutoConfigure {
    public RiceCoreAutoConfigure() {
        log.debug("================= rice-toolkit-core initiated ！ ===================");
    }
}
