package cyan.toolkit.rest.error.supply;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>ParamMissingException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:07 2019/12/20
 */
public class ParamMissingException extends RestErrorException {

    public ParamMissingException() {
        super(RestErrorStatus.PARAM_MISSING);
    }

    public ParamMissingException(String field) {
        super(RestErrorStatus.PARAM_MISSING, RestError.error(field, RestErrorStatus.PARAM_MISSING));
    }

    public ParamMissingException(String resource, String field) {
        super(RestErrorStatus.PARAM_MISSING, RestError.error(resource, field, RestErrorStatus.PARAM_MISSING));
    }

    @Override
    public ParamMissingException get() {
        return new ParamMissingException();
    }

    @Override
    public String name() {
        return RestErrorStatus.PARAM_MISSING.name();
    }
}
