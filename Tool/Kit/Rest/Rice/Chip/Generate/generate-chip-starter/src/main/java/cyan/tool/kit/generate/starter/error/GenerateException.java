package cyan.tool.kit.generate.starter.error;


import cyan.tool.kit.chip.core.error.RiceException;
import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>GenerateException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:23 2020/1/9
 */
public class GenerateException extends RiceException {
    public GenerateException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public GenerateException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public GenerateException(String message) {
        super(message);
    }

    public GenerateException(Integer status) {
        super(status);
    }

    public GenerateException(RestStatus status) {
        super(status);
    }

    public GenerateException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public GenerateException(String message, RestStatus status) {
        super(message, status);
    }

    public GenerateException get() {
        return new GenerateException();
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("generate exception");
    }
}
