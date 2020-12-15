package cyan.toolkit.rest.error.json;

import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>JsonParseSetException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:06 2019/12/24
 */
public class JsonParseSetException extends JsonParseErrorException {
    public JsonParseSetException() {
        super(RestErrorStatus.JSON_PARSE_SET);
    }

    public JsonParseSetException(String resource) {
        super(RestErrorStatus.JSON_PARSE_SET, resource);
    }

    public JsonParseSetException(String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_SET, resource, value);
    }

    public JsonParseSetException(String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_SET, resource, message);
    }

    public JsonParseSetException(String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_SET, resource, value, message);
    }

    @Override
    public JsonParseSetException get() {
        return new JsonParseSetException();
    }
}
