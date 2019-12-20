package cyan.tool.kit.chip.core.rice.error.supply;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.error.natives.TimeoutErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>TimeoutException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:37 2019/12/20
 */
public class TimeoutException extends RestErrorException {

    public TimeoutException() {
        super(RestResultStatus.TIME_OUT);
    }

    public TimeoutException(String resource) {
        super(RestResultStatus.TIME_OUT, RestError.error(resource,RestResultStatus.TIME_OUT));
    }

    @Override
    public TimeoutException get() {
        return new TimeoutException();
    }

    @Override
    public String getName() {
        return RestResultStatus.TIME_OUT.getName();
    }
}
