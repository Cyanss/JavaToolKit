package cyan.toolkit.rest.actuator;

import cyan.toolkit.rest.RestException;

import java.util.Objects;

/**
 * <p>BiConsumerActuator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:38 2019/12/16
 */
@FunctionalInterface
public interface BiConsumerActuator<T, U> {

    void actuate(T t, U u) throws RestException;

    default BiConsumerActuator<T, U> andThen(BiConsumerActuator<? super T, ? super U> after) {
        Objects.requireNonNull(after);
        return (l, r) -> {
            actuate(l, r);
            after.actuate(l, r);
        };
    }
}
