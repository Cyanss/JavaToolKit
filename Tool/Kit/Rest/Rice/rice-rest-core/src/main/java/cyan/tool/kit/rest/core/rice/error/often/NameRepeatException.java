package cyan.tool.kit.rest.core.rice.error.often;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;

/**
 * <p>RepeatNameException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:02 2019/12/24
 */
public class NameRepeatException extends RestErrorException {
    public NameRepeatException() {
        super(RestResultStatus.NAME_REPEATED);
    }

    public NameRepeatException(Object value) {
        super(RestResultStatus.NAME_REPEATED, RestError.error("name",value,RestResultStatus.NAME_REPEATED));
    }

    public NameRepeatException(String message) {
        super(RestResultStatus.NAME_REPEATED, RestError.error("name",RestResultStatus.NAME_REPEATED,message));
    }

    public NameRepeatException(String field, Object value,String message) {
        super(RestResultStatus.NAME_REPEATED, RestError.error(field,value,RestResultStatus.NAME_REPEATED,message));
    }

    @Override
    public NameRepeatException get() {
        return new NameRepeatException();
    }

    @Override
    public String getName() {
        return RestResultStatus.NAME_REPEATED.getName();
    }
}
