package cyan.toolkit.widget.route;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>ZuulRouterDiscoveryLocator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:12 2021/6/1
 */
@Slf4j
public class ZuulRouterDiscoveryLocator extends DiscoveryClientRouteLocator {

    public ZuulRouterDiscoveryLocator(String servletPath, DiscoveryClient discovery, ZuulProperties properties, ServiceInstance localServiceInstance) {
        super(servletPath, discovery, properties, localServiceInstance);
    }

    public ZuulRouterDiscoveryLocator(String servletPath, DiscoveryClient discovery, ZuulProperties properties, ServiceRouteMapper serviceRouteMapper, ServiceInstance localServiceInstance) {
        super(servletPath, discovery, properties, serviceRouteMapper, localServiceInstance);
    }

    public void addRoutes(Collection<ZuulProperties.ZuulRoute> routes) {
        Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = routes.stream().collect(Collectors.toMap(ZuulProperties.ZuulRoute::getPath, Function.identity()));
        addConfiguredRoutes(zuulRouteMap);
    }
}
