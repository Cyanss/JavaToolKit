package cyan.toolkit.rest.error;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.error.natives.ConvertErrorException;

import java.util.Optional;

/**
 * <p>ClassUnsupportedException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:39 2020/9/24
 */
public class ClassUnsupportedException extends ConvertErrorException {
    public ClassUnsupportedException() {
        super(RestErrorStatus.CONVERT_TYPE_UNSUPPORTED);
    }

    public ClassUnsupportedException(String message) {
        super(RestErrorStatus.CONVERT_TYPE_UNSUPPORTED,message);
    }

    public ClassUnsupportedException(String resource, Object value) {
        super(RestErrorStatus.CONVERT_TYPE_UNSUPPORTED, resource, value);
    }

    public ClassUnsupportedException(String resource, String message) {
        super(RestErrorStatus.CONVERT_TYPE_UNSUPPORTED, resource, message);
    }

    public ClassUnsupportedException(String resource, Object value, String message) {
        super(RestErrorStatus.CONVERT_TYPE_UNSUPPORTED, resource, value, message);
    }

    public ClassUnsupportedException get() {
        return new ClassUnsupportedException();
    }

    public String name() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("class type Invalid exception");
    }
}
