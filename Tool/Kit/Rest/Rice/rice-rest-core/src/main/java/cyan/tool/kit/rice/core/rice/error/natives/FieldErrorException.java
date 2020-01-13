package cyan.tool.kit.rice.core.rice.error.natives;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>FieldErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:29 2019/12/19
 */
public class FieldErrorException extends RestErrorException {
    public FieldErrorException() {
        super(RestErrorStatus.FIELD_ERROR);
    }

    public FieldErrorException(RestErrorStatus status) {
        super(status);
    }

    public FieldErrorException(String error) {
        super(RestErrorStatus.FIELD_ERROR, RestError.error(RestErrorStatus.FIELD_ERROR, error));
    }

    public FieldErrorException(RestStatus status) {
        super(RestErrorStatus.FIELD_ERROR, RestError.error(status));
    }

    public FieldErrorException(RestStatus status, String error) {
        super(RestErrorStatus.FIELD_ERROR,RestError.error(status, error));
    }

    public FieldErrorException(String filed, String error) {
        super(RestErrorStatus.FIELD_ERROR, RestError.error(filed, RestErrorStatus.FIELD_ERROR, error));
    }

    public FieldErrorException(String filed, Object value, String error) {
        super(RestErrorStatus.FIELD_ERROR, RestError.error(filed, value, RestErrorStatus.FIELD_ERROR, error));
    }

    public FieldErrorException(String filed, RestStatus status) {
        super(RestErrorStatus.FIELD_ERROR, RestError.error(filed, status));
    }

    public FieldErrorException(String filed, Object value, RestStatus status) {
        super(RestErrorStatus.FIELD_ERROR, RestError.error(filed, value, status));
    }

    @Override
    public FieldErrorException get() {
        return new FieldErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.FIELD_ERROR).getName();
    }
}
