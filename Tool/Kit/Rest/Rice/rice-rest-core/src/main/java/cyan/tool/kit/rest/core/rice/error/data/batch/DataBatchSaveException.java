package cyan.tool.kit.rest.core.rice.error.data.batch;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;

/**
 * <p>DataBatchSaveException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:14 2019/12/24
 */
public class DataBatchSaveException extends RestErrorException {
    public DataBatchSaveException() {
        super(RestResultStatus.DATA_SAVE_ALL_FAILED);
    }

    public DataBatchSaveException(String resource) {
        super(RestResultStatus.DATA_SAVE_ALL_FAILED, RestError.error(resource, RestResultStatus.DATA_SAVE_ALL_FAILED));
    }

    public DataBatchSaveException(String resource, String message) {
        super(RestResultStatus.DATA_SAVE_ALL_FAILED, RestError.error(resource, RestResultStatus.DATA_SAVE_ALL_FAILED, message));
    }

    public DataBatchSaveException(String resource, Object value, String message) {
        super(RestResultStatus.DATA_SAVE_ALL_FAILED, RestError.error(resource, value, RestResultStatus.DATA_SAVE_ALL_FAILED, message));
    }

    @Override
    public DataBatchSaveException get() {
        return new DataBatchSaveException();
    }

    @Override
    public String getName() {
        return RestResultStatus.DATA_SAVE_ALL_FAILED.getName();
    }
}