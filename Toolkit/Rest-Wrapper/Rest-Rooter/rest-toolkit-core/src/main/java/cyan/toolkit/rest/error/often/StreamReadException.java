package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

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
        super(RestErrorStatus.STREAM_READ_ERROR);
    }

    public StreamReadException(String message) {
        super(RestErrorStatus.STREAM_READ_ERROR, RestError.error(RestErrorStatus.STREAM_READ_ERROR, message));
    }

    public StreamReadException(String resource, String message) {
        super(RestErrorStatus.STREAM_READ_ERROR, RestError.error(resource, RestErrorStatus.STREAM_READ_ERROR, message));
    }

    @Override
    public StreamReadException get() {
        return new StreamReadException();
    }

    @Override
    public String name() {
        return RestErrorStatus.STREAM_READ_ERROR.name();
    }
}
