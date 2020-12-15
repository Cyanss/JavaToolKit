package cyan.toolkit.rest.error.supply;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>ConfigInvalidException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:15 2020/8/18
 */
public class ConfigInvalidException extends RestErrorException {

    public ConfigInvalidException() {
        super(RestErrorStatus.CONFIG_INVALID);
    }

    public ConfigInvalidException(String field) {
        super(RestErrorStatus.CONFIG_INVALID, RestError.error(field, RestErrorStatus.CONFIG_INVALID));
    }

    public ConfigInvalidException(String field, String value) {
        super(RestErrorStatus.CONFIG_INVALID, RestError.error(field, value, RestErrorStatus.CONFIG_INVALID));
    }

    public ConfigInvalidException(String resource, String field, String value, String message) {
        super(RestErrorStatus.CONFIG_INVALID, RestError.error(resource, field, value, RestErrorStatus.CONFIG_INVALID,message));
    }

    @Override
    public ConfigInvalidException get() {
        return new ConfigInvalidException();
    }
}
