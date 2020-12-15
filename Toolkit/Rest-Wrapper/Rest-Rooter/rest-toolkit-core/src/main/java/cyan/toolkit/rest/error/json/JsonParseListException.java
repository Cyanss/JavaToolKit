package cyan.toolkit.rest.error.json;

import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>JsonParseListException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:06 2019/12/24
 */
public class JsonParseListException extends JsonParseErrorException {
    public JsonParseListException() {
        super(RestErrorStatus.JSON_PARSE_LIST);
    }

    public JsonParseListException(String resource) {
        super(RestErrorStatus.JSON_PARSE_LIST, resource);
    }

    public JsonParseListException(String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_LIST, resource, value);
    }

    public JsonParseListException(String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_LIST, resource, message);
    }

    public JsonParseListException(String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_LIST, resource, value, message);
    }

    @Override
    public JsonParseListException get() {
        return new JsonParseListException();
    }
}
