package cyan.toolkit.zuul.route;

import cyan.toolkit.zuul.model.DynamicRoute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;

import java.util.Collection;

/**
 * <p>DiscoveryRouteLocator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:15 2021/6/9
 */
@Slf4j
public class DynamicRouteLocator extends DiscoveryClientRouteLocator implements InitializingBean {

    public DynamicRouteLocator(String servletPath, DiscoveryClient discovery, ZuulProperties properties, ServiceRouteMapper serviceRouteMapper, ServiceInstance localServiceInstance, RouteProperties routeProperties) {
        super(servletPath, discovery, properties, serviceRouteMapper, localServiceInstance);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        RouteManager.initiate(this);
        RouteManager.reload();
    }

    @Override
    public void addRoute(String path, String location) {
        RouteManager.addRoute(path, location);
    }

    @Override
    public void addRoute(ZuulProperties.ZuulRoute route) {
        RouteManager.addRoute(route);
    }

    public void addRoute(DynamicRoute routeModel) {
        RouteManager.addRoute(routeModel);
    }

    public void addRoutes(Collection<DynamicRoute> routes) {
        RouteManager.addRoutes(routes);
    }

    public void removeRoute(String route) {
        RouteManager.removeRoute(route);
    }

    public void removeRoutes(Collection<String> routes) {
        RouteManager.removeRoutes(routes);
    }

    public void addWhite(String white) {
        RouteManager.addWhite(white);
    }

    public void addWhites(Collection<String> whites) {
        RouteManager.addWhites(whites);
    }

    public void removeWhite(String white) {
        RouteManager.removeWhite(white);
    }

    public void removeWhites(Collection<String> whites) {
        RouteManager.removeWhites(whites);
    }

    @Override
    public void refresh() {
        RouteManager.refresh();
        super.refresh();
    }


}
