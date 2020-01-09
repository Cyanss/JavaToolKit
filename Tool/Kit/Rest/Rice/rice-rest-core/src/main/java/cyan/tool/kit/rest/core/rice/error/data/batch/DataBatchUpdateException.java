package cyan.tool.kit.rest.core.rice.error.data.batch;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;

/**
 * <p>DataBatchUpdateException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:13 2019/12/24
 */
public class DataBatchUpdateException extends RestErrorException {
    public DataBatchUpdateException() {
        super(RestResultStatus.DATA_UPDATE_ALL_FAILED);
    }

    public DataBatchUpdateException(String resource) {
        super(RestResultStatus.DATA_UPDATE_ALL_FAILED, RestError.error(resource, RestResultStatus.DATA_UPDATE_ALL_FAILED));
    }

    public DataBatchUpdateException(String resource, String message) {
        super(RestResultStatus.DATA_UPDATE_ALL_FAILED, RestError.error(resource, RestResultStatus.DATA_UPDATE_ALL_FAILED, message));
    }

    public DataBatchUpdateException(String resource, Object value, String message) {
        super(RestResultStatus.DATA_UPDATE_ALL_FAILED, RestError.error(resource, value, RestResultStatus.DATA_UPDATE_ALL_FAILED, message));
    }

    @Override
    public DataBatchUpdateException get() {
        return new DataBatchUpdateException();
    }

    @Override
    public String getName() {
        return RestResultStatus.DATA_UPDATE_ALL_FAILED.getName();
    }
}
