package cyan.tool.kit.rice.core.rice.error.supply;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestResultStatus;

/**
 * <p>ForbiddenException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:28 2019/12/20
 */
public class ForbiddenException extends RestErrorException {
    public ForbiddenException() {
        super(RestResultStatus.AUTH_FORBIDDEN);
    }

    public ForbiddenException(String user) {
        super(RestResultStatus.AUTH_FORBIDDEN, RestError.error(null, user, RestResultStatus.AUTH_FORBIDDEN));
    }

    public ForbiddenException(String resource, String user, String auth) {
        super(RestResultStatus.AUTH_FORBIDDEN, RestError.error(resource, user, auth,RestResultStatus.AUTH_FORBIDDEN));
    }

    @Override
    public ForbiddenException get() {
        return new ForbiddenException();
    }

    @Override
    public String getName() {
        return RestResultStatus.AUTH_FORBIDDEN.getName();
    }
}
