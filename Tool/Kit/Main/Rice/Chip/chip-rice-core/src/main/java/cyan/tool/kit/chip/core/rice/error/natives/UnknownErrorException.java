package cyan.tool.kit.chip.core.rice.error.natives;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>UnknownErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:36 2019/12/19
 */
public class UnknownErrorException extends RestErrorException {

    public UnknownErrorException() {
        super(RestResultStatus.UNKNOWN_ERROR);
    }

    public UnknownErrorException(RestResultStatus status) {
        super(status);
    }

    public UnknownErrorException(String error) {
        super(RestResultStatus.UNKNOWN_ERROR, RestError.error(RestResultStatus.UNKNOWN_ERROR, error));
    }

    public UnknownErrorException(RestStatus status) {
        super(RestResultStatus.UNKNOWN_ERROR, RestError.error(status));
    }

    public UnknownErrorException(RestStatus status, String error) {
        super(RestResultStatus.UNKNOWN_ERROR, RestError.error(status, error));
    }

    public UnknownErrorException(String target, String error) {
        super(RestResultStatus.UNKNOWN_ERROR, RestError.error(target, RestResultStatus.UNKNOWN_ERROR, error));
    }

    public UnknownErrorException(String target, RestStatus status) {
        super(RestResultStatus.UNKNOWN_ERROR, RestError.error(target, status));
    }

    @Override
    public UnknownErrorException get() {
        return new UnknownErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.UNKNOWN_ERROR).getName();
    }
}
