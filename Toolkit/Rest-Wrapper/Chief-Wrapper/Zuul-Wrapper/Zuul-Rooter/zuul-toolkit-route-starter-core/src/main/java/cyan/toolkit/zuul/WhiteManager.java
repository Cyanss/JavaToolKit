package cyan.toolkit.zuul;

import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.zuul.configure.ZuulRouteProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>WhiteManager</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:37 2021/6/25
 */
@Slf4j
public class WhiteManager implements InitializingBean {

    private ZuulRouteProperties routeProperties;

    private static final Set<String> WHITE_LIST = new HashSet<>();

    public WhiteManager(ZuulRouteProperties routeProperties) {
        this.routeProperties = routeProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("routeProperties: {}", JsonUtils.parseJson(routeProperties));
    }

}
