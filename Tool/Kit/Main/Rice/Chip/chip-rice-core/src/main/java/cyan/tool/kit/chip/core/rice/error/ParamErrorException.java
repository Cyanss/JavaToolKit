package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>ParamException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:42 2019/12/17
 */
public class ParamErrorException extends RestErrorException {
    public ParamErrorException(String resource, String field, String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.paramError(resource,field,error));
    }
}
