package cyan.toolkit.rest.error.data;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>DataBatchDeleteException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:15 2019/12/24
 */
public class DataBatchDeleteException extends RestErrorException {
    public DataBatchDeleteException() {
        super(RestErrorStatus.DATA_DELETE_ALL_FAILED);
    }

    public DataBatchDeleteException(String resource) {
        super(RestErrorStatus.DATA_DELETE_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_DELETE_ALL_FAILED));
    }

    public DataBatchDeleteException(String resource, String message) {
        super(RestErrorStatus.DATA_DELETE_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_DELETE_ALL_FAILED, message));
    }

    public DataBatchDeleteException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_DELETE_ALL_FAILED, RestError.error(resource, value, RestErrorStatus.DATA_DELETE_ALL_FAILED, message));
    }

    @Override
    public DataBatchDeleteException get() {
        return new DataBatchDeleteException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.DATA_DELETE_ALL_FAILED.getName();
    }
}

