package cyan.toolkit.rice.clazz;

import cyan.toolkit.rest.error.ClassUnknownException;
import cyan.toolkit.rest.error.ClassUnsupportedException;
import cyan.toolkit.rest.identity.IdentityHelper;
import cyan.toolkit.rest.identity.error.IdentityException;
import cyan.toolkit.rest.util.often.RandomUtils;
import cyan.toolkit.rice.model.IdModel;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * <p>RestIdAccessUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:49 2020/9/23
 */
@Slf4j
public class RestClazzUtils {

    public static Class<?> clazz(Object object) {
        try {
            return RestClazzHelper.clazz(object);
        } catch (ClassUnknownException exception) {
            exception.printStackTrace();
            log.error("the class type of <I> is unknown",exception);
            return null;
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <I> I generate(IdModel<I> model)  {
        try {
            return RestClazzHelper.generate(model);
        } catch (ClassUnknownException exception) {
            exception.printStackTrace();
            log.error("the class type of <I> is unknown",exception);
        } catch (IdentityException exception) {
            exception.printStackTrace();
            log.error("IdentityWorker configure error",exception);
        } catch (ClassUnsupportedException exception) {
            exception.printStackTrace();
            log.error("the class type of <I> is unsupported",exception);
        }
        return null;
    }
}
