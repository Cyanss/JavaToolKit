package cyan.tool.kit.chip.core.rice.error.supply;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>ParamMissingException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:07 2019/12/20
 */
public class ParamMissingException extends RestErrorException {

    public ParamMissingException() {
        super(RestResultStatus.PARAM_MISSING);
    }

    public ParamMissingException(String field) {
        super(RestResultStatus.PARAM_MISSING, RestError.error(field, RestResultStatus.PARAM_MISSING));
    }

    public ParamMissingException(String resource, String field) {
        super(RestResultStatus.PARAM_MISSING, RestError.error(resource, field, RestResultStatus.PARAM_MISSING));
    }

    @Override
    public ForbiddenException get() {
        return new ForbiddenException();
    }

    @Override
    public String getName() {
        return RestResultStatus.PARAM_MISSING.getName();
    }
}
