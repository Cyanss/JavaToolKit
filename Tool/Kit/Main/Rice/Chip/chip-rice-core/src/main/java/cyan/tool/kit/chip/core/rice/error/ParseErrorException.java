package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>ParseError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:03 2019/12/17
 */
public class ParseErrorException extends RestErrorException {
    public ParseErrorException(String resource, String field, String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.paramError(resource,field,error));
    }
}
