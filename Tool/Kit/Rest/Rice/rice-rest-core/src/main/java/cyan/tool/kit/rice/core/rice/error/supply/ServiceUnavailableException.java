package cyan.tool.kit.rice.core.rice.error.supply;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

/**
 * <p>ServiceUnavailableException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:41 2019/12/20
 */
public class ServiceUnavailableException extends RestErrorException {
    public ServiceUnavailableException() {
        super(RestErrorStatus.SERVICE_UNAVAILABLE);
    }

    public ServiceUnavailableException(String service) {
        super(RestErrorStatus.SERVICE_UNAVAILABLE, RestError.error(service, RestErrorStatus.SERVICE_UNAVAILABLE));
    }

    public ServiceUnavailableException(String resource, String service, String error) {
        super(RestErrorStatus.SERVICE_UNAVAILABLE, RestError.error(resource, service, null, RestErrorStatus.SERVICE_UNAVAILABLE, error));
    }

    @Override
    public ServiceUnavailableException get() {
        return new ServiceUnavailableException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.SERVICE_UNAVAILABLE.getName();
    }
}
