package cyan.toolkit.cloud.configure;

import cyan.toolkit.cloud.route.CloudDiscoveryLocator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.cloud.netflix.zuul.ZuulServerAutoConfiguration;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>CloudRouterAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:52 2021/6/1
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.cloud"})
public class CloudRouterAutoConfigure extends ZuulServerAutoConfiguration {
    private final EurekaRegistration registration;
    @Autowired
    private DiscoveryClient discovery;
    @Autowired
    private ServiceRouteMapper serviceRouteMapper;

    @Autowired(required = false)
    public CloudRouterAutoConfigure(@Qualifier("eurekaRegistration") EurekaRegistration registration) {
        log.debug("================= cloud-toolkit-router initiated ！ ===================");
        this.registration = registration;
    }

    @Bean
    public CloudDiscoveryLocator discoveryRouteLocator() {
        return new CloudDiscoveryLocator(this.server.getServlet().getContextPath(), this.discovery, this.zuulProperties, this.serviceRouteMapper, this.registration);
    }
}
