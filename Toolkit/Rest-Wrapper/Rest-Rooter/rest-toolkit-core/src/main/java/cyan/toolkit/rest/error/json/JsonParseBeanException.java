package cyan.toolkit.rest.error.json;

import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>JsonParseBeanException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:06 2019/12/24
 */
public class JsonParseBeanException extends JsonParseErrorException {
    public JsonParseBeanException() {
        super(RestErrorStatus.JSON_PARSE_BEAN);
    }

    public JsonParseBeanException(String resource) {
        super(RestErrorStatus.JSON_PARSE_BEAN, resource);
    }

    public JsonParseBeanException(String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_BEAN, resource, value);
    }

    public JsonParseBeanException(String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_BEAN, resource, message);
    }

    public JsonParseBeanException(String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_BEAN, resource, value, message);
    }

    @Override
    public JsonParseBeanException get() {
        return new JsonParseBeanException();
    }

    @Override
    public String name() {
        return RestErrorStatus.JSON_PARSE_BEAN.name();
    }
}
