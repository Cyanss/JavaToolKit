package cyan.tool.kit.chip.core.rice.defaults;

import cyan.tool.kit.chip.core.rice.error.UnknownErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

/**
 * <p>RestException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:26 2019/12/17
 */
public class RestException extends DefaultException {

    public RestException() {
    }

    public RestException(String message) {
        super(message);
    }

    public RestException(Integer status) {
        super(status);
    }

    public RestException(RestStatus status) {
        super(status);
    }

    public RestException(Throwable cause) {
        super(cause);
    }

    public RestException(Integer status, String message) {
        super(status, message);
    }

    public RestException(Integer status, RestStatus riceStatus) {
        super(status, riceStatus);
    }

    public RestException(Integer status, Throwable cause) {
        super(status, cause);
    }

    public RestException(String message, RestStatus status) {
        super(message, status);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestException(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    public RestException(Integer status, String message, Throwable cause) {
        super(status, message, cause);
    }

    public RestException(String message, RestStatus riceStatus, Throwable cause) {
        super(message, riceStatus, cause);
    }

    public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RestException(RestStatus status, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, cause, enableSuppression, writableStackTrace);
    }

    public RestException(Integer status, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, message, cause, enableSuppression, writableStackTrace);
    }

    public RestException(Integer status, RestStatus riceStatus, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, riceStatus, cause, enableSuppression, writableStackTrace);
    }

    public RestException(String message, RestStatus status, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, status, cause, enableSuppression, writableStackTrace);
    }


    @Override
    public RestException get() {
        return new RestException(RestResultStatus.UNKNOWN_ERROR);
    }
}
