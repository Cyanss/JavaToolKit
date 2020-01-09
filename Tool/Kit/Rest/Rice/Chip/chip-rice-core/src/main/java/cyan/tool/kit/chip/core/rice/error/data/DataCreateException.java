package cyan.tool.kit.chip.core.rice.error.data;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>DataCreateException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:23 2019/12/24
 */
public class DataCreateException extends RestErrorException {
    public DataCreateException() {
        super(RestResultStatus.DATA_CREATE_FAILED);
    }

    public DataCreateException(String resource) {
        super(RestResultStatus.DATA_CREATE_FAILED, RestError.error(resource, RestResultStatus.DATA_CREATE_FAILED));
    }

    public DataCreateException(String resource, String message) {
        super(RestResultStatus.DATA_CREATE_FAILED, RestError.error(resource, RestResultStatus.DATA_CREATE_FAILED, message));
    }

    public DataCreateException(String resource, Object value, String message) {
        super(RestResultStatus.DATA_CREATE_FAILED, RestError.error(resource, value, RestResultStatus.DATA_CREATE_FAILED, message));
    }

    @Override
    public DataCreateException get() {
        return new DataCreateException();
    }

    @Override
    public String getName() {
        return RestResultStatus.DATA_CREATE_FAILED.getName();
    }
}
