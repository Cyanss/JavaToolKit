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
public interface MapConsumerActuator<T, U, S> {

    @SuppressWarnings(value = "unchecked")
    void actuate(T t, U u, S... sArray) throws RestException;

    default MapConsumerActuator<T, U, S> andThen(MapConsumerActuator<? super T, ? super U, ? super S> after) {
        Objects.requireNonNull(after);
        return (l, r ,s) -> {
            actuate(l, r, s);
            after.actuate(l, r, s);
        };
    }
}
