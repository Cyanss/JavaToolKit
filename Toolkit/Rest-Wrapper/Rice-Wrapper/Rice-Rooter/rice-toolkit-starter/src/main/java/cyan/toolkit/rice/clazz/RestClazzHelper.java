package cyan.toolkit.rice.clazz;

import cyan.toolkit.rest.error.ClassUnknownException;
import cyan.toolkit.rest.error.ClassUnsupportedException;
import cyan.toolkit.rest.identity.IdentityHelper;
import cyan.toolkit.rest.identity.error.IdentityException;
import cyan.toolkit.rest.util.often.RandomUtils;
import cyan.toolkit.rice.model.IdModel;

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
public class RestClazzHelper {

    public static Class<?> clazz(Object object) throws ClassUnknownException {
        Type genericSuperclass = object.getClass().getGenericSuperclass();
        while (!(genericSuperclass instanceof ParameterizedType)) {
            genericSuperclass = ((Class) genericSuperclass).getGenericSuperclass();
            if (genericSuperclass == null) {
                throw new ClassUnknownException();
            }
        }
        ParameterizedType parameterizedType = (ParameterizedType ) genericSuperclass;
        Type [] actualTypes = parameterizedType.getActualTypeArguments();
        Optional<Type> first = Stream.of(actualTypes).findFirst();
        return first.map(type -> (Class<?>) type).orElseThrow(ClassUnknownException::new);
    }

    @SuppressWarnings(value = "unchecked")
    public static <I> I generate(IdModel<I> model) throws IdentityException, ClassUnsupportedException, ClassUnknownException {
        Class<?> clazz = clazz(model);
        Long id = IdentityHelper.generate();
        if (String.class.equals(clazz)) {
            String uuid = RandomUtils.uuid();
            return (I) uuid;
        } else if (Long.class.equals(clazz)) {
            return (I) id;
        } else if (Integer.class.equals(clazz)) {
            return (I) ((Integer) id.intValue());
        } else if (Double.class.equals(clazz)) {
            return (I) ((Double) id.doubleValue());
        } else if (Float.class.equals(clazz)) {
            return (I) ((Float) id.floatValue());
        } else if (Short.class.equals(clazz)) {
            return (I) ((Short) id.shortValue());
        } else if (Byte.class.equals(clazz)) {
            return (I) ((Byte) id.byteValue());
        } else {
            throw new ClassUnsupportedException("无效的<I>类型: " + clazz);
        }
    }
}
