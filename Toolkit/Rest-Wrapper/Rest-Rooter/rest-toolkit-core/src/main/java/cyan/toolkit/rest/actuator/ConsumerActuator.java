package cyan.toolkit.rest.actuator;

import cyan.toolkit.rest.RestException;

import java.util.Objects;

/**
 * <p>ActuatorConsumer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:38 2019/12/16
 */
@FunctionalInterface
public interface ConsumerActuator<T>{
    /**
     * 函数执行器
     * @param t 入参
     * @throws RestException RestException异常
     */
    void actuate(T t) throws RestException;


    default ConsumerActuator<T> andThen(ConsumerActuator<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { actuate(t); after.actuate(t); };
    }
}
