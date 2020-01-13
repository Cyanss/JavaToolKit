package cyan.tool.kit.rice.core.rice.error.often;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.error.natives.IdentityErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

/**
 * <p>IdNullException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:10 2019/12/24
 */
public class IdentityNullException extends IdentityErrorException {
    public IdentityNullException() {
        super("Id",RestErrorStatus.IDENTITY_IS_NULL);
    }

    public IdentityNullException(String message) {
        super("Id",RestErrorStatus.IDENTITY_IS_NULL,message);
    }

    public IdentityNullException(String field, String message) {
        super(field,RestErrorStatus.IDENTITY_IS_NULL, message);
    }

    @Override
    public IdentityNullException get() {
        return new IdentityNullException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.IDENTITY_IS_NULL.getName();
    }
}
