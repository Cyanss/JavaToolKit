package cyan.tool.kit.chip.core.rice.error.supply;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>ForbiddenException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:28 2019/12/20
 */
public class ForbiddenException extends RestErrorException {
    public ForbiddenException(String resource, String user, String auth) {
        super(RestResultStatus.AUTH_FORBIDDEN, RestError.error(resource, user, auth,RestResultStatus.AUTH_FORBIDDEN));
    }
}
