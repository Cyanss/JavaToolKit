package cyan.tool.kit.rice.core.rice.error.supply;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestResultStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

/**
 * <p>JsonParseException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:31 2019/12/20
 */
public class JsonParseException extends RestErrorException {
    public JsonParseException() {
        super(RestResultStatus.JSON_PARSE_ERROR);
    }

    public JsonParseException(String resource, String json) {
        super(RestResultStatus.JSON_PARSE_ERROR, RestError.error(resource, json, RestResultStatus.JSON_PARSE_ERROR));
    }

    public JsonParseException(String resource, String json, String message) {
        super(RestResultStatus.JSON_PARSE_ERROR, RestError.error(resource, json, RestResultStatus.JSON_PARSE_ERROR, message));
    }

    public JsonParseException(String resource, String json, String className, String message) {
        super(RestResultStatus.JSON_PARSE_ERROR, RestError.error(resource, json, className, RestResultStatus.JSON_PARSE_ERROR, message));
    }

    public JsonParseException(String resource, String json, RestStatus status, String message) {
        super(status, RestError.error(resource, json, status, message));
    }

    public JsonParseException(String resource, String json, String className, RestStatus status, String message) {
        super(status, RestError.error(resource, json, className, status, message));
    }

    @Override
    public JsonParseException get() {
        return new JsonParseException();
    }

    @Override
    public String getName() {
        return RestResultStatus.JSON_PARSE_ERROR.getName();
    }
}
