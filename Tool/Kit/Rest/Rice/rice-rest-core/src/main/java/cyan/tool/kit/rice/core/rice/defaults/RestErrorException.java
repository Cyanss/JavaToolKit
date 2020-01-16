package cyan.tool.kit.rice.core.rice.defaults;

import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>RestError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:27 2019/12/17
 */
public class RestErrorException extends RestException {

    public RestErrorException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public RestErrorException(Supplier<RestStatus> supplier) {
        super(supplier.get());
    }

    public RestErrorException(RestStatus status) {
        super(status);
    }

    public RestErrorException(RestErrorStatus status) {
        super(status, RestError.error(status));
    }

    public RestErrorException(RestError error) {
        super((RestStatus) error);
    }

    public RestErrorException(Integer status, RestError error) {
        super(status, error);
    }

    public RestErrorException(String message, RestError error) {
        super(message, error);
    }

    public RestErrorException(RestStatus status, RestError error) {
        super(status, error);
    }

    public RestErrorException(RestError error, Throwable cause) {
        super(error, cause);
    }

    public RestErrorException(Integer status, RestError error, Throwable cause) {
        super(status, error, cause);
    }

    public RestErrorException(String message, RestError error, Throwable cause) {
        super(message, error, cause);
    }

    public RestErrorException(RestStatus status, RestError error, Throwable cause) {
        super(status, error, cause);
    }

    public RestErrorException(RestError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(error, cause, enableSuppression, writableStackTrace);
    }

    public RestErrorException(Integer status, RestError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, error, cause, enableSuppression, writableStackTrace);
    }

    public RestErrorException(String message, RestError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, error, cause, enableSuppression, writableStackTrace);
    }

    public RestErrorException(RestStatus status, RestError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, error, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public RestErrorException get() {
        return new RestErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("rest error exception");
    }
}
