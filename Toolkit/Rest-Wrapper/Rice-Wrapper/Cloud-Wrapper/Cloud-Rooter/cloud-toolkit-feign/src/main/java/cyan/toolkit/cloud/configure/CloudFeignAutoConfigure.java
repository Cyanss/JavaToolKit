package cyan.toolkit.cloud.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>CloudFeignAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:39 2020/8/14
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.cloud"})
public class CloudFeignAutoConfigure {
    public CloudFeignAutoConfigure() {
        log.debug("================= cloud-toolkit-feign initiated ！ ===================");
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
