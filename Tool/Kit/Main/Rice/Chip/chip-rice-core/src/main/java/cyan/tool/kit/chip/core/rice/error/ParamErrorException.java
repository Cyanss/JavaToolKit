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

    public ParamErrorException() {
        super(RestResultStatus.PARAM_ERROR,RestError.error(RestResultStatus.PARAM_ERROR));
    }

    public ParamErrorException(RestResultStatus status) {
        super(status);
    }

    public ParamErrorException(String error) {
        super(RestResultStatus.PARAM_ERROR,RestError.error(RestResultStatus.PARAM_ERROR,error));
    }

    public ParamErrorException(RestStatus status) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(status));
    }

    public ParamErrorException(String param, String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(param, error));
    }

    public ParamErrorException(String param, Object value, String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(param, value, error));
    }

    public ParamErrorException(String param, RestStatus status) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(param, status));
    }

    public ParamErrorException(String param, Object value, RestStatus status) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(param, value, status));
    }

    @Override
    public ParamErrorException get() {
        return new ParamErrorException();
    }

}
