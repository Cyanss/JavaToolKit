package cyan.tool.kit.rest.core.rice.error.data;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;

/**
 * <p>DataUpdateException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:06 2019/12/24
 */
public class DataUpdateException extends RestErrorException {
    public DataUpdateException() {
        super(RestResultStatus.DATA_UPDATE_FAILED);
    }

    public DataUpdateException(String resource) {
        super(RestResultStatus.DATA_UPDATE_FAILED, RestError.error(resource, RestResultStatus.DATA_UPDATE_FAILED));
    }

    public DataUpdateException(String resource, String message) {
        super(RestResultStatus.DATA_UPDATE_FAILED, RestError.error(resource, RestResultStatus.DATA_UPDATE_FAILED, message));
    }

    public DataUpdateException(String resource, Object value, String message) {
        super(RestResultStatus.DATA_UPDATE_FAILED, RestError.error(resource, value, RestResultStatus.DATA_UPDATE_FAILED, message));
    }

    @Override
    public DataUpdateException get() {
        return new DataUpdateException();
    }

    @Override
    public String getName() {
        return RestResultStatus.DATA_UPDATE_FAILED.getName();
    }
}