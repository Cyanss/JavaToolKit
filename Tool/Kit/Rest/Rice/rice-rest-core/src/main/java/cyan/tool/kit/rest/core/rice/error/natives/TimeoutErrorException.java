package cyan.tool.kit.rest.core.rice.error.natives;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;
import cyan.tool.kit.rest.core.rice.rest.RestStatus;

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
        super(RestResultStatus.TIME_OUT);
    }

    public TimeoutErrorException(RestResultStatus status) {
        super(status);
    }

    public TimeoutErrorException(String error) {
        super(RestResultStatus.TIME_OUT, RestError.error(error));
    }

    public TimeoutErrorException(RestStatus status) {
        super(RestResultStatus.TIME_OUT, RestError.error(status));
    }

    public TimeoutErrorException(RestStatus status, String error) {
        super(RestResultStatus.TIME_OUT, RestError.error(status, error));
    }

    public TimeoutErrorException(String resource, String error) {
        super(RestResultStatus.TIME_OUT, RestError.error(resource,error));
    }

    public TimeoutErrorException(String resource, RestStatus status) {
        super(RestResultStatus.TIME_OUT, RestError.error(resource, status));
    }

    public TimeoutErrorException(String resource, RestStatus status, String error) {
        super(RestResultStatus.TIME_OUT, RestError.error(resource, status, error));
    }

    @Override
    public TimeoutErrorException get() {
        return new TimeoutErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.TIME_OUT).getName();
    }

}
