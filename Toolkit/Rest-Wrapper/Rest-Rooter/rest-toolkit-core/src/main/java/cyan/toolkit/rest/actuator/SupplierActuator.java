package cyan.toolkit.rest.actuator;

import cyan.toolkit.rest.RestException;

/**
 * <p>SupplierActuator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:36 2019/12/16
 */
@FunctionalInterface
public interface SupplierActuator<T> {

    T get() throws RestException;
}
