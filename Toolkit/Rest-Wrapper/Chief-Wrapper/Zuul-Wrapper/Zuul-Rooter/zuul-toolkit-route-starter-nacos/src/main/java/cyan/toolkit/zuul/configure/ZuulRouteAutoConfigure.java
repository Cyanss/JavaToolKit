package cyan.toolkit.zuul.configure;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import cyan.toolkit.zuul.route.NacosRouteListener;
import cyan.toolkit.zuul.route.NacosRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <p>ZuulRouteAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:12 2021/6/11
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = {"cyan.toolkit.zuul.route.enabled"}, matchIfMissing = true)
public class ZuulRouteAutoConfigure {

    @Bean
    @ConditionalOnMissingBean(NacosRouteLocator.class)
    public NacosRouteLocator nacosRouteLocator(ServerProperties server, DiscoveryClient discovery, ZuulProperties zuulProperties,
                                               ServiceRouteMapper serviceRouteMapper, @Qualifier("eurekaRegistration") EurekaRegistration registration,
                                               ZuulRouteProperties routeProperties) {
        return new NacosRouteLocator(server.getServlet().getContextPath(), discovery, zuulProperties, serviceRouteMapper,
                registration,routeProperties);
    }

    @Bean
    @ConditionalOnMissingBean(NacosRouteListener.class)
    public NacosRouteListener nacosRouteListener(ContextRefresher contextRefresher, NacosRouteLocator nacosRouteLocator, ZuulRouteProperties routeProperties,
                                                 NacosConfigManager nacosConfigManager, NacosConfigProperties nacosConfigProperties) {
        return new NacosRouteListener(contextRefresher,nacosRouteLocator,routeProperties,nacosConfigManager, nacosConfigProperties);
    }

}
