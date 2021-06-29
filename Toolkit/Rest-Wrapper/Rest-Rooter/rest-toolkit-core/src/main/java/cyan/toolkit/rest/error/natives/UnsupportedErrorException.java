package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

/**
 * <p>UnsupportedErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:22 2021/6/28
 */
public class UnsupportedErrorException extends RestErrorException {

    public UnsupportedErrorException() {
        super(RestErrorStatus.UNSUPPORTED);
    }

    public UnsupportedErrorException(RestErrorStatus status) {
        super(status);
    }

    public UnsupportedErrorException(String error) {
        super(RestErrorStatus.UNSUPPORTED, RestError.error(RestErrorStatus.UNSUPPORTED, error));
    }

    public UnsupportedErrorException(RestStatus status) {
        super(RestErrorStatus.UNSUPPORTED, RestError.error(status));
    }

    public UnsupportedErrorException(RestStatus status, RestError error) {
        super(status, error);
    }

    public UnsupportedErrorException(RestStatus status, String error) {
        super(RestErrorStatus.UNSUPPORTED, RestError.error(status, error));
    }

    public UnsupportedErrorException(String target, String error) {
        super(RestErrorStatus.UNSUPPORTED, RestError.error(target, RestErrorStatus.UNSUPPORTED, error));
    }

    public UnsupportedErrorException(String target, RestStatus status) {
        super(RestErrorStatus.UNSUPPORTED, RestError.error(target, status));
    }

    @Override
    public UnsupportedErrorException get() {
        return new UnsupportedErrorException();
    }
}
