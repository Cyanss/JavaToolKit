package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.error.natives.IdentityErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>IdRepeatException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:07 2019/12/24
 */
public class IdentityRepeatException extends IdentityErrorException {

    public IdentityRepeatException() {
        super("Id",RestErrorStatus.IDENTITY_REPEATED);
    }

    public IdentityRepeatException(String message) {
        super("Id",RestErrorStatus.IDENTITY_REPEATED, message);
    }

    public IdentityRepeatException(String field, Object value, String message) {
        super(field,value,RestErrorStatus.IDENTITY_REPEATED, message);
    }

    public IdentityRepeatException(Object value) {
        super("Id", value, RestErrorStatus.IDENTITY_REPEATED);
    }

    @Override
    public IdentityRepeatException get() {
        return new IdentityRepeatException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.IDENTITY_REPEATED.getName();
    }
}
