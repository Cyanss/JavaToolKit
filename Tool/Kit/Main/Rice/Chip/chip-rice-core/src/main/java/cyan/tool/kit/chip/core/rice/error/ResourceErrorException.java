package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>ResourceErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:44 2019/12/19
 */
public class ResourceErrorException extends RestErrorException {

    public ResourceErrorException() {
        super(RestResultStatus.RESOURCE_ERROR,RestError.error(RestResultStatus.RESOURCE_ERROR));
    }

    public ResourceErrorException(RestResultStatus status) {
        super(status);
    }

    public ResourceErrorException(String error) {
        super(RestResultStatus.RESOURCE_ERROR, RestError.error(RestResultStatus.RESOURCE_ERROR,error));
    }

    public ResourceErrorException(RestStatus status, String error) {
        super(RestResultStatus.RESOURCE_ERROR,RestError.error(status, error));
    }

    public ResourceErrorException(RestStatus status) {
        super(RestResultStatus.RESOURCE_ERROR, RestError.error(status));
    }

    public ResourceErrorException(String resource, String error) {
        super(RestResultStatus.RESOURCE_ERROR, RestError.error(resource, RestResultStatus.RESOURCE_ERROR, error));
    }

    public ResourceErrorException(String resource, RestStatus status) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(resource, status));
    }

    public ResourceErrorException(String resource, RestStatus status, String error) {
        super(RestResultStatus.PARAM_ERROR, RestError.error(resource, status, error));
    }

    @Override
    public ResourceErrorException get() {
        return new ResourceErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.PARAM_ERROR).getName();
    }

}
