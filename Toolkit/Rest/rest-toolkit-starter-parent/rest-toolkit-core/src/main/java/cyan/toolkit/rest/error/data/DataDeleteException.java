package cyan.toolkit.rest.error.data;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>DataDeleteException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:08 2019/12/24
 */
public class DataDeleteException extends RestErrorException {
    public DataDeleteException() {
        super(RestErrorStatus.DATA_DELETE_FAILED);
    }

    public DataDeleteException(String resource) {
        super(RestErrorStatus.DATA_DELETE_FAILED, RestError.error(resource, RestErrorStatus.DATA_DELETE_FAILED));
    }

    public DataDeleteException(String resource, String message) {
        super(RestErrorStatus.DATA_DELETE_FAILED, RestError.error(resource, RestErrorStatus.DATA_DELETE_FAILED, message));
    }

    public DataDeleteException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_DELETE_FAILED, RestError.error(resource, value, RestErrorStatus.DATA_DELETE_FAILED, message));
    }

    @Override
    public DataDeleteException get() {
        return new DataDeleteException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.DATA_DELETE_FAILED.getName();
    }
}
