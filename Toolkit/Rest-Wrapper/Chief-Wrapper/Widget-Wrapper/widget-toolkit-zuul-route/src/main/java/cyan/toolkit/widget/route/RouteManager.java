package cyan.toolkit.widget.route;

import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.widget.configure.RouteProperties;
import cyan.toolkit.widget.model.DynamicRoute;
import cyan.toolkit.widget.service.RouteService;
import cyan.toolkit.widget.service.WhiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>RouteManager</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:59 2021/6/8
 */
@Slf4j
@Component
public class RouteManager implements InitializingBean {

    private static final Set<String> WHITE_LIST = new HashSet<>();

    private static final PathMatcher MATCHER = new AntPathMatcher();

    private static RouteManager instance = null;

    public static RouteManager getInstance() {
        return instance;
    }

    public static Set<String> getWhiteList() {
        return WHITE_LIST;
    }

    @Autowired
    private RouteService routeService;
    @Autowired
    private WhiteService whiteService;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private RouteProperties routeProperties;
    @Autowired
    private ZuulProperties zuulProperties;

    private RouteLocator routeLocator = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        RouteManager.instance = this;
        log.info("routeProperties: {}", JsonUtils.parseJson(routeProperties));
    }

    public synchronized static void initiate(RouteLocator routeLocator) {
        RouteManager.getInstance().routeLocator = routeLocator;
    }

    public synchronized static void doRefresh() {
        if (GeneralUtils.isNotEmpty(RouteManager.getInstance().routeLocator)) {
            RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(RouteManager.getInstance().routeLocator);
            RouteManager.getInstance().eventPublisher.publishEvent(routesRefreshedEvent);
        }
    }

    public synchronized static void refresh() {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (routeProperties.getEnable()) {
            List<String> updateWhiteList = null;
            List<String> removeWhiteList = null;
            List<DynamicRoute> updateRouteList = null;
            List<DynamicRoute> removeRouteList = null;
            RouteType routeType = routeProperties.getType();
            if (routeType == RouteType.POSTGRES || routeType == RouteType.MYSQL) {
                if (RouteManager.getInstance().whiteService.isNeedRefresh()) {
                    updateWhiteList = RouteManager.getInstance().whiteService.queryAllWithStatus(ZuulStatus.UPDATE);
                    removeWhiteList = RouteManager.getInstance().whiteService.queryAllWithStatus(ZuulStatus.REMOVE);
                }
                if (RouteManager.getInstance().routeService.isNeedRefresh()) {
                    updateRouteList = RouteManager.getInstance().routeService.queryAllWithStatus(ZuulStatus.UPDATE);
                    removeRouteList = RouteManager.getInstance().routeService.queryAllWithStatus(ZuulStatus.REMOVE);
                }
            }
            if (GeneralUtils.isNotEmpty(updateWhiteList)) {
                RouteManager.getWhiteList().addAll(updateWhiteList);
                log.info("the white list has refreshed {} whites !", updateWhiteList.size());
                Integer size = RouteManager.getInstance().whiteService.updateAll();
                log.info("the white list has updated {} whites !", size);
            }
            if (GeneralUtils.isNotEmpty(removeWhiteList)) {
                RouteManager.getWhiteList().removeAll(removeWhiteList);
                log.info("the white list has removed {} whites !", removeWhiteList.size());
                Integer size = RouteManager.getInstance().whiteService.removeAll();
                log.info("the white list has deleted {} whites !", size);
            }
            if (GeneralUtils.isNotEmpty(updateRouteList)) {
                Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = updateRouteList.stream().collect(Collectors.toMap(ZuulProperties.ZuulRoute::getPath, Function.identity()));
                RouteManager.getInstance().zuulProperties.getRoutes().putAll(zuulRouteMap);
                log.info("the route list has refreshed {} routes !", updateRouteList.size());
                Integer size = RouteManager.getInstance().routeService.updateAll();
                log.info("the route list has updated {} routes !", size);
            }
            if (GeneralUtils.isNotEmpty(removeRouteList)) {
                Map<String, ZuulProperties.ZuulRoute> routeList = RouteManager.getInstance().zuulProperties.getRoutes();
                AtomicBoolean isRemove = new AtomicBoolean(false);
                for (DynamicRoute dynamicRoute : removeRouteList) {
                    ZuulProperties.ZuulRoute remove = routeList.remove(dynamicRoute.getPath());
                    if (GeneralUtils.isNotEmpty(remove)) {
                        isRemove.set(true);
                        log.info("the route list has removed one, path: {}, location: {}", remove.getPath(), remove.getLocation());
                    }
                }
                if (isRemove.get()) {
                    Integer size = RouteManager.getInstance().routeService.removeAll();
                    log.info("the route list has deleted {} routes !", size);
                }
            }
        }
    }

    public synchronized static void reload() {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (routeProperties.getEnable()) {
            List<String> whiteList = null;
            List<DynamicRoute> dynamicRoutes = null;
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                whiteList = RouteManager.getInstance().whiteService.queryAllWithStatus(ZuulStatus.DEFAULT);
                dynamicRoutes = RouteManager.getInstance().routeService.queryAllWithStatus(ZuulStatus.DEFAULT);
            }
            if (GeneralUtils.isNotEmpty(whiteList)) {
                RouteManager.WHITE_LIST.addAll(whiteList);
                log.info("the white list has be initiated! size: {}", whiteList.size());
            }
            if (GeneralUtils.isNotEmpty(dynamicRoutes)) {
                Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = dynamicRoutes.stream().collect(Collectors.toMap(ZuulProperties.ZuulRoute::getPath, Function.identity()));
                RouteManager.getInstance().zuulProperties.getRoutes().putAll(zuulRouteMap);
                log.info("the route list has be initiated! size: {}", dynamicRoutes.size());
            }
        }
    }

    public synchronized static boolean existWhite(String white) {
        boolean exist = false;
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (GeneralUtils.isEmpty(RouteManager.WHITE_LIST) && routeProperties.getEnable()) {
            List<String> whiteList = null;
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                whiteList = RouteManager.getInstance().whiteService.queryAll(null);
            }
            if (GeneralUtils.isNotEmpty(whiteList)) {
                RouteManager.WHITE_LIST.addAll(whiteList);
                log.info("the white list has be initiated! size: {}", whiteList.size());
            }
        }
        if (GeneralUtils.isNotEmpty(RouteManager.WHITE_LIST)) {
            for (String path : RouteManager.WHITE_LIST) {
                if (MATCHER.isPattern(path)) {
                    exist = MATCHER.match(path, white);
                } else {
                    exist = path.equals(white);
                }
                if (exist) {
                    break;
                }
            }
        }
        return exist;
    }

    public synchronized static void addWhite(String white) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        String result;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            result = RouteManager.getInstance().whiteService.save(white);
        } else {
            result = white;
        }
        if (GeneralUtils.isNotEmpty(result)) {
            RouteManager.WHITE_LIST.add(result);
            log.info("the white list has added one, path: {}, the white list will be refreshed !", result);
        }
    }

    public synchronized static void addWhites(Collection<String> whites) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        Collection<String> resultList;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            resultList = RouteManager.getInstance().whiteService.saveAll(whites);
        } else {
            resultList = whites;
        }
        if (GeneralUtils.isNotEmpty(resultList)) {
            RouteManager.WHITE_LIST.addAll(resultList);
            log.info("the white list has added {} whites, the white list will be refreshed !", resultList.size());
        }
    }

    public synchronized static void removeWhite(String white) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (GeneralUtils.isNotEmpty(white)) {
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                RouteManager.getInstance().whiteService.deleteById(white);
            }
            RouteManager.WHITE_LIST.remove(white);
            log.info("the white list has removed one, path: {}, the white list will be refreshed !", white);
        }
    }

    public synchronized static void removeWhites(Collection<String> whites) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (GeneralUtils.isNotEmpty(whites)) {
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                RouteManager.getInstance().whiteService.deleteAll(whites);
            }
            RouteManager.WHITE_LIST.removeAll(whites);
            log.info("the white list has removed {} whites, the white list will be refreshed !", whites.size());
        }
    }

    public synchronized static void addRoute(String route, String location) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        DynamicRoute result;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            result = RouteManager.getInstance().routeService.save(new DynamicRoute(route, location));
        } else {
            result = new DynamicRoute(route, location);
        }
        if (GeneralUtils.isNotEmpty(result)) {
            RouteManager.getInstance().zuulProperties.getRoutes().put(result.getPath(), result);
            doRefresh();
            log.info("the route list has added one, path: {}, location: {}, the route list will be refreshed !", result.getPath(), result.getLocation());
        }
    }

    public synchronized static void addRoute(ZuulProperties.ZuulRoute zuulRoute) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        DynamicRoute result;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            result = RouteManager.getInstance().routeService.save(new DynamicRoute(zuulRoute.getPath(), zuulRoute.getLocation()));
        } else {
            result = new DynamicRoute(zuulRoute.getPath(), zuulRoute.getLocation());
        }
        if (GeneralUtils.isNotEmpty(result)) {
            RouteManager.getInstance().zuulProperties.getRoutes().put(result.getPath(), result);
            doRefresh();
            log.info("the route list has added one, path: {}, location: {}, the route list will be refreshed !", result.getPath(), result.getLocation());
        }
    }

    public synchronized static void addRoute(DynamicRoute dynamicRoute) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        DynamicRoute result;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            result = RouteManager.getInstance().routeService.save(dynamicRoute);
        } else {
            result = dynamicRoute;
        }
        if (GeneralUtils.isNotEmpty(result)) {
            RouteManager.getInstance().zuulProperties.getRoutes().put(result.getPath(), result);
            doRefresh();
            log.info("the route list has added one, path: {}, location: {}, the route list will be refreshed !", result.getPath(), result.getLocation());
        }
    }

    public synchronized static void addRoutes(Collection<DynamicRoute> routes) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        Collection<DynamicRoute> resultList;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            resultList = RouteManager.getInstance().routeService.saveAll(routes);
        } else {
            resultList = routes;
        }
        if (GeneralUtils.isNotEmpty(resultList)) {
            Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = resultList.stream().collect(Collectors.toMap(ZuulProperties.ZuulRoute::getPath, Function.identity()));
            RouteManager.getInstance().zuulProperties.getRoutes().putAll(zuulRouteMap);
            doRefresh();
            log.info("the route list has added {} routes, the route list will be refreshed !", resultList.size());
        }
    }

    public synchronized static void removeRoute(String route) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (GeneralUtils.isNotEmpty(route)) {
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                RouteManager.getInstance().routeService.deleteById(route);
            }
            Map<String, ZuulProperties.ZuulRoute> routeList = RouteManager.getInstance().zuulProperties.getRoutes();
            if (!routeList.isEmpty()) {
                ZuulProperties.ZuulRoute remove = routeList.remove(route);
                if (GeneralUtils.isNotEmpty(remove)) {
                    log.info("the route list has removed one, path: {}, location: {}", remove.getPath(), remove.getLocation());
                    doRefresh();
                    log.info("the route list will be refreshed !");
                }
            }
        }
    }

    public synchronized static void removeRoutes(Collection<String> routes) {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (GeneralUtils.isNotEmpty(routes)) {
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                RouteManager.getInstance().routeService.deleteAll(routes);
            }
            Map<String, ZuulProperties.ZuulRoute> routeList = RouteManager.getInstance().zuulProperties.getRoutes();
            if (!routes.isEmpty()) {
                AtomicBoolean isRemove = new AtomicBoolean(false);
                for (String route : routes) {
                    ZuulProperties.ZuulRoute remove = routeList.remove(route);
                    if (GeneralUtils.isNotEmpty(remove)) {
                        isRemove.set(true);
                        log.info("the route list has removed one, path: {}, location: {}", remove.getPath(), remove.getLocation());
                    }
                }
                if (isRemove.get()) {
                    doRefresh();
                    log.info("the route list will be refreshed !");
                }

            }
        }
    }


}
