package cyan.toolkit.cloud;


import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>RiceException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
 */
public class JavaFxException extends RestException {
    public JavaFxException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public JavaFxException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public JavaFxException(String message) {
        super(message,RestErrorStatus.UNKNOWN_ERROR);
    }

    public JavaFxException(Integer status) {
        super(status,RestErrorStatus.UNKNOWN_ERROR);
    }

    public JavaFxException(RestStatus status) {
        super(status);
    }

    public JavaFxException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public JavaFxException(String message, RestStatus status) {
        super(message, status);
    }

    public JavaFxException get() {
        return new JavaFxException();
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("rice exception");
    }
}
