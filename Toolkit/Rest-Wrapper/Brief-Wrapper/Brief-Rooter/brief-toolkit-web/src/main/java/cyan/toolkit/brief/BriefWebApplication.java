package cyan.toolkit.brief;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>BriefWebApplication</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
 */
@SpringBootApplication
@ComponentScan(basePackages = "cyan.toolkit")
public class BriefWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BriefWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BriefWebApplication.class);
    }
}
