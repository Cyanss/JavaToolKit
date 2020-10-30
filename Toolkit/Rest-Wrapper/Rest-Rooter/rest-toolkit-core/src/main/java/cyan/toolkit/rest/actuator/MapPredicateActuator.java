package cyan.toolkit.rest.actuator;

import cyan.toolkit.rest.RestException;

import java.util.Objects;

/**
 * <p>BiPredicateActuator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 12:49 2019/12/16
 */
@FunctionalInterface
public interface MapPredicateActuator<T, U, S> {

    @SuppressWarnings(value = "unchecked")
    boolean actuate(T t, U u, S... sArray) throws RestException;

    default MapPredicateActuator<T, U, S> and(MapPredicateActuator<? super T, ? super U, ? super S> other) {
        Objects.requireNonNull(other);
        return (T t, U u, S... sArray) -> actuate(t, u, sArray) && other.actuate(t, u, sArray);
    }

    default MapPredicateActuator<T, U, S> negate() {
        return (T t, U u, S... sArray) -> !actuate(t, u, sArray);
    }

    default MapPredicateActuator<T, U, S> or(MapPredicateActuator<? super T, ? super U, ? super S> other) {
        Objects.requireNonNull(other);
        return (T t, U u, S... sArray) -> actuate(t, u, sArray) || other.actuate(t, u, sArray);
    }
}
