package cyan.toolkit.zuul.route;

import com.alibaba.nacos.client.config.listener.impl.PropertiesListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.refresh.ContextRefresher;

import java.util.Properties;
import java.util.Set;

/**
 * <p>DynamicNacosListener</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:23 2021/6/11
 */
@Slf4j
public class DynamicNacosListener extends PropertiesListener {

    private static final String WHITES_KEY = "cyan.toolkit.zuul.route.whites";

    private ContextRefresher refresh;

    public DynamicNacosListener(ContextRefresher contextRefresher) {
        this.refresh = contextRefresher;
    }

    @Override
    public void innerReceive(Properties properties) {
        Set<String> changedKeys = this.refresh.refresh();
        if (changedKeys.contains(WHITES_KEY)) {
            String property = properties.getProperty(WHITES_KEY);
            log.info("the whites has be reloaded, new value: {}", property);
            RouteManager.reload();
        }
    }
}
