package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.error.natives.IdentityErrorException;
import cyan.toolkit.rest.RestErrorStatus;

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
