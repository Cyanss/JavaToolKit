package cyan.tool.kit.chip.starter.error;

import cyan.tool.kit.chip.core.error.RiceException;
import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>SecretKeyException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:38 2020/1/17
 */
public class SecretKeyException extends RiceException {
    public SecretKeyException() {
        super(SecretKeyErrorStatus.SECRET_KEY_ERROR);
    }

    public SecretKeyException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public SecretKeyException(String message) {
        super(message, SecretKeyErrorStatus.SECRET_KEY_ERROR);
    }

    public SecretKeyException(Integer status) {
        super(status, SecretKeyErrorStatus.SECRET_KEY_ERROR);
    }

    public SecretKeyException(RestStatus status) {
        super(status);
    }

    public SecretKeyException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public SecretKeyException(String message, RestStatus status) {
        super(message, status);
    }

    public SecretKeyException get() {
        return new SecretKeyException();
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("secret key exception");
    }
}
