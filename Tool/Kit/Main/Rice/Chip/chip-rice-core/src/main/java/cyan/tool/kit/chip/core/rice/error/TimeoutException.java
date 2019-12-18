package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

/**
 * <p>TimeoutException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:34 2019/12/17
 */
public class TimeoutException extends RestErrorException {

    public TimeoutException(Integer status, String message) {
        super(RestResultStatus.TIME_OUT, RestError.timeout(status,message));
    }

    public TimeoutException(String resource) {
        super(RestResultStatus.TIME_OUT, RestError.timeout(resource));
    }

    public TimeoutException(RestStatus status) {
        super(RestResultStatus.TIME_OUT, RestError.timeout(status));
    }

    public TimeoutException(String resource, RestStatus status) {
        super(RestResultStatus.TIME_OUT, RestError.timeout(resource, status));
    }


}
