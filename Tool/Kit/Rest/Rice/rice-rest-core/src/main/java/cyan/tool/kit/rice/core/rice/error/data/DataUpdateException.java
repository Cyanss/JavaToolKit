package cyan.tool.kit.rice.core.rice.error.data;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

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
    public String getName() {
        return RestErrorStatus.DATA_UPDATE_FAILED.getName();
    }
}