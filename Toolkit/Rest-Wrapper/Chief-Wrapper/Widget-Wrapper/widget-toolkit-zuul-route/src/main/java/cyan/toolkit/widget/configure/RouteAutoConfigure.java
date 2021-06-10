package cyan.toolkit.widget.configure;

import cyan.toolkit.widget.route.DynamicRouteLocator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>ZuulRouterAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:52 2021/6/1
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.widget"})
@MapperScan(basePackages={"cyan.toolkit.widget.mapper"})
public class RouteAutoConfigure {
    @Autowired
    @Qualifier("eurekaRegistration")
    private Registration registration;

    @Autowired
    private DiscoveryClient discovery;

    @Autowired
    protected ServerProperties server;

    @Autowired
    protected ZuulProperties zuulProperties;

    @Autowired
    private RouteProperties routeProperties;

    public RouteAutoConfigure() {
        log.debug("================= widget-toolkit-zuul-route initiated ！ ===================");
    }

    @Bean
    @ConditionalOnBean(DynamicRouteLocator.class)
    @ConditionalOnMissingBean(DiscoveryClientRouteLocator.class)
    public DynamicRouteLocator widgetRouteLocator(ServiceRouteMapper serviceRouteMapper) {
        return new DynamicRouteLocator(this.server.getServlet().getContextPath(), this.discovery, this.zuulProperties, serviceRouteMapper, this.registration,this.routeProperties);
    }

}
