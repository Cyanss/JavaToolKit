package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;

/**
 * <p>StreamErrorException</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:42 2019/12/26
 */
public class StreamErrorException  extends RestErrorException {

    public StreamErrorException() {
        super(RestErrorStatus.STREAM_ERROR);
    }

    public StreamErrorException(RestErrorStatus status) {
        super(status);
    }

    public StreamErrorException(String error) {
        super(RestErrorStatus.STREAM_ERROR, RestError.error(RestErrorStatus.STREAM_ERROR, error));
    }

    public StreamErrorException(RestStatus status) {
        super(RestErrorStatus.STREAM_ERROR, RestError.error(status));
    }

    public StreamErrorException(RestStatus status, RestError error) {
        super(status, error);
    }

    public StreamErrorException(RestStatus status, String error) {
        super(RestErrorStatus.STREAM_ERROR, RestError.error(status, error));
    }

    public StreamErrorException(String resource, String error) {
        super(RestErrorStatus.STREAM_ERROR, RestError.error( resource, RestErrorStatus.STREAM_ERROR, error));
    }

    public StreamErrorException(String resource, RestStatus status) {
        super(RestErrorStatus.STREAM_ERROR, RestError.error(resource, status));
    }

    public StreamErrorException(String service, RestStatus status, String error) {
        super(RestErrorStatus.STREAM_ERROR, RestError.error( service, status, error));
    }

    public StreamErrorException(String resource, String service, RestStatus status) {
        super(RestErrorStatus.STREAM_ERROR, RestError.error(resource, service, status));
    }

    public StreamErrorException(String resource, String service, String error) {
        super(RestErrorStatus.STREAM_ERROR, RestError.error(resource, service, RestErrorStatus.STREAM_ERROR, error));
    }

    public StreamErrorException(String resource, String service, RestStatus status, String error) {
        super(RestErrorStatus.STREAM_ERROR, RestError.error(resource, service, status, error));
    }

    @Override
    public StreamErrorException get() {
        return new StreamErrorException();
    }

    @Override
    public String name() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.STREAM_ERROR).name();
    }
}

