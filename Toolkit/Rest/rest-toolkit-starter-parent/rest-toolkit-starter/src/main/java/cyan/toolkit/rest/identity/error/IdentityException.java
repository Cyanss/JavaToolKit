package cyan.toolkit.rest.identity.error;



import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;
import cyan.toolkit.rest.rice.RiceException;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>GenerateException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:23 2020/1/9
 */
public class IdentityException extends RiceException {
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

    public IdentityException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public IdentityException(String message, RestStatus status) {
        super(message, status);
    }

    public IdentityException get() {
        return new IdentityException();
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("generate exception");
    }
}
