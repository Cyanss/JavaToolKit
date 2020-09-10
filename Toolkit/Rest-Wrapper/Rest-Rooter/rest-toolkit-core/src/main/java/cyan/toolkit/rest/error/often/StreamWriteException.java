package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

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
        super(RestErrorStatus.STREAM_WRITE_ERROR);
    }

    public StreamWriteException(String message) {
        super(RestErrorStatus.STREAM_WRITE_ERROR, RestError.error(RestErrorStatus.STREAM_WRITE_ERROR, message));
    }

    public StreamWriteException(String resource, String message) {
        super(RestErrorStatus.STREAM_WRITE_ERROR, RestError.error(resource, RestErrorStatus.STREAM_WRITE_ERROR, message));
    }

    @Override
    public StreamWriteException get() {
        return new StreamWriteException();
    }

    @Override
    public String name() {
        return RestErrorStatus.STREAM_WRITE_ERROR.name();
    }
}
