package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;

/**
 * <p>UnknownErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:36 2019/12/19
 */
public class UnknownErrorException extends RestErrorException {

    public UnknownErrorException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public UnknownErrorException(RestErrorStatus status) {
        super(status);
    }

    public UnknownErrorException(String error) {
        super(RestErrorStatus.UNKNOWN_ERROR, RestError.error(RestErrorStatus.UNKNOWN_ERROR, error));
    }

    public UnknownErrorException(RestStatus status) {
        super(RestErrorStatus.UNKNOWN_ERROR, RestError.error(status));
    }

    public UnknownErrorException(RestStatus status, String error) {
        super(RestErrorStatus.UNKNOWN_ERROR, RestError.error(status, error));
    }

    public UnknownErrorException(String target, String error) {
        super(RestErrorStatus.UNKNOWN_ERROR, RestError.error(target, RestErrorStatus.UNKNOWN_ERROR, error));
    }

    public UnknownErrorException(String target, RestStatus status) {
        super(RestErrorStatus.UNKNOWN_ERROR, RestError.error(target, status));
    }

    @Override
    public UnknownErrorException get() {
        return new UnknownErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.UNKNOWN_ERROR).getName();
    }
}
