package cyan.tool.kit.rice.core.rice.error.often.json;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

/**
 * <p>JsonParseMapException</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:54 2019/12/25
 */
public class JsonParseMapException extends RestErrorException {
    public JsonParseMapException() {
        super(RestErrorStatus.JSON_PARSE_MAP);
    }

    public JsonParseMapException(String resource) {
        super(RestErrorStatus.JSON_PARSE_MAP, RestError.error(resource, RestErrorStatus.JSON_PARSE_MAP));
    }

    public JsonParseMapException(String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_MAP, RestError.error(resource, value, RestErrorStatus.JSON_PARSE_MAP));
    }

    public JsonParseMapException(String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_MAP, RestError.error(resource, RestErrorStatus.JSON_PARSE_MAP, message));
    }

    public JsonParseMapException(String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_MAP, RestError.error(resource, value, RestErrorStatus.JSON_PARSE_MAP, message));
    }

    @Override
    public JsonParseMapException get() {
        return new JsonParseMapException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.JSON_PARSE_MAP.getName();
    }
}
