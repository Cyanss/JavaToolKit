package cyan.toolkit.rest.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * <p>ContextHelper</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 8:44 2020/10/30
 */
@Component
public class ContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        ContextHelper.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) throws BeansException{
        return getApplicationContext().getBean(name);

    }

    public static <T> T getBean(Class<T> clazz) throws BeansException{
        return getApplicationContext().getBean(clazz);

    }

    public static <T> T getBean(String name,Class<T> clazz) throws BeansException {
        return getApplicationContext().getBean(name, clazz);
    }

}
