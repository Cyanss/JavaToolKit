package cyan.tool.kit.chip.core.rice.error.often;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>IdRepeatException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:07 2019/12/24
 */
public class IdRepeatException extends RestErrorException {
    public IdRepeatException() {
        super(RestResultStatus.ID_REPEATED);
    }

    public IdRepeatException(Object value) {
        super(RestResultStatus.ID_IS_NULL, RestError.error("Id",value,RestResultStatus.ID_REPEATED));
    }

    public IdRepeatException(String message) {
        super(RestResultStatus.ID_REPEATED, RestError.error("Id",RestResultStatus.ID_REPEATED,message));
    }

    public IdRepeatException(String field, Object value,String message) {
        super(RestResultStatus.ID_REPEATED, RestError.error(field,value,RestResultStatus.ID_REPEATED,message));
    }

    @Override
    public IdRepeatException get() {
        return new IdRepeatException();
    }

    @Override
    public String getName() {
        return RestResultStatus.ID_REPEATED.getName();
    }
}
