package cyan.toolkit.rest.error.supply;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>JsonDeserializeException</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:10 2019/12/25
 */
public class JsonDeserializeException extends RestErrorException {
    public JsonDeserializeException() {
        super(RestErrorStatus.JSON_DESERIALIZE_ERROR);
    }

    public JsonDeserializeException(String message) {
        super(RestErrorStatus.JSON_DESERIALIZE_ERROR, RestError.error(RestErrorStatus.JSON_DESERIALIZE_ERROR, message));
    }

    @Override
    public JsonDeserializeException get() {
        return new JsonDeserializeException();
    }

    @Override
    public String name() {
        return RestErrorStatus.JSON_DESERIALIZE_ERROR.name();
    }
}
