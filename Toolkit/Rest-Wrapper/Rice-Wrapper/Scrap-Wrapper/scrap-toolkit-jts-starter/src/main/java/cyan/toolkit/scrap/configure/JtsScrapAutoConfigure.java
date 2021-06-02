package cyan.toolkit.scrap.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>JtsScrapAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:18 2021/6/2
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.scrap"})
public class JtsScrapAutoConfigure {
    public JtsScrapAutoConfigure() {
        log.debug("================= jts-toolkit-scrap initiated ！ ===================");
    }
}
