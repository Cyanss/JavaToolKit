package cyan.tool.kit.chip.core.rice.defaults;

import com.sun.org.apache.regexp.internal.RE;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

import java.util.function.Supplier;

/**
 * <p>RestError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:27 2019/12/17
 */
public class RestErrorException extends DefaultException {

    public RestErrorException() {
    }

    public RestErrorException(Supplier<RestStatus> supplier) {
        super(supplier.get());
    }

    public RestErrorException(RestStatus status) {
        super(status);
    }

    public RestErrorException(RestResultStatus status) {
        super(status, RestError.error(status));
    }

    public RestErrorException(RestError error) {
        super((DefaultError) error);
    }

    public RestErrorException(Integer status, RestError error) {
        super(status,(DefaultError) error);
    }

    public RestErrorException(RestStatus status, RestError error) {
        super(status, error);
    }

    public RestErrorException(RestError error, Throwable cause) {
        super((DefaultError) error, cause);
    }

    public RestErrorException(Integer status, RestError error, Throwable cause) {
        super(status, (DefaultError) error, cause);
    }

    public RestErrorException(RestStatus status, RestError error, Throwable cause) {
        super(status, error, cause);
    }

    public RestErrorException(RestError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super((DefaultError) error, cause, enableSuppression, writableStackTrace);
    }

    public RestErrorException(Integer status, RestError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, (DefaultError) error, cause, enableSuppression, writableStackTrace);
    }

    public RestErrorException(RestStatus status, RestError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, error, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public DefaultException get() {
        return new RestErrorException(RestResultStatus.UNKNOWN_ERROR);
    }
}
