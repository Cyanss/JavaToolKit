package cyan.tool.kit.rest.core.actuator;

import cyan.tool.kit.rest.core.rice.defaults.RestException;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>ComparatorActuator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:43 2019/12/16
 */
@FunctionalInterface
public interface ComparatorActuator<T>{

    int compare(T o1, T o2) throws RestException;

    boolean equals(Object obj);

    default ComparatorActuator<T> thenComparing(ComparatorActuator<? super T> other) {
        Objects.requireNonNull(other);
        return (ComparatorActuator<T> & Serializable) (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : other.compare(c1, c2);
        };
    }

    default <U> ComparatorActuator<T> thenComparing(
            FunctionActuator<? super T, ? extends U> keyExtractor,
            ComparatorActuator<? super U> keyComparator)
    {
        return thenComparing(comparing(keyExtractor, keyComparator));
    }


    static <T, U> ComparatorActuator<T> comparing(
            FunctionActuator<? super T, ? extends U> keyExtractor,
            ComparatorActuator<? super U> keyComparator)
    {
        Objects.requireNonNull(keyExtractor);
        Objects.requireNonNull(keyComparator);
        return (ComparatorActuator<T> & Serializable)
                (c1, c2) -> keyComparator.compare(keyExtractor.actuate(c1),
                        keyExtractor.actuate(c2));
    }
}
