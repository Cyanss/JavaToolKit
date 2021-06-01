package cyan.toolkit.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class CloudToolkitRouterApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CloudToolkitRouterApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CloudToolkitRouterApplication.class);
    }
}
