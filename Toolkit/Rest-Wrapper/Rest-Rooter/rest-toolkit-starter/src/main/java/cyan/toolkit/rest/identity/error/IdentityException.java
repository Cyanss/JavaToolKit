package cyan.toolkit.rest.identity.error;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>IdentityException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:23 2020/1/9
 */
public class IdentityException extends RestException {
    public IdentityException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public IdentityException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public IdentityException(String message) {
        super(message);
    }

    public IdentityException(Integer status) {
        super(status);
    }

    public IdentityException(RestStatus status) {
        super(status);
    }

    public IdentityException(Integer status, String message) {
        super(status, message);
    }

    public IdentityException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public IdentityException(String message, RestStatus status) {
        super(message, status);
    }

    public IdentityException get() {
        return new IdentityException();
    }
}
