package cyan.tool.kit.chip.starter.error;

import cyan.tool.kit.chip.core.error.RiceException;
import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>EncodingException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:24 2020/1/17
 */
public class CodingException extends RiceException {
    public CodingException() {
        super(CodingErrorStatus.ENCODING_ERROR);
    }

    public CodingException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public CodingException(String message) {
        super(message, CodingErrorStatus.ENCODING_ERROR);
    }

    public CodingException(Integer status) {
        super(status, CodingErrorStatus.ENCODING_ERROR);
    }

    public CodingException(RestStatus status) {
        super(status);
    }

    public CodingException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public CodingException(String message, RestStatus status) {
        super(message, status);
    }

    public CodingException get() {
        return new CodingException();
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("encoding exception");
    }
}
