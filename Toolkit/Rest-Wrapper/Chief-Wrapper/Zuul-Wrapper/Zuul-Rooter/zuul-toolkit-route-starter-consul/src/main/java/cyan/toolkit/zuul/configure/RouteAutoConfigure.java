package cyan.toolkit.zuul.configure;

import cyan.toolkit.zuul.route.DynamicNacosListener;
import cyan.toolkit.zuul.route.DynamicRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>DynamicRouteAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:12 2021/6/11
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = {"cyan.toolkit.widget.zuul.route.enable"}, matchIfMissing = true)
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

    @Bean
    @ConditionalOnMissingBean(DynamicRouteLocator.class)
    public DynamicRouteLocator dynamicRouteLocator(ServiceRouteMapper serviceRouteMapper) {
        return new DynamicRouteLocator(this.server.getServlet().getContextPath(), this.discovery, this.zuulProperties, serviceRouteMapper, this.registration,this.routeProperties);
    }

    @Bean
    @ConditionalOnProperty(name = {"cyan.toolkit.widget.zuul.route.type"}, havingValue = "NACOS", matchIfMissing = true)
    @ConditionalOnMissingBean(DynamicNacosListener.class)
    public DynamicNacosListener dynamicNacosListener(ContextRefresher contextRefresher) {
        return new DynamicNacosListener(contextRefresher);
    }

}
