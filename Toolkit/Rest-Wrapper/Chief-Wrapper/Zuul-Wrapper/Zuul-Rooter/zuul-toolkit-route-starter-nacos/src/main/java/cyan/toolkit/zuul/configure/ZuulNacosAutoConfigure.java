package cyan.toolkit.zuul.configure;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import cyan.toolkit.zuul.DynamicRouteLocator;
import cyan.toolkit.zuul.route.NacosRouteListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>ZuulNacosAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:52 2021/6/1
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.zuul"})
public class ZuulNacosAutoConfigure {
    public ZuulNacosAutoConfigure() {
        log.debug("================= zuul-toolkit-route-starter-nacos initiated ！ ===================");
    }

    @Bean
    @ConditionalOnMissingBean(NacosRouteListener.class)
    @ConditionalOnProperty(name = {"cyan.toolkit.zuul.route.enabled"}, matchIfMissing = true)
    public NacosRouteListener nacosRouteListener(ContextRefresher contextRefresher, DynamicRouteLocator dynamicRouteLocator, ZuulRouteProperties routeProperties,
                                                 NacosConfigManager nacosConfigManager, NacosConfigProperties nacosConfigProperties) {
        return new NacosRouteListener(contextRefresher,dynamicRouteLocator,routeProperties,nacosConfigManager, nacosConfigProperties);
    }

}
