package cyan.toolkit.rest.actuator;

import cyan.toolkit.rest.RestException;

import java.util.Objects;

/**
 * <p>ActuatorPredicate</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:38 2019/12/16
 */
@FunctionalInterface
public interface PredicateActuator<T> {
    /**
     * 函数执行器
     * @param m 入参
     * @return R 返回值
     * @throws RestException RestException异常
     */
    Boolean actuate(T m) throws RestException;


    default PredicateActuator<T> and(PredicateActuator<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> actuate(t) && other.actuate(t);
    }

    default PredicateActuator<T> negate() {
        return (t) -> !actuate(t);
    }


    default PredicateActuator<T> or(PredicateActuator<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> actuate(t) || other.actuate(t);
    }

    static <T> PredicateActuator<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : targetRef::equals;
    }
}
