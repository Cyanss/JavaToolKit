package cyan.toolkit.rest.configure;

import cyan.toolkit.rest.Interceptor.RestHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>RestInterceptConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:12 2020/9/9
 */
@Configuration
public class RestInterceptConfigure implements WebMvcConfigurer {
    @Autowired
    private RestHandlerInterceptor restInterceptor;
    @Autowired
    private RestInterceptProperties interceptProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (interceptProperties.getEnable()) {
            registry.addInterceptor(this.restInterceptor)
                    .addPathPatterns("/**")
                    .excludePathPatterns("/error");
        }
    }

}
