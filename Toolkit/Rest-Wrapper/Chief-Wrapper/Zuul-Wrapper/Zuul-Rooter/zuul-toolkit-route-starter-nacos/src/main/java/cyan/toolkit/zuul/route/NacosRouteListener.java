package cyan.toolkit.zuul.route;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.client.config.listener.impl.PropertiesListener;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.zuul.configure.ZuulRouteProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.context.refresh.ContextRefresher;

import java.util.Properties;
import java.util.Set;

/**
 * <p>NacosRouteListener</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:23 2021/6/11
 */
@Slf4j
public class NacosRouteListener extends PropertiesListener implements InitializingBean {

    private static final String WHITES_KEY = "cyan.toolkit.zuul.route.whites";

    private ContextRefresher refresh;

    private NacosRouteLocator locator;

    private ZuulRouteProperties routeProperties;

    private NacosConfigManager nacosConfigManager;

    private NacosConfigProperties nacosConfigProperties;

    public NacosRouteListener(ContextRefresher contextRefresher, NacosRouteLocator nacosRouteLocator, ZuulRouteProperties routeProperties,
                              NacosConfigManager nacosConfigManager, NacosConfigProperties nacosConfigProperties) {
        this.refresh = contextRefresher;
        this.locator = nacosRouteLocator;
        this.routeProperties = routeProperties;
        this.nacosConfigManager = nacosConfigManager;
        this.nacosConfigProperties = nacosConfigProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (routeProperties.getEnabled()) {
            String name = nacosConfigProperties.getName();
            String group = nacosConfigProperties.getGroup();
            if (GeneralUtils.isEmpty(name) || GeneralUtils.isEmpty(group)) {
                log.error("the name or group at the config properties of nacos is null!");
            } else {
                nacosConfigManager.getConfigService().addListener(name, group, this);
                log.info("the listener of nacos has be added in the config service!");
            }
        }
    }

    @Override
    public void innerReceive(Properties properties) {
        Set<String> changedKeys = this.refresh.refresh();
        if (changedKeys.contains(WHITES_KEY)) {
            String property = properties.getProperty(WHITES_KEY);
            log.info("the whites has be reloaded, new value: {}", property);
            locator.reload();
        }
    }


}
