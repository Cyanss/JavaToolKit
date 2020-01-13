package cyan.tool.kit.rice.core.rice.error.natives;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>IdentityErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:59 2020/1/13
 */
public class IdentityErrorException extends RestErrorException {
    public IdentityErrorException() {
        super(RestErrorStatus.IDENTITY_ERROR);
    }

    public IdentityErrorException(RestErrorStatus status) {
        super(status);
    }

    public IdentityErrorException(String error) {
        super(RestErrorStatus.IDENTITY_ERROR, RestError.error(RestErrorStatus.IDENTITY_ERROR,error));
    }

    public IdentityErrorException(RestStatus status) {
        super(RestErrorStatus.IDENTITY_ERROR, RestError.error(status));
    }

    public IdentityErrorException(RestStatus status, String error) {
        super(RestErrorStatus.IDENTITY_ERROR,RestError.error(status, error));
    }

    public IdentityErrorException(String field, Object value) {
        super(RestErrorStatus.IDENTITY_ERROR, RestError.error(field, value, RestErrorStatus.IDENTITY_ERROR));
    }

    public IdentityErrorException(String field, String error) {
        super(RestErrorStatus.IDENTITY_ERROR, RestError.error(field, RestErrorStatus.IDENTITY_ERROR, error));
    }

    public IdentityErrorException(String field, Object value, String error) {
        super(RestErrorStatus.IDENTITY_ERROR, RestError.error(field, value, RestErrorStatus.IDENTITY_ERROR, error));
    }

    public IdentityErrorException(String field, RestStatus status) {
        super(RestErrorStatus.IDENTITY_ERROR, RestError.error(field, status));
    }

    public IdentityErrorException(String field, Object value, RestStatus status) {
        super(RestErrorStatus.IDENTITY_ERROR, RestError.error(field, value, status));
    }

    public IdentityErrorException(String field, RestStatus status, String error) {
        super(RestErrorStatus.IDENTITY_ERROR, RestError.error(field, status, error));
    }

    public IdentityErrorException(String field, Object value, RestStatus status, String error) {
        super(RestErrorStatus.IDENTITY_ERROR, RestError.error(field, value, status, error));
    }


    @Override
    public IdentityErrorException get() {
        return new IdentityErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.IDENTITY_ERROR).getName();
    }
}
