package cyan.tool.kit.rest.core.actuator;

import cyan.tool.kit.rest.core.rice.defaults.RestException;

import java.util.Objects;

/**
 * <p>ActuatorConsumer</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:13 2019/12/16
 */
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
