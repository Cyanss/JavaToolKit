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
public interface BiPredicateActuator<T, U> {

    boolean actuate(T t, U u) throws RestException;

    default BiPredicateActuator<T, U> and(BiPredicateActuator<? super T, ? super U> other) {
        Objects.requireNonNull(other);
        return (T t, U u) -> actuate(t, u) && other.actuate(t, u);
    }

    default BiPredicateActuator<T, U> negate() {
        return (T t, U u) -> !actuate(t, u);
    }

    default BiPredicateActuator<T, U> or(BiPredicateActuator<? super T, ? super U> other) {
        Objects.requireNonNull(other);
        return (T t, U u) -> actuate(t, u) || other.actuate(t, u);
    }
}
