package cyan.toolkit.rest.error.supply;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>ForbiddenException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:28 2019/12/20
 */
public class ForbiddenException extends RestErrorException {
    public ForbiddenException() {
        super(RestErrorStatus.AUTH_FORBIDDEN);
    }

    public ForbiddenException(String user) {
        super(RestErrorStatus.AUTH_FORBIDDEN, RestError.error(null, user, RestErrorStatus.AUTH_FORBIDDEN));
    }

    public ForbiddenException(String resource, String user, String auth) {
        super(RestErrorStatus.AUTH_FORBIDDEN, RestError.error(resource, user, auth, RestErrorStatus.AUTH_FORBIDDEN));
    }

    @Override
    public ForbiddenException get() {
        return new ForbiddenException();
    }
}
