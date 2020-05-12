package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

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
        super(RestErrorStatus.DATA_ERROR);
    }

    public DataErrorException(RestErrorStatus status) {
        super(status);
    }

    public DataErrorException(String error) {
        super(RestErrorStatus.DATA_ERROR, RestError.error(RestErrorStatus.DATA_ERROR, error));
    }

    public DataErrorException(RestStatus status) {
        super(RestErrorStatus.DATA_ERROR,RestError.error(status));
    }

    public DataErrorException(RestStatus status, String error) {
        super(RestErrorStatus.DATA_ERROR,RestError.error(status, error));
    }

    @Override
    public DataErrorException get() {
        return new DataErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.DATA_ERROR).getName();
    }

}
