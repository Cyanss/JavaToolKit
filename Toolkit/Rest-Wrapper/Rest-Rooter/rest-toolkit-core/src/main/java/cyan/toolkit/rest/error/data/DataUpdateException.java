package cyan.toolkit.rest.error.data;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>DataUpdateException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:06 2019/12/24
 */
public class DataUpdateException extends RestErrorException {
    public DataUpdateException() {
        super(RestErrorStatus.DATA_UPDATE_FAILED);
    }

    public DataUpdateException(String resource) {
        super(RestErrorStatus.DATA_UPDATE_FAILED, RestError.error(resource, RestErrorStatus.DATA_UPDATE_FAILED));
    }

    public DataUpdateException(String resource, String message) {
        super(RestErrorStatus.DATA_UPDATE_FAILED, RestError.error(resource, RestErrorStatus.DATA_UPDATE_FAILED, message));
    }

    public DataUpdateException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_UPDATE_FAILED, RestError.error(resource, value, RestErrorStatus.DATA_UPDATE_FAILED, message));
    }

    @Override
    public DataUpdateException get() {
        return new DataUpdateException();
    }

    @Override
    public String name() {
        return RestErrorStatus.DATA_UPDATE_FAILED.name();
    }
}