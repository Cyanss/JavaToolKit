package cyan.toolkit.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>ImageStarterWebApplication</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
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
