package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

/**
 * <p>DataErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:53 2019/12/19
 */
public class DataErrorException extends RestErrorException {
    
    public DataErrorException() {
        super(RestResultStatus.DATA_ERROR, RestError.error(RestResultStatus.DATA_ERROR));
    }

    public DataErrorException(RestResultStatus status) {
        super(status);
    }

    public DataErrorException(String error) {
        super(RestResultStatus.DATA_ERROR,RestError.error(RestResultStatus.DATA_ERROR, error));
    }

    public DataErrorException(RestStatus status) {
        super(RestResultStatus.DATA_ERROR, RestError.error(status));
    }

    @Override
    public DataErrorException get() {
        return new DataErrorException();
    }

}
