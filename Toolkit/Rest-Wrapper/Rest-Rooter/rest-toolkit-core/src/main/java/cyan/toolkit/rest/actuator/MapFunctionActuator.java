package cyan.toolkit.rest.actuator;

import cyan.toolkit.rest.RestException;

import java.util.Objects;

/**
 * <p>MapFunctionActuator</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 16:46 2020/10/30
 */
@FunctionalInterface
public interface MapFunctionActuator<T, U, S, R> {

    @SuppressWarnings(value = "unchecked")
    R actuate(T t, U u, S... sArray) throws RestException;

    default <V> MapFunctionActuator<T, U, S, V> andThen(FunctionActuator<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u, S... sArray) -> after.actuate(actuate(t, u, sArray));
    }
}
