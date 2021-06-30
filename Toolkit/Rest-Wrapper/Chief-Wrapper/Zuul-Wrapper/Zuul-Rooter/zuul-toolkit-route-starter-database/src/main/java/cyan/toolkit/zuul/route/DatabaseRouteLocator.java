package cyan.toolkit.zuul.route;

import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.zuul.DynamicRoute;
import cyan.toolkit.zuul.DynamicRouteLocator;
import cyan.toolkit.zuul.configure.ZuulRouteProperties;
import cyan.toolkit.zuul.service.RouteService;
import cyan.toolkit.zuul.service.WhiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>DiscoveryRouteLocator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:15 2021/6/9
 */
@Slf4j
public class DatabaseRouteLocator extends DynamicRouteLocator {
    private RouteService routeService;
    private WhiteService whiteService;
    
    public DatabaseRouteLocator(String servletPath, DiscoveryClient discovery, ZuulProperties properties, ServiceRouteMapper serviceRouteMapper, ServiceInstance localServiceInstance, ZuulRouteProperties routeProperties,RouteService routeService,WhiteService whiteService) {
        super(servletPath, discovery, properties, serviceRouteMapper, localServiceInstance, routeProperties);
        this.routeService = routeService;
        this.whiteService = whiteService;
    }

    @Override
    public void loadWhites() {
        if (routeProperties.getEnabled()) {
            List<String> whiteList = whiteService.queryAllWithStatus(RouteType.DEFAULT);
            if (GeneralUtils.isNotEmpty(whiteList)) {
                routeProperties.getWhites().addAll(whiteList);
                log.info("the white list has be initiated! size: {}", whiteList.size());
            }
        }
    }

    @Override
    public void loadRoutes() {
        if (routeProperties.getEnabled()) {
            List<DynamicRoute> dynamicRoutes = routeService.queryAllWithStatus(RouteType.DEFAULT);
            if (GeneralUtils.isNotEmpty(dynamicRoutes)) {
                Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = dynamicRoutes.stream().collect(Collectors.toMap(ZuulProperties.ZuulRoute::getPath, Function.identity()));
                zuulProperties.getRoutes().putAll(zuulRouteMap);
                log.info("the route list has be initiated! size: {}", dynamicRoutes.size());
            }
        }
    }

    @Override
    public void addRoute(String path, String location) {
        DynamicRoute result = routeService.save(new DynamicRoute(path, location));
        super.addRoute(result);
    }

    @Override
    public void addRoute(ZuulProperties.ZuulRoute route) {
        DynamicRoute result = routeService.save(new DynamicRoute(route.getPath(), route.getLocation()));
        super.addRoute(result);
    }

    @Override
    public void addRoute(DynamicRoute routeModel) {
        DynamicRoute result = routeService.save(routeModel);
        super.addRoute(result);
    }

    @Override
    public void addRoutes(Collection<DynamicRoute> routes) {
        Collection<DynamicRoute> resultList = routeService.saveAll(routes);
        super.addRoutes(resultList);
    }

    @Override
    public void removeRoute(String route) {
        routeService.deleteById(route);
        super.removeRoute(route);
    }

    @Override
    public void removeRoutes(Collection<String> routes) {
        routeService.deleteAll(routes);
        super.removeRoutes(routes);
    }

    @Override
    public void addWhite(String white) {
        String result = whiteService.save(white);
        super.addWhite(result);
    }

    @Override
    public void addWhites(Collection<String> whites) {
        Collection<String> resultList = whiteService.saveAll(whites);
        super.addWhites(resultList);
    }

    @Override
    public void removeWhite(String white) {
        whiteService.deleteById(white);
        super.removeWhite(white);
    }

    @Override
    public void removeWhites(Collection<String> whites) {
        whiteService.deleteAll(whites);
        super.removeWhites(whites);
    }

    @Override
    protected void refreshWhites() {
        List<String> updateWhiteList = null;
        List<String> removeWhiteList = null;
        if (whiteService.isNeedRefresh()) {
            updateWhiteList = whiteService.queryAllWithStatus(RouteType.UPDATE);
            removeWhiteList = whiteService.queryAllWithStatus(RouteType.REMOVE);
        }
        if (GeneralUtils.isNotEmpty(updateWhiteList)) {
            routeProperties.getWhites().addAll(updateWhiteList);
            log.info("the white list has refreshed {} whites !", updateWhiteList.size());
            Integer size = whiteService.updateAll();
            log.info("the white list has updated {} whites !", size);
        }
        if (GeneralUtils.isNotEmpty(removeWhiteList)) {
            routeProperties.getWhites().removeAll(removeWhiteList);
            log.info("the white list has removed {} whites !", removeWhiteList.size());
            Integer size = whiteService.removeAll();
            log.info("the white list has deleted {} whites !", size);
        }
    }

    @Override
    protected void refreshRoutes() {
        List<DynamicRoute> updateRouteList = null;
        List<DynamicRoute> removeRouteList = null;
        if (routeService.isNeedRefresh()) {
            updateRouteList = routeService.queryAllWithStatus(RouteType.UPDATE);
            removeRouteList = routeService.queryAllWithStatus(RouteType.REMOVE);
        }
        if (GeneralUtils.isNotEmpty(updateRouteList)) {
            Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = updateRouteList.stream().collect(Collectors.toMap(ZuulProperties.ZuulRoute::getPath, Function.identity()));
            zuulProperties.getRoutes().putAll(zuulRouteMap);
            log.info("the route list has refreshed {} routes !", updateRouteList.size());
            Integer size = routeService.updateAll();
            log.info("the route list has updated {} routes !", size);
        }
        if (GeneralUtils.isNotEmpty(removeRouteList)) {
            Map<String, ZuulProperties.ZuulRoute> routeList = zuulProperties.getRoutes();
            if (!routeList.isEmpty()) {
                List<String> routes = removeRouteList.stream().map(DynamicRoute::getPath).collect(Collectors.toList());
                AtomicBoolean isRemove = atomicRemoveRoutes(routes,routeList);
                if (isRemove.get()) {
                    Integer size = routeService.removeAll();
                    log.info("the route list has deleted {} routes !", size);
                }
            }
        }
    }
}
