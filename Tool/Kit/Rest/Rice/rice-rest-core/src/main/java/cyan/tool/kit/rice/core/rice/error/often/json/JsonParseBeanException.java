package cyan.tool.kit.rice.core.rice.error.often.json;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestResultStatus;

/**
 * <p>JsonParseBeanException</p>
 *
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:38 2019/12/25
 */
public class JsonParseBeanException extends RestErrorException {
    public JsonParseBeanException() {
        super(RestResultStatus.JSON_PARSE_BEAN);
    }

    public JsonParseBeanException(String resource) {
        super(RestResultStatus.JSON_PARSE_BEAN, RestError.error(resource, RestResultStatus.JSON_PARSE_BEAN));
    }

    public JsonParseBeanException(String resource, Object value) {
        super(RestResultStatus.JSON_PARSE_BEAN, RestError.error(resource, value, RestResultStatus.JSON_PARSE_BEAN));
    }

    public JsonParseBeanException(String resource, String message) {
        super(RestResultStatus.JSON_PARSE_BEAN, RestError.error(resource, RestResultStatus.JSON_PARSE_BEAN, message));
    }

    public JsonParseBeanException(String resource, Object value, String message) {
        super(RestResultStatus.JSON_PARSE_BEAN, RestError.error(resource, value, RestResultStatus.JSON_PARSE_BEAN, message));
    }

    @Override
    public JsonParseBeanException get() {
        return new JsonParseBeanException();
    }

    @Override
    public String getName() {
        return RestResultStatus.JSON_PARSE_BEAN.getName();
    }
}
