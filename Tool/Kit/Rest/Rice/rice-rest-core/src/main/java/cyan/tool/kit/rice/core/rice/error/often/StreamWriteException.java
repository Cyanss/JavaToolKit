package cyan.tool.kit.rice.core.rice.error.often;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestResultStatus;

/**
 * <p>StreamWriteException</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:45 2019/12/26
 */
public class StreamWriteException extends RestErrorException {
    public StreamWriteException() {
        super(RestResultStatus.STREAM_WRITE_ERROR);
    }

    public StreamWriteException(String message) {
        super(RestResultStatus.STREAM_WRITE_ERROR, RestError.error(RestResultStatus.STREAM_WRITE_ERROR, message));
    }

    public StreamWriteException(String resource, String message) {
        super(RestResultStatus.STREAM_WRITE_ERROR, RestError.error(resource, RestResultStatus.STREAM_WRITE_ERROR, message));
    }

    @Override
    public StreamWriteException get() {
        return new StreamWriteException();
    }

    @Override
    public String getName() {
        return RestResultStatus.STREAM_WRITE_ERROR.getName();
    }
}
