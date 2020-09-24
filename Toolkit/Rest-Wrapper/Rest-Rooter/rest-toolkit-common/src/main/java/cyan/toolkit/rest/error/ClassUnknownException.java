package cyan.toolkit.rest.error;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.error.natives.ConvertErrorException;

import java.util.Optional;

/**
 * <p>ClassUnknowException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:16 2020/9/24
 */
public class ClassUnknownException extends ConvertErrorException {
    public ClassUnknownException() {
        super(RestErrorStatus.CONVERT_TYPE_UNKNOWN);
    }

    public ClassUnknownException(String message) {
        super(RestErrorStatus.CONVERT_TYPE_UNKNOWN,message);
    }

    public ClassUnknownException(String resource, Object value) {
        super(RestErrorStatus.CONVERT_TYPE_UNKNOWN, resource, value);
    }

    public ClassUnknownException(String resource, String message) {
        super(RestErrorStatus.CONVERT_TYPE_UNKNOWN, resource, message);
    }

    public ClassUnknownException(String resource, Object value, String message) {
        super(RestErrorStatus.CONVERT_TYPE_UNKNOWN, resource, value, message);
    }

    public ClassUnknownException get() {
        return new ClassUnknownException();
    }

    public String name() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("class type Invalid exception");
    }
}
