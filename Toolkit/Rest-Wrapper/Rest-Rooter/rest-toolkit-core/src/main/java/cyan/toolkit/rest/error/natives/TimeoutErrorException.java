package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;

/**
 * <p>TimeoutException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:34 2019/12/17
 */
public class TimeoutErrorException extends RestErrorException {

    public TimeoutErrorException() {
        super(RestErrorStatus.TIME_OUT);
    }

    public TimeoutErrorException(RestErrorStatus status) {
        super(status);
    }

    public TimeoutErrorException(String error) {
        super(RestErrorStatus.TIME_OUT, RestError.error(error));
    }

    public TimeoutErrorException(RestStatus status) {
        super(RestErrorStatus.TIME_OUT, RestError.error(status));
    }

    public TimeoutErrorException(RestStatus status, String error) {
        super(RestErrorStatus.TIME_OUT, RestError.error(status, error));
    }

    public TimeoutErrorException(String resource, String error) {
        super(RestErrorStatus.TIME_OUT, RestError.error(resource,error));
    }

    public TimeoutErrorException(String resource, RestStatus status) {
        super(RestErrorStatus.TIME_OUT, RestError.error(resource, status));
    }

    public TimeoutErrorException(String resource, RestStatus status, String error) {
        super(RestErrorStatus.TIME_OUT, RestError.error(resource, status, error));
    }

    @Override
    public TimeoutErrorException get() {
        return new TimeoutErrorException();
    }

    @Override
    public String name() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.TIME_OUT).name();
    }

}
