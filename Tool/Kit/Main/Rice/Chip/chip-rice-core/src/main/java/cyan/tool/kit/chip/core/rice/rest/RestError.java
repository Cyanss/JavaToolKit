package cyan.tool.kit.chip.core.rice.rest;

import cyan.tool.kit.chip.core.rice.defaults.DefaultError;

/**
 * <p>RestError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:27 2019/12/17
 */
public class RestError extends RestException {

    public RestError() {
    }

    public RestError(DefaultError error) {
        super(error);
    }

    public RestError(Integer status, DefaultError error) {
        super(status, error);
    }

    public RestError(RestStatus status, DefaultError error) {
        super(status, error);
    }

    public RestError(DefaultError error, Throwable cause) {
        super(error, cause);
    }

    public RestError(Integer status, DefaultError error, Throwable cause) {
        super(status, error, cause);
    }

    public RestError(RestStatus status, DefaultError error, Throwable cause) {
        super(status, error, cause);
    }

    public RestError(DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(error, cause, enableSuppression, writableStackTrace);
    }

    public RestError(Integer status, DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, error, cause, enableSuppression, writableStackTrace);
    }

    public RestError(RestStatus status, DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, error, cause, enableSuppression, writableStackTrace);
    }
}
