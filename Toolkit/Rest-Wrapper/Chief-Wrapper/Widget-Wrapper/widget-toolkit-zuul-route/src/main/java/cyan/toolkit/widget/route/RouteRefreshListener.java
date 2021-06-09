package cyan.toolkit.widget.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
import org.springframework.cloud.client.discovery.event.HeartbeatMonitor;
import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.cloud.client.discovery.event.ParentHeartbeatEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * <p>RouteRefreshListener</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:58 2021/6/9
 */
@Component
public class RouteRefreshListener implements ApplicationListener<ApplicationEvent> {

    @Autowired
    private ZuulHandlerMapping zuulHandlerMapping;

    private HeartbeatMonitor heartbeatMonitor = new HeartbeatMonitor();

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent
                || event instanceof RefreshScopeRefreshedEvent
                || event instanceof RoutesRefreshedEvent
                || event instanceof InstanceRegisteredEvent) {
            reset();
        } else if (event instanceof ParentHeartbeatEvent) {
            ParentHeartbeatEvent e = (ParentHeartbeatEvent) event;
            resetIfNeeded(e.getValue());
        } else if (event instanceof HeartbeatEvent) {
            HeartbeatEvent e = (HeartbeatEvent) event;
            resetIfNeeded(e.getValue());
        }
    }

    private void resetIfNeeded(Object value) {
        if (this.heartbeatMonitor.update(value)) {
            reset();
        }
    }

    private void reset() {
        this.zuulHandlerMapping.setDirty(true);
    }
}
