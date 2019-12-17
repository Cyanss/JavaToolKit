package cyan.tool.kit.chip.core.rice.rest;

/**
 * <p>RestError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:27 2019/12/17
 */
public class RestErrorException extends RestException {

    public RestErrorException() {
    }

    public RestErrorException(RestStatus error) {
        super(error);
    }

    public RestErrorException(Integer status, RestStatus error) {
        super(status, error);
    }

    public RestErrorException(RestStatus status, RestError error) {
        super(status, error);
    }

    public RestErrorException(RestStatus error, Throwable cause) {
        super(error, cause);
    }

    public RestErrorException(Integer status, RestStatus error, Throwable cause) {
        super(status, error, cause);
    }

    public RestErrorException(RestStatus status, RestError error, Throwable cause) {
        super(status, error, cause);
    }

    public RestErrorException(RestStatus error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(error, cause, enableSuppression, writableStackTrace);
    }

    public RestErrorException(Integer status, RestStatus error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status, error, cause, enableSuppression, writableStackTrace);
    }
}
