package cyan.toolkit.zuul.route;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.zuul.DynamicRouteLocator;
import cyan.toolkit.zuul.configure.ZuulRouteProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;

/**
 * <p>NacosRouteLocator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:15 2021/6/9
 */
@Slf4j
public class NacosRouteLocator extends DynamicRouteLocator {

    public NacosRouteLocator(String servletPath, DiscoveryClient discovery, ZuulProperties properties,
                             ServiceRouteMapper serviceRouteMapper, ServiceInstance localServiceInstance,
                             ZuulRouteProperties routeProperties) {
        super(servletPath, discovery, properties, serviceRouteMapper, localServiceInstance, routeProperties);
    }

    @Override
    public void refresh() {
        super.refresh();
    }
}
