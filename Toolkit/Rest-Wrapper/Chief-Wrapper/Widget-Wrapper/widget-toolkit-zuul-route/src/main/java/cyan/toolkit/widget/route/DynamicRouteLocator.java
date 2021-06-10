package cyan.toolkit.widget.route;

import cyan.toolkit.widget.configure.RouteProperties;
import cyan.toolkit.widget.model.WidgetRoute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>DiscoveryRouteLocator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:15 2021/6/9
 */
@Slf4j
public class DynamicRouteLocator extends DiscoveryClientRouteLocator implements InitializingBean {

    private ZuulProperties zuulProperties;

    public DynamicRouteLocator(String servletPath, DiscoveryClient discovery, ZuulProperties properties, ServiceRouteMapper serviceRouteMapper, ServiceInstance localServiceInstance, RouteProperties routeProperties) {
        super(servletPath, discovery, properties, serviceRouteMapper, localServiceInstance);
        this.zuulProperties = properties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
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

    public void addRoute(WidgetRoute routeModel) {
        RouteManager.addRoute(routeModel);
    }

    public void addRoutes(Collection<WidgetRoute> routes) {
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
    protected LinkedHashMap<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        routesMap.putAll(super.locateRoutes());
        routesMap.putAll(super.locateRoutes());
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routesMap.entrySet()) {
            String path = entry.getKey();
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (StringUtils.hasText(this.zuulProperties.getPrefix())) {
                path = this.zuulProperties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, entry.getValue());
        }
        return values;
    }

    @Override
    public void refresh() {
        RouteManager.refresh();
        super.refresh();
    }


}
