package cyan.toolkit.rest.error.supply;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>TimeoutException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:37 2019/12/20
 */
public class TimeoutException extends RestErrorException {

    public TimeoutException() {
        super(RestErrorStatus.TIME_OUT);
    }

    public TimeoutException(String resource) {
        super(RestErrorStatus.TIME_OUT, RestError.error(resource, RestErrorStatus.TIME_OUT));
    }

    @Override
    public TimeoutException get() {
        return new TimeoutException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.TIME_OUT.getName();
    }
}
