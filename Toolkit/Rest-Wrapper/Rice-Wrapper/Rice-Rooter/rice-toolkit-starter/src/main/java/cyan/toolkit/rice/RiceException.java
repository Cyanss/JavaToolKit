package cyan.toolkit.rice;


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
public class RiceException extends RestException {
    public RiceException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public RiceException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public RiceException(String message) {
        super(message,RestErrorStatus.UNKNOWN_ERROR);
    }

    public RiceException(Integer status) {
        super(status,RestErrorStatus.UNKNOWN_ERROR);
    }

    public RiceException(RestStatus status) {
        super(status);
    }

    public RiceException(Integer status, String message) {
        super(status, message);
    }

    public RiceException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public RiceException(String message, RestStatus status) {
        super(message, status);
    }

    public RiceException get() {
        return new RiceException();
    }

    public String name() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("rice exception");
    }
}
