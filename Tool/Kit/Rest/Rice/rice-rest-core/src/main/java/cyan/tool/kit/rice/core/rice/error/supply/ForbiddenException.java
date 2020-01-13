package cyan.tool.kit.rice.core.rice.error.supply;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

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

    @Override
    public String getName() {
        return RestErrorStatus.AUTH_FORBIDDEN.getName();
    }
}
