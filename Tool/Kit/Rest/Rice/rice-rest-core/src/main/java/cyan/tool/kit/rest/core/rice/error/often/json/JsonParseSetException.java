package cyan.tool.kit.rest.core.rice.error.often.json;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;

/**
 * <p>JsonParseSetException</p>
 *
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:45 2019/12/25
 */
public class JsonParseSetException extends RestErrorException {
    public JsonParseSetException() {
        super(RestResultStatus.JSON_PARSE_SET);
    }

    public JsonParseSetException(String resource) {
        super(RestResultStatus.JSON_PARSE_SET, RestError.error(resource, RestResultStatus.JSON_PARSE_SET));
    }

    public JsonParseSetException(String resource, Object value) {
        super(RestResultStatus.JSON_PARSE_SET, RestError.error(resource, value, RestResultStatus.JSON_PARSE_SET));
    }

    public JsonParseSetException(String resource, String message) {
        super(RestResultStatus.JSON_PARSE_SET, RestError.error(resource, RestResultStatus.JSON_PARSE_SET, message));
    }

    public JsonParseSetException(String resource, Object value, String message) {
        super(RestResultStatus.JSON_PARSE_SET, RestError.error(resource, value, RestResultStatus.JSON_PARSE_SET, message));
    }

    @Override
    public JsonParseSetException get() {
        return new JsonParseSetException();
    }

    @Override
    public String getName() {
        return RestResultStatus.JSON_PARSE_SET.getName();
    }
}
