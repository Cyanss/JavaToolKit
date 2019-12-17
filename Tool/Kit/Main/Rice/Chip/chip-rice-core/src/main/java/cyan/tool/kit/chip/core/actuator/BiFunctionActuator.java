package cyan.tool.kit.chip.core.actuator;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * <p>BiFunctionActuator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:40 2019/12/16
 */
@FunctionalInterface
public interface BiFunctionActuator<T, U, R> {
    R actuate(T t, U u) throws Exception;

    default <V> BiFunctionActuator<T, U, V> andThen(FunctionActuator<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.actuate(actuate(t, u));
    }
}
