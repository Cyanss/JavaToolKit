package cyan.toolkit.rest.util.bean;

import cyan.toolkit.rest.helper.ContextHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;

/**
 * <p>ContextUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:43 2020/9/10
 */
@Slf4j
public class ContextUtils {

    public static Object getBean(String name){
        try {
            return ContextHelper.getBean(name);
        } catch (BeansException ex) {
            log.warn("bean of name is {} no found, error: {}",name,ex.getMessage());
            return null;
        }
    }

    public static <T> T getBean(Class<T> clazz){
        try {
            return ContextHelper.getBean(clazz);
        } catch (BeansException ex) {
            log.warn("bean of type is {} no found, error: {}",clazz.getName(),ex.getMessage());
            return null;
        }
    }

    public static <T> T getBean(String name,Class<T> clazz){
        try {
            return ContextHelper.getBean(name, clazz);
        } catch (BeansException ex) {
            log.warn("bean of type is {} and name is {} no found, error: {}",clazz.getName(),name,ex.getMessage());
            return null;
        }
    }

}
