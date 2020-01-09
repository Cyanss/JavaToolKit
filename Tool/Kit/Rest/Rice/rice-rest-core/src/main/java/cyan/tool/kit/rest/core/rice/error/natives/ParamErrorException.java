package cyan.tool.kit.rest.core.rice.error.natives;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;
import cyan.tool.kit.rest.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>ParamException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:42 2019/12/17
 */
public class ParamErrorException extends RestErrorException {

    public ParamErrorException() {
        super(RestResultStatus.PARAM_ERROR);
    }

    public ParamErrorException(RestResultStatus status) {
        super(status);
    }

    public ParamErrorException(String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(RestResultStatus.PARAM_ERROR,error));
    }

    public ParamErrorException(RestStatus status) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(status));
    }

    public ParamErrorException(RestStatus status, String error) {
        super(RestResultStatus.PARAM_ERROR,RestError.error(status, error));
    }

    public ParamErrorException(String param, String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(param,RestResultStatus.PARAM_ERROR, error));
    }

    public ParamErrorException(String param, Object value, String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(param, value, RestResultStatus.PARAM_ERROR, error));
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

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.PARAM_ERROR).getName();
    }

}
