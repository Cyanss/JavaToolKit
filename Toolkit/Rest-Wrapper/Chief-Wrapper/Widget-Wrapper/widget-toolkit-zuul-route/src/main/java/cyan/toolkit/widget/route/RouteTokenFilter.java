package cyan.toolkit.widget.route;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestResult;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.widget.configure.RouteProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>CloudTokenFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:00 2021/6/1
 */
@Slf4j
@Component
public class RouteTokenFilter extends ZuulFilter {

    @Autowired
    private RouteProperties routeProperties;

    @Autowired
    private ZuulProperties zuulProperties;

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
        if (!routeProperties.getEnable()) {
            return false;
        }
        RequestContext requestContext = RequestContext.getCurrentContext();
        return !requestContext.containsKey(FilterConstants.FORWARD_TO_KEY);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String requestURI = request.getRequestURI();
        log.debug("request uri: {}", requestURI);
        StringBuffer requestURL = request.getRequestURL();
        log.debug("request url: {}", requestURL);
        if (RouteManager.existWhite(requestURI)) {
            log.info("request uri: {} has existed in the white list, skip the auth of token!", requestURI);
            return null;
        }
        String requestToken = request.getHeader("Authorization");
        if (GeneralUtils.isNotEmpty(requestToken)) {
            log.info("request token: {}", requestURI);
            return null;
        }
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        requestContext.setResponseBody(JsonUtils.parseJson(RestResult.error(RestErrorStatus.TOKEN_ERROR)));
        HttpServletResponse contextResponse = requestContext.getResponse();
        if (GeneralUtils.isNotEmpty(contextResponse)) {
            contextResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        }
        requestContext.set("isSuccess", false);
        return null;
    }
}
