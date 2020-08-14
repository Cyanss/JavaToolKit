package cyan.toolkit.cloud;


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
public class CloudException extends RestException {
    public CloudException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public CloudException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public CloudException(String message) {
        super(message,RestErrorStatus.UNKNOWN_ERROR);
    }

    public CloudException(Integer status) {
        super(status,RestErrorStatus.UNKNOWN_ERROR);
    }

    public CloudException(RestStatus status) {
        super(status);
    }

    public CloudException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public CloudException(String message, RestStatus status) {
        super(message, status);
    }

    public CloudException get() {
        return new CloudException();
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("rice exception");
    }
}
