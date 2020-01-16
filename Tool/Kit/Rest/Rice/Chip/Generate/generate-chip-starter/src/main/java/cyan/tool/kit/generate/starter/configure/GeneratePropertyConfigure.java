package cyan.tool.kit.generate.starter.configure;

import lombok.Data;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * <p>GenerateProperties</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:38 2020/1/16
 */
@Data
@Configuration
public class GeneratePropertyConfigure implements EnvironmentAware, BeanPostProcessor {
    private Environment environment;
    private static GeneratePropertyConfigure properties;

    public GeneratePropertyConfigure() {
        properties = this;
    }

    public static GeneratePropertyConfigure getInstance() {
        return properties;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return this.environment;
    }

    public String[] getActiveProfiles() {
        return this.environment.getActiveProfiles();
    }

    public String[] getDefaultProfiles() {
        return this.environment.getDefaultProfiles();
    }

    public boolean containsProperty(String key) {
        return this.environment.containsProperty(key);
    }

    public String getProperty(String key) {
        return this.environment.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return this.environment.getProperty(key, defaultValue);
    }

    public <T> T getProperty(String key, Class<T> targetType) {
        return this.environment.getProperty(key, targetType);
    }

    public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
        return this.environment.getProperty(key, targetType, defaultValue);
    }

    public String getRequiredProperty(String key) {
        return this.environment.getRequiredProperty(key);
    }

    public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
        return this.environment.getRequiredProperty(key, targetType);
    }

    public String resolvePlaceholders(String text) {
        return this.environment.resolvePlaceholders(text);
    }

    public String resolveRequiredPlaceholders(String text) {
        return this.environment.resolveRequiredPlaceholders(text);
    }

}
