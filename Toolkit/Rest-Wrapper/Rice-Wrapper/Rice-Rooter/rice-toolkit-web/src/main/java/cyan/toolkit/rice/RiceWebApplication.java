package cyan.toolkit.rice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>GxEditorWebApplication</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:00 2020/7/22
 */
@SpringBootApplication
@ComponentScan(basePackages = "cyan.toolkit")
public class RiceWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RiceWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RiceWebApplication.class);
    }
}
