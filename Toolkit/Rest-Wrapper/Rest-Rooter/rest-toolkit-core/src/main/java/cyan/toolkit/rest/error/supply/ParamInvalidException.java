package cyan.toolkit.rest.error.supply;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

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
    public ParamInvalidException get() {
        return new ParamInvalidException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.PARAM_INVALID.getName();
    }
}
