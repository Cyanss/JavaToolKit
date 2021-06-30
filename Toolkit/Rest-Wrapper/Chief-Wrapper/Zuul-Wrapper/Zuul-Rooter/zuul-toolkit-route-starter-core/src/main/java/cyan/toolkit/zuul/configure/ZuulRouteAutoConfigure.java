package cyan.toolkit.zuul.configure;

import cyan.toolkit.zuul.DynamicRouteLocator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>ZuulRouteAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:57 2021/6/24
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = {"cyan.toolkit.zuul.route.enabled"}, matchIfMissing = true)
public class ZuulRouteAutoConfigure {

    @Bean
    @ConditionalOnMissingBean(DynamicRouteLocator.class)
    @ConditionalOnProperty(name = {"cyan.toolkit.zuul.route.enabled"}, matchIfMissing = true)
    public DynamicRouteLocator dynamicRouteLocator(ServerProperties server, DiscoveryClient discovery, ZuulProperties zuulProperties,
                                                   ServiceRouteMapper serviceRouteMapper, Registration registration,
                                                   ZuulRouteProperties routeProperties) {
        return new DynamicRouteLocator(server.getServlet().getContextPath(), discovery, zuulProperties, serviceRouteMapper, registration,routeProperties);
    }
}
