package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>TimeoutException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:34 2019/12/17
 */
public class TimeoutException extends RestErrorException {

    public TimeoutException() {
        super(RestResultStatus.TIME_OUT, RestError.error(RestResultStatus.TIME_OUT));
    }

    public TimeoutException(RestResultStatus status) {
        super(status);
    }

    public TimeoutException(String error) {
        super(RestResultStatus.TIME_OUT, RestError.error(error));
    }

    public TimeoutException(RestStatus status) {
        super(RestResultStatus.TIME_OUT, RestError.error(status));
    }

    public TimeoutException(String resource, String error) {
        super(RestResultStatus.TIME_OUT, RestError.error(resource,error));
    }

    public TimeoutException(String resource, RestStatus status) {
        super(RestResultStatus.TIME_OUT, RestError.error(resource, status));
    }

    public TimeoutException(String resource, RestStatus status, String error) {
        super(RestResultStatus.TIME_OUT, RestError.error(resource, status, error));
    }

    @Override
    public TimeoutException get() {
        return new TimeoutException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.TIME_OUT).getName();
    }

}
