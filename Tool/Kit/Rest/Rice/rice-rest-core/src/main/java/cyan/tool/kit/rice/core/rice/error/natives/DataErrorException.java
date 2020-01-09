package cyan.tool.kit.rice.core.rice.error.natives;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestResultStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>DataErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:53 2019/12/19
 */
public class DataErrorException extends RestErrorException {
    
    public DataErrorException() {
        super(RestResultStatus.DATA_ERROR);
    }

    public DataErrorException(RestResultStatus status) {
        super(status);
    }

    public DataErrorException(String error) {
        super(RestResultStatus.DATA_ERROR, RestError.error(RestResultStatus.DATA_ERROR, error));
    }

    public DataErrorException(RestStatus status) {
        super(RestResultStatus.DATA_ERROR,RestError.error(status));
    }

    public DataErrorException(RestStatus status, String error) {
        super(RestResultStatus.DATA_ERROR,RestError.error(status, error));
    }

    @Override
    public DataErrorException get() {
        return new DataErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.DATA_ERROR).getName();
    }

}
