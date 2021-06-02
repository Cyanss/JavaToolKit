package cyan.toolkit.cloud.route;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import cyan.toolkit.cloud.configure.CloudRouterProperties;
import cyan.toolkit.rest.util.common.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>CloudTokenFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:00 2021/6/1
 */
@Slf4j
@Component
public class CloudTokenFilter extends ZuulFilter {

    @Autowired
    private CloudRouterProperties properties;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 15;
    }

    @Override
    public boolean shouldFilter() {
        log.info("properties: {}", JsonUtils.parseJson(properties));
        if (!properties.getEnable()) {
            return false;
        }
        RequestContext requestContext = RequestContext.getCurrentContext();
        return !requestContext.containsKey(FilterConstants.FORWARD_TO_KEY);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("request uri: {}", request.getRequestURI());
        log.info("request url: {}", request.getRequestURL());
        return null;
    }
}
