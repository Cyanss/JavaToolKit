package cyan.toolkit.rest.error.json;

import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>JsonParseMapException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:06 2019/12/24
 */
public class JsonParseMapException extends JsonParseErrorException {
    public JsonParseMapException() {
        super(RestErrorStatus.JSON_PARSE_MAP);
    }

    public JsonParseMapException(String resource) {
        super(RestErrorStatus.JSON_PARSE_MAP, resource);
    }

    public JsonParseMapException(String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_MAP, resource, value);
    }

    public JsonParseMapException(String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_MAP, resource, message);
    }

    public JsonParseMapException(String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_MAP, resource, value, message);
    }

    @Override
    public JsonParseMapException get() {
        return new JsonParseMapException();
    }
}
