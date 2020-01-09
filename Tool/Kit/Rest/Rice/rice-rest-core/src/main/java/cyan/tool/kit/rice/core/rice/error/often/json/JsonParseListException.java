package cyan.tool.kit.rice.core.rice.error.often.json;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestResultStatus;

/**
 * <p>JsonParseListException</p>
 *
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:43 2019/12/25
 */
public class JsonParseListException extends RestErrorException {
    public JsonParseListException() {
        super(RestResultStatus.JSON_PARSE_LIST);
    }

    public JsonParseListException(String resource) {
        super(RestResultStatus.JSON_PARSE_LIST, RestError.error(resource, RestResultStatus.JSON_PARSE_LIST));
    }

    public JsonParseListException(String resource, Object value) {
        super(RestResultStatus.JSON_PARSE_LIST, RestError.error(resource, value, RestResultStatus.JSON_PARSE_LIST));
    }

    public JsonParseListException(String resource, String message) {
        super(RestResultStatus.JSON_PARSE_LIST, RestError.error(resource, RestResultStatus.JSON_PARSE_LIST, message));
    }

    public JsonParseListException(String resource, Object value, String message) {
        super(RestResultStatus.JSON_PARSE_LIST, RestError.error(resource, value, RestResultStatus.JSON_PARSE_LIST, message));
    }

    @Override
    public JsonParseListException get() {
        return new JsonParseListException();
    }

    @Override
    public String getName() {
        return RestResultStatus.JSON_PARSE_LIST.getName();
    }
}
