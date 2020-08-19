package cyan.toolkit.auth;


import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>AuthException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
 */
public class AuthException extends RestException {
    public AuthException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public AuthException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public AuthException(String message) {
        super(message,RestErrorStatus.UNKNOWN_ERROR);
    }

    public AuthException(Integer status) {
        super(status,RestErrorStatus.UNKNOWN_ERROR);
    }

    public AuthException(RestStatus status) {
        super(status);
    }

    public AuthException(Integer status, String message) {
        super(status, message);
    }

    public AuthException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public AuthException(String message, RestStatus status) {
        super(message, status);
    }

    public AuthException get() {
        return new AuthException();
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("auth exception");
    }
}
