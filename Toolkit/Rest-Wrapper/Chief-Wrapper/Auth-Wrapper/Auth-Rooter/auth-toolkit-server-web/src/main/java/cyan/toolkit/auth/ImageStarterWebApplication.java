package cyan.toolkit.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>ImageStarterWebApplication</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:00 2020/7/22
 */

@SpringBootApplication(scanBasePackages = "cyan.toolkit.image")
public class ImageStarterWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ImageStarterWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ImageStarterWebApplication.class);
    }
}
