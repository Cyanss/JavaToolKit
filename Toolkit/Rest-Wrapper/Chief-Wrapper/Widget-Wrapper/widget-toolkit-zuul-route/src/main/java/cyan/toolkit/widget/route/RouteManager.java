package cyan.toolkit.widget.route;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.widget.configure.RouteProperties;
import cyan.toolkit.widget.model.RouteModel;
import cyan.toolkit.widget.service.RouteService;
import cyan.toolkit.widget.service.WhiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
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
    private RouteLocator routeLocator;
    @Autowired
    private RouteProperties routeProperties;
    @Autowired
    private ZuulProperties zuulProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        RouteManager.instance = this;
        log.info("routeProperties: {}", JsonUtils.parseJson(routeProperties));
        reloadWhites();
        log.info("the white list will be initiated !");
        refreshRoutes();
        log.info("the route list will be initiated !");
    }

    public synchronized static void addWhite(String white) throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        String result;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            result = RouteManager.getInstance().whiteService.save(white);
        } else {
            result = white;
        }
        if (GeneralUtils.isNotEmpty(result)) {
            RouteManager.WHITE_LIST.add(result);
            log.info("the white list has added one, path: {}, the white list will be refreshed !",result);
        }
    }

    public synchronized static void addWhites(Collection<String> whites) throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        Collection<String> resultList;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            resultList = RouteManager.getInstance().whiteService.saveAll(whites);
        } else {
            resultList = whites;
        }
        if (GeneralUtils.isNotEmpty(resultList)) {
            RouteManager.WHITE_LIST.addAll(resultList);
            log.info("the white list has added {} whites, the white list will be refreshed !",resultList.size());
        }
    }

    public synchronized static void removeWhite(String white) throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (GeneralUtils.isNotEmpty(white)) {
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                RouteManager.getInstance().whiteService.deleteById(white);
            }
            RouteManager.WHITE_LIST.remove(white);
            log.info("the white list has removed one, path: {}, the white list will be refreshed !",white);
        }
    }

    public synchronized static void removeWhites(Collection<String> whites) throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (GeneralUtils.isNotEmpty(whites)) {
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                RouteManager.getInstance().whiteService.deleteAll(whites);
            }
            RouteManager.WHITE_LIST.removeAll(whites);
            log.info("the white list has removed {} whites, the white list will be refreshed !",whites.size());
        }
    }

    public synchronized static void addRoute(String route, String location) throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        RouteModel result;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            result = RouteManager.getInstance().routeService.save(new RouteModel(route, location));
        } else {
            result = new RouteModel(route, location);
        }
        if (GeneralUtils.isNotEmpty(result)) {
            refreshRoutes();
            log.info("the route list has added one, path: {}, location: {}, the route list will be refreshed !",result.getPath(),result.getLocation());
        }
    }

    public synchronized static void addRoute(ZuulProperties.ZuulRoute zuulRoute) throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        RouteModel result;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            result = RouteManager.getInstance().routeService.save(new RouteModel(zuulRoute.getPath(), zuulRoute.getLocation()));
        } else {
            result = new RouteModel(zuulRoute.getPath(), zuulRoute.getLocation());
        }
        if (GeneralUtils.isNotEmpty(result)) {
            refreshRoutes();
            log.info("the route list has added one, path: {}, location: {}, the route list will be refreshed !",result.getPath(),result.getLocation());
        }
    }

    public synchronized static void addRoute(RouteModel routeModel) throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        RouteModel result;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            result = RouteManager.getInstance().routeService.save(routeModel);
        } else {
            result = routeModel;
        }
        if (GeneralUtils.isNotEmpty(result)) {
            refreshRoutes();
            log.info("the route list has added one, path: {}, location: {}, the route list will be refreshed !",result.getPath(),result.getLocation());
        }
    }

    public synchronized static void addRoutes(Collection<RouteModel> routes) throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        Collection<RouteModel> resultList;
        if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
            resultList = RouteManager.getInstance().routeService.saveAll(routes);
        } else {
            resultList = routes;
        }
        if (GeneralUtils.isNotEmpty(resultList)) {
            refreshRoutes();
            log.info("the route list has added {} routes, the route list will be refreshed !",resultList.size());
        }
    }

    public synchronized static void removeRoute(String route) throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (GeneralUtils.isNotEmpty(route)) {
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                RouteManager.getInstance().routeService.deleteById(route);
            }
            Map<String, ZuulProperties.ZuulRoute> routeList = RouteManager.getInstance().zuulProperties.getRoutes();
            if (!routeList.isEmpty()) {
                ZuulProperties.ZuulRoute remove = routeList.remove(route);
                if (GeneralUtils.isNotEmpty(remove)) {
                    log.info("the route list has removed one, path: {}, location: {}",remove.getPath(),remove.getLocation());
                    RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(RouteManager.getInstance().routeLocator);
                    RouteManager.getInstance().eventPublisher.publishEvent(routesRefreshedEvent);
                    log.info("the route list will be refreshed !");
                }
            }
        }
    }

    public synchronized static void removeRoutes(Collection<String> routes) throws RestException {
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
                    RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(RouteManager.getInstance().routeLocator);
                    RouteManager.getInstance().eventPublisher.publishEvent(routesRefreshedEvent);
                    log.info("the route list will be refreshed !");
                }

            }
        }
    }

    public synchronized static void refreshRoutes() throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (routeProperties.getEnable()) {
            List<RouteModel> routeModels = null;
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                routeModels = RouteManager.getInstance().routeService.queryAllNew();
            }
            if (GeneralUtils.isNotEmpty(routeModels)) {
                Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = routeModels.stream().collect(Collectors.toMap(ZuulProperties.ZuulRoute::getPath, Function.identity()));
                RouteManager.getInstance().zuulProperties.getRoutes().putAll(zuulRouteMap);
            }
        }
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(RouteManager.getInstance().routeLocator);
        RouteManager.getInstance().eventPublisher.publishEvent(routesRefreshedEvent);
    }


    public synchronized static void reloadWhites() throws RestException {
        RouteProperties routeProperties = RouteManager.getInstance().routeProperties;
        if (routeProperties.getEnable()) {
            List<String> whiteList = null;
            if (routeProperties.getType() == RouteType.POSTGRES || routeProperties.getType() == RouteType.MYSQL) {
                whiteList = RouteManager.getInstance().whiteService.queryAllNew();
            }
            if (GeneralUtils.isNotEmpty(whiteList)) {
                RouteManager.WHITE_LIST.addAll(whiteList);
            }
        }
    }

    public synchronized static boolean existWhite(String white) throws RestException {
        boolean exist = false;
        if (GeneralUtils.isEmpty(RouteManager.WHITE_LIST)) {
            reloadWhites();
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
}
