package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

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
        super(RestResultStatus.SERVICE_ERROR, RestError.error(RestResultStatus.SERVICE_ERROR));
    }

    public ServiceErrorException(RestResultStatus status) {
        super(status);
    }

    public ServiceErrorException(String error) {
        super(RestResultStatus.SERVICE_ERROR, RestError.error(RestResultStatus.SERVICE_ERROR, error));
    }

    public ServiceErrorException(RestStatus status) {
        super(RestResultStatus.SERVICE_ERROR, RestError.error(status));
    }

    public ServiceErrorException(String service, String error) {
        super(RestResultStatus.SERVICE_ERROR, RestError.error( service, RestResultStatus.SERVICE_ERROR, error));
    }
    
    public ServiceErrorException(String service, RestStatus status) {
        super(RestResultStatus.SERVICE_ERROR, RestError.error(service, status));
    }

    public ServiceErrorException(String service, RestStatus status, String error) {
        super(RestResultStatus.SERVICE_ERROR, RestError.error( service, status, error));
    }

    public ServiceErrorException(String resource, String service, RestStatus status) {
        super(RestResultStatus.SERVICE_ERROR, RestError.error(resource, service, status));
    }

    public ServiceErrorException(String resource, String service, String error) {
        super(RestResultStatus.SERVICE_ERROR, RestError.error(resource, service, RestResultStatus.SERVICE_ERROR, error));
    }

    public ServiceErrorException(String resource, String service, RestStatus status, String error) {
        super(RestResultStatus.SERVICE_ERROR, RestError.error(resource, service, status, error));
    }

    @Override
    public ServiceErrorException get() {
        return new ServiceErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.SERVICE_ERROR).getName();
    }
}
