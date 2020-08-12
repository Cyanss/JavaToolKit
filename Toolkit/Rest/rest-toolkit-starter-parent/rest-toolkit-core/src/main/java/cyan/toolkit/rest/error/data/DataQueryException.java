package cyan.toolkit.rest.error.data;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>DataQueryException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:09 2019/12/24
 */
public class DataQueryException extends RestErrorException {
    public DataQueryException() {
        super(RestErrorStatus.DATA_QUERY_FAILED);
    }

    public DataQueryException(String resource) {
        super(RestErrorStatus.DATA_QUERY_FAILED, RestError.error(resource, RestErrorStatus.DATA_QUERY_FAILED));
    }

    public DataQueryException(String resource, String message) {
        super(RestErrorStatus.DATA_QUERY_FAILED, RestError.error(resource, RestErrorStatus.DATA_QUERY_FAILED,message));
    }

    public DataQueryException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_QUERY_FAILED, RestError.error(resource,value, RestErrorStatus.DATA_QUERY_FAILED,message));
    }

    @Override
    public DataQueryException get() {
        return new DataQueryException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.DATA_QUERY_FAILED.getName();
    }
}
