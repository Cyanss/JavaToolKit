package cyan.toolkit.rest.error.data;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>DataBatchQueryException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:16 2019/12/24
 */
public class DataBatchQueryException extends RestErrorException {
    public DataBatchQueryException() {
        super(RestErrorStatus.DATA_QUERY_ALL_FAILED);
    }

    public DataBatchQueryException(String resource) {
        super(RestErrorStatus.DATA_QUERY_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_QUERY_ALL_FAILED));
    }

    public DataBatchQueryException(String resource, String message) {
        super(RestErrorStatus.DATA_QUERY_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_QUERY_ALL_FAILED, message));
    }

    public DataBatchQueryException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_QUERY_ALL_FAILED, RestError.error(resource, value, RestErrorStatus.DATA_QUERY_ALL_FAILED, message));
    }

    @Override
    public DataBatchQueryException get() {
        return new DataBatchQueryException();
    }
}
