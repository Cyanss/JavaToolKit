package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;

/**
 * <p>ClassConvertErrorException</p>
 * @valueor Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:59 2020/9/24
 */
public class ConvertErrorException extends RestErrorException {

    public ConvertErrorException() {
        super(RestErrorStatus.CONVERT_ERROR);
    }

    public ConvertErrorException(RestErrorStatus status) {
        super(status);
    }

    public ConvertErrorException(String error) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(RestErrorStatus.CONVERT_ERROR, error));
    }

    public ConvertErrorException(RestStatus status) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(status));
    }

    public ConvertErrorException(RestStatus status, RestError error) {
        super(status, error);
    }


    public ConvertErrorException(RestStatus status, String resource) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, status));
    }

    public ConvertErrorException(RestStatus status, String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, value, status));
    }

    public ConvertErrorException(RestStatus status, String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, status, message));
    }

    public ConvertErrorException(RestStatus status, String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, value, status, message));
    }

    public ConvertErrorException(String filed, String error) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(null, filed, null, RestErrorStatus.CONVERT_ERROR, error));
    }

    public ConvertErrorException(String filed, Object value) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(null, filed, value, RestErrorStatus.CONVERT_ERROR));
    }

    public ConvertErrorException(String filed, Object value, RestStatus status) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(null, filed, value, status));
    }

    public ConvertErrorException(String filed, Object value, String error) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(null, filed, value, RestErrorStatus.CONVERT_ERROR, error));
    }

    public ConvertErrorException(String filed, Object value, RestStatus status, String error) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(null, filed, value, status, error));
    }

    public ConvertErrorException(String resource, String filed, Object value) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(resource, filed, value, RestErrorStatus.CONVERT_ERROR));
    }

    public ConvertErrorException(String resource, String filed, Object value, RestStatus status) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(resource, filed, value, status));
    }

    public ConvertErrorException(String resource, String filed, Object value, String error) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(resource, filed, value, RestErrorStatus.CONVERT_ERROR, error));
    }

    public ConvertErrorException(String resource, String filed, Object value, RestStatus status, String error) {
        super(RestErrorStatus.CONVERT_ERROR, RestError.error(resource, filed, value, status, error));
    }

    @Override
    public ConvertErrorException get() {
        return new ConvertErrorException();
    }
}
