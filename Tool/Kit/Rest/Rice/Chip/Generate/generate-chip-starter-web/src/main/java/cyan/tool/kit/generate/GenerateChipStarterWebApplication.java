package cyan.tool.kit.generate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "cyan.tool.kit")
public class GenerateChipStarterWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GenerateChipStarterWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GenerateChipStarterWebApplication.class);
    }
}
