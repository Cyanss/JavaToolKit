package cyan.toolkit.image;


import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>RiceException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
 */
public class ImageException extends RestException {
    public ImageException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public ImageException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public ImageException(String message) {
        super(message,RestErrorStatus.UNKNOWN_ERROR);
    }

    public ImageException(Integer status) {
        super(status,RestErrorStatus.UNKNOWN_ERROR);
    }

    public ImageException(RestStatus status) {
        super(status);
    }

    public ImageException(Integer status, String message) {
        super(status, message);
    }

    public ImageException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public ImageException(String message, RestStatus status) {
        super(message, status);
    }

    public ImageException get() {
        return new ImageException();
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("chief exception");
    }
}
