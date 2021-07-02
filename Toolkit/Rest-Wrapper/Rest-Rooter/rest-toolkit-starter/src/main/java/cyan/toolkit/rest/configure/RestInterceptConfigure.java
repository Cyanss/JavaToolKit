package cyan.toolkit.rest.configure;


import cyan.toolkit.rest.interceptor.RestHandlerInterceptor;
import cyan.toolkit.rest.interceptor.RestHttpInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * <p>RestInterceptConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:12 2020/9/9
 */
@Configuration
public class RestInterceptConfigure extends WebMvcConfigurationSupport {
    @Autowired
    private RestHandlerInterceptor handlerInterceptor;
    @Autowired
    private RestHttpInterceptor httpInterceptor;
    @Autowired
    private RestInterceptProperties interceptProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (interceptProperties.getEnabled()) {
            registry.addInterceptor(this.handlerInterceptor)
                    .addPathPatterns("/**")
                    .excludePathPatterns("/error");
        }
    }


    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        if (interceptProperties.getEnabled()) {
            restTemplate.getInterceptors().add(httpInterceptor);
        }
        return restTemplate;
    }

}
