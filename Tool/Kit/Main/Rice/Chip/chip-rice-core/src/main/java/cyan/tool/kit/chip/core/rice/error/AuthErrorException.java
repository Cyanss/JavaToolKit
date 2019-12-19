package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

/**
 * <p>AuthErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:56 2019/12/19
 */
public class AuthErrorException extends RestErrorException {

    public AuthErrorException() {
        super(RestResultStatus.AUTH_ERROR, RestError.error(RestResultStatus.AUTH_ERROR));
    }

    public AuthErrorException(RestStatus status) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(status));
    }

    public AuthErrorException(String error) {
        super(RestResultStatus.AUTH_ERROR, RestError.error(RestResultStatus.AUTH_ERROR, error));
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
}
