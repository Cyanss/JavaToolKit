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
public class DataSaveException extends RestErrorException {
    public DataSaveException() {
        super(RestErrorStatus.DATA_SAVE_FAILED);
    }

    public DataSaveException(String resource) {
        super(RestErrorStatus.DATA_SAVE_FAILED, RestError.error(resource, RestErrorStatus.DATA_SAVE_FAILED));
    }

    public DataSaveException(String resource, String message) {
        super(RestErrorStatus.DATA_SAVE_FAILED, RestError.error(resource, RestErrorStatus.DATA_SAVE_FAILED, message));
    }

    @Override
    public DataSaveException get() {
        return new DataSaveException();
    }
}
