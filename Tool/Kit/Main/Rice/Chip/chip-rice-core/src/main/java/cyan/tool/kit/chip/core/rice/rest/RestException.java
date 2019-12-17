package cyan.tool.kit.chip.core.rice.rest;

import cyan.tool.kit.chip.core.rice.defaults.DefaultError;
import cyan.tool.kit.chip.core.rice.defaults.DefaultException;

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

    public RestException(DefaultError error) {
        super(error);
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

    public RestException(Integer status, DefaultError error) {
        super(status, error);
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

    public RestException(RestStatus status, DefaultError error) {
        super(status, error);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestException(DefaultError error, Throwable cause) {
        super(error, cause);
    }

    public RestException(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    public RestException(int status, String message, DefaultError error) {
        super(status, message, error);
    }

    public RestException(Integer status, String message, Throwable cause) {
        super(status, message, cause);
    }

    public RestException(Integer status, DefaultError error, Throwable cause) {
        super(status, error, cause);
    }

    public RestException(Integer status, RestStatus riceStatus, Throwable cause) {
        super(status, riceStatus, cause);
    }

    public RestException(String message, RestStatus riceStatus, Throwable cause) {
        super(message, riceStatus, cause);
    }

    public RestException(RestStatus status, DefaultError error, Throwable cause) {
        super(status, error, cause);
    }

    public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RestException(DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(error, cause, enableSuppression, writableStackTrace);
    }

    public RestException(RestStatus status, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, cause, enableSuppression, writableStackTrace);
    }

    public RestException(Integer status, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, message, cause, enableSuppression, writableStackTrace);
    }

    public RestException(Integer status, DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, error, cause, enableSuppression, writableStackTrace);
    }

    public RestException(Integer status, RestStatus riceStatus, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, riceStatus, cause, enableSuppression, writableStackTrace);
    }

    public RestException(String message, RestStatus status, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, status, cause, enableSuppression, writableStackTrace);
    }

    public RestException(RestStatus status, DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, error, cause, enableSuppression, writableStackTrace);
    }
}
