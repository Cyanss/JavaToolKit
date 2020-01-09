package cyan.tool.kit.rice.core.rice.error.data.batch;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestResultStatus;

/**
 * <p>DataBatchQueryException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:16 2019/12/24
 */
public class DataBatchQueryException extends RestErrorException {
    public DataBatchQueryException() {
        super(RestResultStatus.DATA_QUERY_ALL_FAILED);
    }

    public DataBatchQueryException(String resource) {
        super(RestResultStatus.DATA_QUERY_ALL_FAILED, RestError.error(resource, RestResultStatus.DATA_QUERY_ALL_FAILED));
    }

    public DataBatchQueryException(String resource, String message) {
        super(RestResultStatus.DATA_QUERY_ALL_FAILED, RestError.error(resource, RestResultStatus.DATA_QUERY_ALL_FAILED, message));
    }

    public DataBatchQueryException(String resource, Object value, String message) {
        super(RestResultStatus.DATA_QUERY_ALL_FAILED, RestError.error(resource, value, RestResultStatus.DATA_QUERY_ALL_FAILED, message));
    }

    @Override
    public DataBatchQueryException get() {
        return new DataBatchQueryException();
    }

    @Override
    public String getName() {
        return RestResultStatus.DATA_QUERY_ALL_FAILED.getName();
    }
}
