package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

/**
 * <p>ParamException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:42 2019/12/17
 */
public class ParamErrorException extends RestErrorException {

    public ParamErrorException(Integer status) {
        super(RestError.error(status,RestResultStatus.PARAM_ERROR));
    }
    public ParamErrorException(String error) {
        super(RestError.error(RestResultStatus.PARAM_ERROR,error));
    }

    public ParamErrorException(RestResultStatus status) {
        super(status);
    }

    public ParamErrorException(RestStatus status) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(status));
    }

    public ParamErrorException(String filed, String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(filed, error));
    }

    public ParamErrorException(String filed, Object value, String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(filed, value, error));
    }

    public ParamErrorException(String filed, RestStatus status) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(filed, status));
    }

    public ParamErrorException(String filed, Object value, RestStatus status) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(filed, value, status));
    }

}
