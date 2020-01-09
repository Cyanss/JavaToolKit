package cyan.tool.kit.chip.core.error;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestException;
import cyan.tool.kit.rice.core.rice.rest.RestResultStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>RiceException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
 */
public class RiceException extends RestException {

    public RiceException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public RiceException(String message) {
        super(message,RestResultStatus.UNKNOWN_ERROR);
    }

    public RiceException(Integer status) {
        super(status,RestResultStatus.UNKNOWN_ERROR);
    }

    public RiceException(RestStatus status) {
        super(status);
    }

    public RiceException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public RiceException(String message, RestStatus status) {
        super(message, status);
    }

    public RiceException get() {
        return new RiceException(RestResultStatus.UNKNOWN_ERROR);
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("rice exception");
    }
}
