package cyan.tool.kit.chip.core.rice.error.data.batch;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>DataBatchDeleteException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:15 2019/12/24
 */
public class DataBatchDeleteException extends RestErrorException {
    public DataBatchDeleteException() {
        super(RestResultStatus.DATA_DELETE_ALL_FAILED);
    }

    public DataBatchDeleteException(String resource) {
        super(RestResultStatus.DATA_DELETE_ALL_FAILED, RestError.error(resource, RestResultStatus.DATA_DELETE_ALL_FAILED));
    }

    public DataBatchDeleteException(String resource, String message) {
        super(RestResultStatus.DATA_DELETE_ALL_FAILED, RestError.error(resource, RestResultStatus.DATA_DELETE_ALL_FAILED, message));
    }

    public DataBatchDeleteException(String resource, Object value, String message) {
        super(RestResultStatus.DATA_DELETE_ALL_FAILED, RestError.error(resource, value, RestResultStatus.DATA_DELETE_ALL_FAILED, message));
    }

    @Override
    public DataBatchDeleteException get() {
        return new DataBatchDeleteException();
    }

    @Override
    public String getName() {
        return RestResultStatus.DATA_DELETE_ALL_FAILED.getName();
    }
}

