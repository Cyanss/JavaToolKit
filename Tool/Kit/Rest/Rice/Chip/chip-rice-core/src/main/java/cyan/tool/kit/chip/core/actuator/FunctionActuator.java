package cyan.tool.kit.chip.core.actuator;

import cyan.tool.kit.chip.core.rice.defaults.RestException;

import java.util.Objects;

/**
 * <p>ActuatorFunction</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:13 2019/12/16
 */
//@FunctionalInterface
public interface FunctionActuator<T,R> {
    /**
     * 函数执行器
     * @param t 入参
     * @return R 返回值
     * @throws RestException RestException异常
     */
    R actuate(T t) throws RestException;

    default <V> FunctionActuator<V, R> compose(FunctionActuator<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> actuate(before.actuate(v));
    }

    default <V> FunctionActuator<T, V> andThen(FunctionActuator<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.actuate(actuate(t));
    }

    static <T> FunctionActuator<T, T> identity() {
        return t -> t;
    }

}
