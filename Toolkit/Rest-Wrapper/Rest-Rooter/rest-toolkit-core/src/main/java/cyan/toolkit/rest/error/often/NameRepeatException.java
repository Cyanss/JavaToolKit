package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>RepeatNameException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:02 2019/12/24
 */
public class NameRepeatException extends RestErrorException {
    public NameRepeatException() {
        super(RestErrorStatus.NAME_REPEATED);
    }

    public NameRepeatException(Object value) {
        super(RestErrorStatus.NAME_REPEATED, RestError.error("name", value, RestErrorStatus.NAME_REPEATED));
    }

    public NameRepeatException(String resource, Object value) {
        super(RestErrorStatus.NAME_REPEATED, RestError.error(resource,"name", value, RestErrorStatus.NAME_REPEATED));
    }

    public NameRepeatException(String resource, Object value, String message) {
        super(RestErrorStatus.NAME_REPEATED, RestError.error(resource, "name", value, RestErrorStatus.NAME_REPEATED,message));
    }

    @Override
    public NameRepeatException get() {
        return new NameRepeatException();
    }
}
