package cyan.toolkit.javafx.configure;

import cyan.toolkit.rest.interceptor.RestHttpInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>JavaFxStarterAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:18 2020/1/13
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.javafx"})
public class JavaFxStarterAutoConfigure {

    @Autowired
    private JavaFxStarterProperties properties;
    @Autowired
    private RestHttpInterceptor httpInterceptor;

    public JavaFxStarterAutoConfigure() {
        log.debug("================= cloud-toolkit-starter initiated ！ ===================");
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        JavaFxStarterProperties.RestInfo restInfo = properties.getRestInfo();
        if (restInfo.getEnable()) {
            restTemplate.getInterceptors().add(httpInterceptor);
        }
        return restTemplate;
    }
}
