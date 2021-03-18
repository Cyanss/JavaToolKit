package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

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
        super(RestErrorStatus.PARAM_ERROR);
    }

    public ParamErrorException(RestErrorStatus status) {
        super(status);
    }

    public ParamErrorException(String error) {
        super(RestErrorStatus.PARAM_ERROR, RestError.error(RestErrorStatus.PARAM_ERROR,error));
    }

    public ParamErrorException(RestStatus status) {
        super(RestErrorStatus.PARAM_ERROR, RestError.error(status));
    }

    public ParamErrorException(RestStatus status, RestError error) {
        super(status, error);
    }

    public ParamErrorException(RestStatus status, String error) {
        super(RestErrorStatus.PARAM_ERROR,RestError.error(status, error));
    }

    public ParamErrorException(String param, String error) {
        super(RestErrorStatus.PARAM_ERROR, RestError.error(param, RestErrorStatus.PARAM_ERROR, error));
    }

    public ParamErrorException(String param, Object value, String error) {
        super(RestErrorStatus.PARAM_ERROR, RestError.error(param, value, RestErrorStatus.PARAM_ERROR, error));
    }

    public ParamErrorException(String param, RestStatus status) {
        super(RestErrorStatus.PARAM_ERROR, RestError.error(param, status));
    }

    public ParamErrorException(String param, Object value, RestStatus status) {
        super(RestErrorStatus.PARAM_ERROR, RestError.error(param, value, status));
    }

    @Override
    public ParamErrorException get() {
        return new ParamErrorException();
    }

}
