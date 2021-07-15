package cyan.toolkit.rest.interceptor;

import cyan.toolkit.rest.*;
import cyan.toolkit.rest.configure.RestInterceptProperties;
import cyan.toolkit.rest.util.bean.ContextUtils;
import cyan.toolkit.rest.util.common.DateUtils;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.network.IpAddressUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * <p>RestHandlerInterceptor</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:29 2020/9/9
 */
@Slf4j
@WebFilter
@Component
public class RestHandlerInterceptor extends HandlerInterceptorAdapter implements RestExceptionAdvice, Filter {
    protected ThreadLocal<Long> START_TIME_HOLDER = new ThreadLocal<>();
    protected ThreadLocal<Exception> EXCEPTION_HOLDER = new ThreadLocal<>();
    @Autowired
    private RestInterceptProperties interceptProperties;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void preExceptionHandle(Exception exception,HttpServletRequest request, HttpServletResponse response) {
        if (GeneralUtils.isNotEmpty(exception)) {
            EXCEPTION_HOLDER.set(exception);
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long start = System.currentTimeMillis();
        START_TIME_HOLDER.set(start);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> controllerClass = handlerMethod.getBean().getClass();
            RestIntercept controllerAnnotation = controllerClass.getAnnotation(RestIntercept.class);
            Method method = handlerMethod.getMethod();
            RestIntercept methodAnnotation = method.getAnnotation(RestIntercept.class);
            if (GeneralUtils.isEmpty(methodAnnotation) && GeneralUtils.isEmpty(controllerAnnotation)) {
                return;
            }
            RestInterceptRequest restInterceptRequest = applyInterceptRequest(request, response, ex);
            applyInterceptRequestLog(restInterceptRequest);
            applyInterceptService(restInterceptRequest);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if (servletRequest instanceof HttpServletRequest) {
            String contentType = servletRequest.getContentType();
            if (!contentType.contains("multipart/form-data")) {
                requestWrapper = new RestRequestWrapper((HttpServletRequest) servletRequest);
            }
        }
        if (null == requestWrapper) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(requestWrapper, servletResponse);
        }
    }

    public RestInterceptRequest applyInterceptRequest(HttpServletRequest request, HttpServletResponse response, @Nullable Exception ex) throws IOException {
        Long startTime = START_TIME_HOLDER.get();
        Long endTime = System.currentTimeMillis();
        Long costTime = endTime - startTime;
        RestInterceptRequest.Builder interceptRequestBuilder = new RestInterceptRequest.Builder();
        interceptRequestBuilder.time(startTime).startTime(startTime).endTime(endTime).costTime(costTime)
                .ipAddress(IpAddressUtils.getIpAddress(request)).userAgent(request.getHeader("User-Agent"))
                .method(request.getMethod()).url(request.getRequestURL().toString()).status(response.getStatus())
                .message(Optional.ofNullable(ex).map(Exception::getMessage).orElse("OK"));
        if (!RestErrorStatus.SUCCESS.getStatus().equals(response.getStatus())) {
            Exception exception = EXCEPTION_HOLDER.get();
            if (GeneralUtils.isEmpty(ex) && GeneralUtils.isEmpty(exception)) {
                interceptRequestBuilder.message("Unknown Error");
            } else if (GeneralUtils.isNotEmpty(ex)) {
                interceptRequestBuilder.message(ex.getMessage());
            } else {
                interceptRequestBuilder.message(exception.getMessage());
            }
        }
        String requestBody = "";
        String contentType = request.getContentType();
        if (StringUtils.hasText(contentType) && contentType.contains("application/json")) {
            if (request instanceof RestRequestWrapper) {
                RestRequestWrapper requestWrapper = (RestRequestWrapper) request;
                String body = new String(requestWrapper.getBody());
                String bodyTrim = body.replaceAll("\r", "")
                        .replaceAll("\n", "")
                        .replaceAll(" ", "")
                        .trim();
                if (bodyTrim.length() > 500) {
                    requestBody = bodyTrim.substring(0,500).concat("...");
                } else {
                    requestBody = bodyTrim;
                }
            } else {
                log.debug("the request is not 'RestRequestWrapper' type!");
            }
        }
        String param = StringUtils.hasText(requestBody) ? requestBody : RestInterceptHolder.getRequestParam(request);
        interceptRequestBuilder.param(param);
        return interceptRequestBuilder.build();
    }

    public void applyInterceptService(RestInterceptRequest restInterceptRequest) throws RestException {
        RestInterceptService interceptService = ContextUtils.getBean(RestInterceptService.class);
        if (GeneralUtils.isNotEmpty(interceptService) && interceptProperties.getBeanEnabled()) {
            interceptService.handler(restInterceptRequest);
        }
    }

    public void applyInterceptRequestLog(RestInterceptRequest interceptRequest) {
        if (interceptProperties.getLogEnabled()) {
            log.info(">>>>>>>>>>>>>> Request Intercept Log Begin <<<<<<<<<<<<<<");
            log.info("Request           time : {}", DateUtils.formatTime(interceptRequest.getTime()));
            log.info("Request     start time : {}",interceptRequest.getStartTime());
            log.info("Request       end time : {}",interceptRequest.getEndTime());
            log.info("Request      cost time : {}",interceptRequest.getCostTime());
            log.info("Request     ip address : {}",interceptRequest.getIpAddress());
            log.info("Request     user agent : {}",interceptRequest.getUserAgent());
            log.info("Request         method : {}",interceptRequest.getMethod());
            log.info("Request            url : {}",interceptRequest.getUrl());
            log.info("Request          param : {}",interceptRequest.getParam());
            log.info("Request         status : {}",interceptRequest.getStatus());
            log.info("Request        message : {}",interceptRequest.getMessage());
            log.info(">>>>>>>>>>>>>>> Request Intercept Log end <<<<<<<<<<<<<<<");
        }
    }
}
