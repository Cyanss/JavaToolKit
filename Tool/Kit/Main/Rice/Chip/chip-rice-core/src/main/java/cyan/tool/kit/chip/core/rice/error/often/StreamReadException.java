package cyan.tool.kit.chip.core.rice.error.often;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>StreamReadException</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:44 2019/12/26
 */
public class StreamReadException extends RestErrorException {
    public StreamReadException() {
        super(RestResultStatus.STREAM_READ_ERROR);
    }

    public StreamReadException(String message) {
        super(RestResultStatus.STREAM_READ_ERROR, RestError.error(RestResultStatus.STREAM_READ_ERROR, message));
    }

    public StreamReadException(String resource, String message) {
        super(RestResultStatus.STREAM_READ_ERROR, RestError.error(resource, RestResultStatus.STREAM_READ_ERROR, message));
    }

    @Override
    public StreamReadException get() {
        return new StreamReadException();
    }

    @Override
    public String getName() {
        return RestResultStatus.STREAM_READ_ERROR.getName();
    }
}
