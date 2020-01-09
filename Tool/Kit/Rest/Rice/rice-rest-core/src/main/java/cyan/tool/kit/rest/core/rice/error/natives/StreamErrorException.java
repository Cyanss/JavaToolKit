package cyan.tool.kit.rest.core.rice.error.natives;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;
import cyan.tool.kit.rest.core.rice.rest.RestStatus;

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
        super(RestResultStatus.STREAM_ERROR);
    }

    public StreamErrorException(RestResultStatus status) {
        super(status);
    }

    public StreamErrorException(String error) {
        super(RestResultStatus.STREAM_ERROR, RestError.error(RestResultStatus.STREAM_ERROR, error));
    }

    public StreamErrorException(RestStatus status) {
        super(RestResultStatus.STREAM_ERROR, RestError.error(status));
    }

    public StreamErrorException(RestStatus status, String error) {
        super(RestResultStatus.STREAM_ERROR, RestError.error(status, error));
    }

    public StreamErrorException(String resource, String error) {
        super(RestResultStatus.STREAM_ERROR, RestError.error( resource, RestResultStatus.STREAM_ERROR, error));
    }

    public StreamErrorException(String resource, RestStatus status) {
        super(RestResultStatus.STREAM_ERROR, RestError.error(resource, status));
    }

    public StreamErrorException(String service, RestStatus status, String error) {
        super(RestResultStatus.STREAM_ERROR, RestError.error( service, status, error));
    }

    public StreamErrorException(String resource, String service, RestStatus status) {
        super(RestResultStatus.STREAM_ERROR, RestError.error(resource, service, status));
    }

    public StreamErrorException(String resource, String service, String error) {
        super(RestResultStatus.STREAM_ERROR, RestError.error(resource, service, RestResultStatus.STREAM_ERROR, error));
    }

    public StreamErrorException(String resource, String service, RestStatus status, String error) {
        super(RestResultStatus.STREAM_ERROR, RestError.error(resource, service, status, error));
    }

    @Override
    public StreamErrorException get() {
        return new StreamErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.STREAM_ERROR).getName();
    }
}

