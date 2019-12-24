package cyan.tool.kit.chip.core.rice.error.data;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>DataQueryException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:09 2019/12/24
 */
public class DataQueryException extends RestErrorException {
    public DataQueryException() {
        super(RestResultStatus.DATA_QUERY_FAILED);
    }

    public DataQueryException(String resource) {
        super(RestResultStatus.DATA_QUERY_FAILED, RestError.error(resource,RestResultStatus.DATA_QUERY_FAILED));
    }

    public DataQueryException(String resource, String message) {
        super(RestResultStatus.DATA_QUERY_FAILED, RestError.error(resource,RestResultStatus.DATA_QUERY_FAILED,message));
    }

    public DataQueryException(String resource, Object value, String message) {
        super(RestResultStatus.DATA_QUERY_FAILED, RestError.error(resource,value,RestResultStatus.DATA_QUERY_FAILED,message));
    }

    @Override
    public DataQueryException get() {
        return new DataQueryException();
    }

    @Override
    public String getName() {
        return RestResultStatus.DATA_QUERY_FAILED.getName();
    }
}
