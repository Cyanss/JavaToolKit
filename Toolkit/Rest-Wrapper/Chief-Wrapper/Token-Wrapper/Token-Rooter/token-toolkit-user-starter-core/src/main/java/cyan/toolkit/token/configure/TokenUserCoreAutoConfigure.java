package cyan.toolkit.token.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>TokenUserCoreAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:52 2021/6/1
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.token"})
public class TokenUserCoreAutoConfigure {
    public TokenUserCoreAutoConfigure() {
        log.debug("================= token-toolkit-user-starter-core initiated ！ ===================");
    }
}
