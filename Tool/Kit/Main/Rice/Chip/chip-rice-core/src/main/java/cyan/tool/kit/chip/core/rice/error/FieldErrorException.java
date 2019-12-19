package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

/**
 * <p>FieldErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:29 2019/12/19
 */
public class FieldErrorException extends RestErrorException {
    public FieldErrorException() {
        super(RestResultStatus.FIELD_ERROR,RestError.error(RestResultStatus.FIELD_ERROR));
    }

    public FieldErrorException(RestResultStatus status) {
        super(status);
    }

    public FieldErrorException(String error) {
        super(RestResultStatus.FIELD_ERROR,RestError.error(RestResultStatus.FIELD_ERROR, error));
    }

    public FieldErrorException(RestStatus status) {
        super(RestResultStatus.FIELD_ERROR, RestError.error(status));
    }

    public FieldErrorException(String filed, String error) {
        super(RestResultStatus.FIELD_ERROR, RestError.error(filed, error));
    }

    public FieldErrorException(String filed, Object value, String error) {
        super(RestResultStatus.FIELD_ERROR, RestError.error(filed, value, error));
    }

    public FieldErrorException(String filed, RestStatus status) {
        super(RestResultStatus.FIELD_ERROR, RestError.error(filed, status));
    }

    public FieldErrorException(String filed, Object value, RestStatus status) {
        super(RestResultStatus.FIELD_ERROR, RestError.error(filed, value, status));
    }

    @Override
    public FieldErrorException get() {
        return new FieldErrorException();
    }
}
