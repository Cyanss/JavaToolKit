package cyan.toolkit.zuul.configure;

import cyan.toolkit.zuul.DynamicRouteLocator;
import cyan.toolkit.zuul.WhiteManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>ZuulRouteAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:57 2021/6/24
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = {"cyan.toolkit.zuul.route.enabled"}, matchIfMissing = true)
public class ZuulRouteAutoConfigure {

    @Bean
    @ConditionalOnMissingBean(DynamicRouteLocator.class)
    @ConditionalOnProperty(name = {"cyan.toolkit.zuul.route.enabled"}, matchIfMissing = true)
    public DynamicRouteLocator dynamicRouteLocator(ServerProperties server, ZuulProperties zuulProperties, ZuulRouteProperties routeProperties) {
        return new DynamicRouteLocator(server.getServlet().getContextPath(), zuulProperties, routeProperties);
    }

    @Bean
    @RefreshScope
    @ConditionalOnMissingBean(WhiteManager.class)
    @ConditionalOnProperty(name = {"cyan.toolkit.zuul.route.refreshed.whites-enabled"}, matchIfMissing = true)
    public WhiteManager whiteManager(ZuulRouteProperties routeProperties) {
        return new WhiteManager(routeProperties);
    }

}
