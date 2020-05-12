package cyan.toolkit.rest.actuator;

import java.util.Objects;

/**
 * <p>BinaryOperatorActuator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:40 2019/12/16
 */
public interface BinaryOperatorActuator<T> extends BiFunctionActuator<T,T,T>{

    static <T> BinaryOperatorActuator<T> minBy(ComparatorActuator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
    }

    static <T> BinaryOperatorActuator<T> maxBy(ComparatorActuator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return (a, b) -> comparator.compare(a, b) >= 0 ? a : b;
    }
}
