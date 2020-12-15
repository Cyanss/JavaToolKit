package cyan.toolkit.rest.error.data;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>DataBatchInsertException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:11 2019/12/24
 */
public class DataBatchInsertException extends RestErrorException {
    public DataBatchInsertException() {
        super(RestErrorStatus.DATA_INSERT_ALL_FAILED);
    }

    public DataBatchInsertException(String resource) {
        super(RestErrorStatus.DATA_INSERT_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_INSERT_ALL_FAILED));
    }

    public DataBatchInsertException(String resource, String message) {
        super(RestErrorStatus.DATA_INSERT_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_INSERT_ALL_FAILED, message));
    }

    public DataBatchInsertException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_INSERT_ALL_FAILED, RestError.error(resource, value, RestErrorStatus.DATA_INSERT_ALL_FAILED, message));
    }

    @Override
    public DataBatchInsertException get() {
        return new DataBatchInsertException();
    }
}
