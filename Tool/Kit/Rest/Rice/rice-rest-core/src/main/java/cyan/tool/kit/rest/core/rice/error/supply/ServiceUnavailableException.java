package cyan.tool.kit.rest.core.rice.error.supply;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;

/**
 * <p>ServiceUnavailableException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:41 2019/12/20
 */
public class ServiceUnavailableException extends RestErrorException {
    public ServiceUnavailableException() {
        super(RestResultStatus.SERVICE_UNAVAILABLE);
    }

    public ServiceUnavailableException(String service) {
        super(RestResultStatus.SERVICE_UNAVAILABLE, RestError.error(service, RestResultStatus.SERVICE_UNAVAILABLE));
    }

    public ServiceUnavailableException(String resource, String service, String error) {
        super(RestResultStatus.SERVICE_UNAVAILABLE, RestError.error(resource, service, null, RestResultStatus.SERVICE_UNAVAILABLE, error));
    }

    @Override
    public ServiceUnavailableException get() {
        return new ServiceUnavailableException();
    }

    @Override
    public String getName() {
        return RestResultStatus.SERVICE_UNAVAILABLE.getName();
    }
}
