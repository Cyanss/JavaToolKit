package cyan.tool.kit.rice.core.rice.error.supply;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

/**
 * <p>FieldInvalidException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:04 2019/12/20
 */
public class ParamInvalidException extends RestErrorException {

    public ParamInvalidException() {
        super(RestErrorStatus.PARAM_INVALID);
    }

    public ParamInvalidException(String field) {
        super(RestErrorStatus.PARAM_INVALID, RestError.error(field, RestErrorStatus.PARAM_INVALID));
    }

    public ParamInvalidException(String field, String value) {
        super(RestErrorStatus.PARAM_INVALID, RestError.error(field, value, RestErrorStatus.PARAM_INVALID));
    }

    public ParamInvalidException(String resource, String field, String value, String message) {
        super(RestErrorStatus.PARAM_INVALID, RestError.error(resource, field, value, RestErrorStatus.PARAM_INVALID,message));
    }

    @Override
    public ForbiddenException get() {
        return new ForbiddenException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.PARAM_INVALID.getName();
    }
}
