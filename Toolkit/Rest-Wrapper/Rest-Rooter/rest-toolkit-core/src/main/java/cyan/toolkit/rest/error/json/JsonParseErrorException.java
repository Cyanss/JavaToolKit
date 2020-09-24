package cyan.toolkit.rest.error.json;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;
import cyan.toolkit.rest.error.natives.ParseErrorException;

import java.util.Optional;

/**
 * <p>JsonParseErrorException</p>
 * @version V.0.0.1
 * @valueor Cyan (snow22314@outlook.com)
 * @group cyan.tool.kit
 * @date 9:04 2020/9/24
 */
public class JsonParseErrorException extends ParseErrorException {

    public JsonParseErrorException() {
        super(RestErrorStatus.JSON_PARSE_ERROR);
    }

    public JsonParseErrorException(RestErrorStatus status) {
        super(status);
    }

    public JsonParseErrorException(String error) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(RestErrorStatus.JSON_PARSE_ERROR, error));
    }

    public JsonParseErrorException(RestStatus status) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(status));
    }

    public JsonParseErrorException(RestStatus status, String resource) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, status));
    }

    public JsonParseErrorException(RestStatus status, String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, value, status));
    }

    public JsonParseErrorException(RestStatus status, String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, status, message));
    }

    public JsonParseErrorException(RestStatus status, String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, value, status, message));
    }

    @Override
    public JsonParseErrorException get() {
        return new JsonParseErrorException();
    }

    @Override
    public String name() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.JSON_PARSE_ERROR).name();
    }
}
