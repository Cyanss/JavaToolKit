package cyan.toolkit.rest.error.data;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>DataCreateException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:23 2019/12/24
 */
public class DataCreateException extends RestErrorException {
    public DataCreateException() {
        super(RestErrorStatus.DATA_CREATE_FAILED);
    }

    public DataCreateException(String resource) {
        super(RestErrorStatus.DATA_CREATE_FAILED, RestError.error(resource, RestErrorStatus.DATA_CREATE_FAILED));
    }

    public DataCreateException(String resource, String message) {
        super(RestErrorStatus.DATA_CREATE_FAILED, RestError.error(resource, RestErrorStatus.DATA_CREATE_FAILED, message));
    }

    public DataCreateException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_CREATE_FAILED, RestError.error(resource, value, RestErrorStatus.DATA_CREATE_FAILED, message));
    }

    @Override
    public DataCreateException get() {
        return new DataCreateException();
    }
}
