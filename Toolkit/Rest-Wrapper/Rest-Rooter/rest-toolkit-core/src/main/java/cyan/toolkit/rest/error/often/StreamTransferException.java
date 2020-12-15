package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>StreamTransferException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:49 2020/8/18
 */
public class StreamTransferException extends RestErrorException {
    public StreamTransferException() {
        super(RestErrorStatus.STREAM_TRANSFER_ERROR);
    }

    public StreamTransferException(String message) {
        super(RestErrorStatus.STREAM_TRANSFER_ERROR, RestError.error(RestErrorStatus.STREAM_TRANSFER_ERROR, message));
    }

    public StreamTransferException(String resource, String message) {
        super(RestErrorStatus.STREAM_TRANSFER_ERROR, RestError.error(resource, RestErrorStatus.STREAM_TRANSFER_ERROR, message));
    }

    @Override
    public StreamTransferException get() {
        return new StreamTransferException();
    }
}
