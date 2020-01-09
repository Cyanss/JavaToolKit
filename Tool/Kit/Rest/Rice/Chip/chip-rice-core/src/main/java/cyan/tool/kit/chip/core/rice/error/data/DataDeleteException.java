package cyan.tool.kit.chip.core.rice.error.data;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>DataDeleteException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:08 2019/12/24
 */
public class DataDeleteException extends RestErrorException {
    public DataDeleteException() {
        super(RestResultStatus.DATA_DELETE_FAILED);
    }

    public DataDeleteException(String resource) {
        super(RestResultStatus.DATA_DELETE_FAILED, RestError.error(resource, RestResultStatus.DATA_DELETE_FAILED));
    }

    public DataDeleteException(String resource, String message) {
        super(RestResultStatus.DATA_DELETE_FAILED, RestError.error(resource, RestResultStatus.DATA_DELETE_FAILED, message));
    }

    public DataDeleteException(String resource, Object value, String message) {
        super(RestResultStatus.DATA_DELETE_FAILED, RestError.error(resource, value, RestResultStatus.DATA_DELETE_FAILED, message));
    }

    @Override
    public DataDeleteException get() {
        return new DataDeleteException();
    }

    @Override
    public String getName() {
        return RestResultStatus.DATA_DELETE_FAILED.getName();
    }
}
