package cyan.toolkit.chief;


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
public class ChiefException extends RestException {
    public ChiefException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public ChiefException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public ChiefException(String message) {
        super(message,RestErrorStatus.UNKNOWN_ERROR);
    }

    public ChiefException(Integer status) {
        super(status,RestErrorStatus.UNKNOWN_ERROR);
    }

    public ChiefException(RestStatus status) {
        super(status);
    }

    public ChiefException(Integer status, String message) {
        super(status, message);
    }

    public ChiefException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public ChiefException(String message, RestStatus status) {
        super(message, status);
    }

    public ChiefException get() {
        return new ChiefException();
    }

    public String name() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("chief exception");
    }
}
