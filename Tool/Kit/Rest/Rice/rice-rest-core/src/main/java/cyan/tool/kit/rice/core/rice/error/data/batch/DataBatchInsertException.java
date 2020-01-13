package cyan.tool.kit.rice.core.rice.error.data.batch;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

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

    @Override
    public String getName() {
        return RestErrorStatus.DATA_INSERT_ALL_FAILED.getName();
    }
}
