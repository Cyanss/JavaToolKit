package cyan.tool.kit.chip.core.rice.error.natives;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>AuthErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:56 2019/12/19
 */
public class AuthErrorException extends RestErrorException {

    public AuthErrorException() {
        super(RestResultStatus.AUTH_ERROR);
    }

    public AuthErrorException(RestResultStatus status) {
        super(status);
    }

    public AuthErrorException(String error) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(RestResultStatus.AUTH_ERROR, error));
    }

    public AuthErrorException(RestStatus status) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(status));
    }

    public AuthErrorException(RestStatus status, String error) {
        super(RestResultStatus.AUTH_ERROR,RestError.error(status, error));
    }

    public AuthErrorException(String user, String error) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(null, user, null, RestResultStatus.AUTH_ERROR, error));
    }

    public AuthErrorException(String user, Object auth) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(null, user, auth, RestResultStatus.AUTH_ERROR));
    }

    public AuthErrorException(String user, Object auth, RestStatus status) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(null, user, auth, status));
    }

    public AuthErrorException(String user, Object auth, String error) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(null, user, auth, RestResultStatus.AUTH_ERROR, error));
    }

    public AuthErrorException(String user, Object auth, RestStatus status, String error) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(null, user, auth, status, error));
    }

    public AuthErrorException(String resource, String user, Object auth) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(resource, user, auth, RestResultStatus.AUTH_ERROR));
    }

    public AuthErrorException(String resource, String user, Object auth, RestStatus status) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(resource, user, auth, status));
    }

    public AuthErrorException(String resource, String user, Object auth, String error) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(resource, user, auth, RestResultStatus.AUTH_ERROR, error));
    }

    public AuthErrorException(String resource, String user, Object auth, RestStatus status, String error) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(resource, user, auth, status, error));
    }

    @Override
    public AuthErrorException get() {
        return new AuthErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.AUTH_ERROR).getName();
    }
}
