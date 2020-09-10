package cyan.toolkit.brief;


import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>BriefException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
 */
public class BriefException extends RestException {
    public BriefException() {
        super(RestErrorStatus.UNKNOWN_ERROR);
    }

    public BriefException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public BriefException(String message) {
        super(message,RestErrorStatus.UNKNOWN_ERROR);
    }

    public BriefException(Integer status) {
        super(status,RestErrorStatus.UNKNOWN_ERROR);
    }

    public BriefException(RestStatus status) {
        super(status);
    }

    public BriefException(Integer status, String message) {
        super(status, message);
    }

    public BriefException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public BriefException(String message, RestStatus status) {
        super(message, status);
    }

    public BriefException get() {
        return new BriefException();
    }

    public String name() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("brief exception");
    }
}
