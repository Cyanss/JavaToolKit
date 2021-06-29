package cyan.toolkit.token.configure;

import cyan.toolkit.token.route.DatabaseRouteLocator;
import cyan.toolkit.token.service.RouteService;
import cyan.toolkit.token.service.WhiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>ZuulDatabaseAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:52 2021/6/1
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.zuul"})
@MapperScan(basePackages={"cyan.toolkit.zuul.mapper"})
public class ZuulDatabaseAutoConfigure {
    public ZuulDatabaseAutoConfigure() {
        log.debug("================= zuul-toolkit-route-starter-database initiated ！ ===================");
    }

    @Bean
    @ConditionalOnMissingBean(DatabaseRouteLocator.class)
    @ConditionalOnProperty(name = {"cyan.toolkit.zuul.route.enabled"}, matchIfMissing = true)
    public DatabaseRouteLocator databaseRouteLocator(ServerProperties server, DiscoveryClient discovery, ZuulProperties zuulProperties,
                                                     ServiceRouteMapper serviceRouteMapper, Registration registration,
                                                     ZuulRouteProperties routeProperties, RouteService routeService, WhiteService whiteService) {
        return new DatabaseRouteLocator(server.getServlet().getContextPath(), discovery, zuulProperties, serviceRouteMapper, registration,routeProperties,routeService,whiteService);
    }
}
