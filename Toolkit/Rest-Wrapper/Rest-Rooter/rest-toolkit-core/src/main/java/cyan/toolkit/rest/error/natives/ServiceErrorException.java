package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;

/**
 * <p>ServiceErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:21 2019/12/19
 */
public class ServiceErrorException extends RestErrorException {
    
    public ServiceErrorException() {
        super(RestErrorStatus.SERVICE_ERROR);
    }

    public ServiceErrorException(RestErrorStatus status) {
        super(status);
    }

    public ServiceErrorException(String error) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error(RestErrorStatus.SERVICE_ERROR, error));
    }

    public ServiceErrorException(RestStatus status) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error(status));
    }

    public ServiceErrorException(RestStatus status, RestError error) {
        super(status, error);
    }

    public ServiceErrorException(RestStatus status, String error) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error(status, error));
    }

    public ServiceErrorException(String service, String error) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error( service, RestErrorStatus.SERVICE_ERROR, error));
    }
    
    public ServiceErrorException(String service, RestStatus status) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error(service, status));
    }

    public ServiceErrorException(String service, RestStatus status, String error) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error( service, status, error));
    }

    public ServiceErrorException(String resource, String service, RestStatus status) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error(resource, service, status));
    }

    public ServiceErrorException(String resource, String service, String error) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error(resource, service, RestErrorStatus.SERVICE_ERROR, error));
    }

    public ServiceErrorException(String resource, String service, RestStatus status, String error) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error(resource, service, status, error));
    }

    public ServiceErrorException(String resource, String service, RestStatus status, String error,Throwable cause) {
        super(RestErrorStatus.SERVICE_ERROR, RestError.error(resource, service, status, error, cause));
    }

    @Override
    public ServiceErrorException get() {
        return new ServiceErrorException();
    }
}
