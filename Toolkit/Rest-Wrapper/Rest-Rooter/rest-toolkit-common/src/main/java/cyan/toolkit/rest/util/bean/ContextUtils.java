package cyan.toolkit.rest.util.bean;

import cyan.toolkit.rest.RestAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>ContextUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:43 2020/9/10
 */
@Slf4j
@Component
public class ContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        ContextUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name){
        try {
            return getApplicationContext().getBean(name);
        } catch (NoSuchBeanDefinitionException ex) {
            log.warn("bean of name is {} no found, error: {}",name,ex.getMessage());
            return null;
        }
    }

    public static <T> T getBean(Class<T> clazz){
        try {
            return getApplicationContext().getBean(clazz);
        } catch (NoSuchBeanDefinitionException ex) {
            log.warn("bean of type is {} no found, error: {}",clazz.getName(),ex.getMessage());
            return null;
        }
    }

    public static <T> T getBean(String name,Class<T> clazz){
        try {
            return getApplicationContext().getBean(name, clazz);
        } catch (NoSuchBeanDefinitionException ex) {
            log.warn("bean of type is {} and name is {} no found, error: {}",clazz.getName(),name,ex.getMessage());
            return null;
        }
    }

}
