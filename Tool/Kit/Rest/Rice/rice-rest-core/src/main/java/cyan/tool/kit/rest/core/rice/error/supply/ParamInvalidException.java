package cyan.tool.kit.rest.core.rice.error.supply;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;

/**
 * <p>FieldInvalidException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:04 2019/12/20
 */
public class ParamInvalidException extends RestErrorException {

    public ParamInvalidException() {
        super(RestResultStatus.PARAM_INVALID);
    }

    public ParamInvalidException(String field) {
        super(RestResultStatus.PARAM_INVALID, RestError.error(field, RestResultStatus.PARAM_INVALID));
    }

    public ParamInvalidException(String field, String value) {
        super(RestResultStatus.PARAM_INVALID, RestError.error(field, value,RestResultStatus.PARAM_INVALID));
    }

    public ParamInvalidException(String resource, String field, String value, String message) {
        super(RestResultStatus.PARAM_INVALID, RestError.error(resource, field, value,RestResultStatus.PARAM_INVALID,message));
    }

    @Override
    public ForbiddenException get() {
        return new ForbiddenException();
    }

    @Override
    public String getName() {
        return RestResultStatus.PARAM_INVALID.getName();
    }
}
