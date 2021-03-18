package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

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
        super(RestErrorStatus.RESOURCE_ERROR);
    }

    public ResourceErrorException(RestErrorStatus status) {
        super(status);
    }

    public ResourceErrorException(String error) {
        super(RestErrorStatus.RESOURCE_ERROR, RestError.error(RestErrorStatus.RESOURCE_ERROR,error));
    }

    public ResourceErrorException(RestStatus status, RestError error) {
        super(status, error);
    }

    public ResourceErrorException(RestStatus status, String error) {
        super(RestErrorStatus.RESOURCE_ERROR,RestError.error(status, error));
    }

    public ResourceErrorException(RestStatus status) {
        super(RestErrorStatus.RESOURCE_ERROR, RestError.error(status));
    }

    public ResourceErrorException(String resource, String error) {
        super(RestErrorStatus.RESOURCE_ERROR, RestError.error(resource, RestErrorStatus.RESOURCE_ERROR, error));
    }

    public ResourceErrorException(String resource, RestStatus status) {
        super(RestErrorStatus.PARAM_ERROR, RestError.error(resource, status));
    }

    public ResourceErrorException(String resource, RestStatus status, String error) {
        super(RestErrorStatus.PARAM_ERROR, RestError.error(resource, status, error));
    }

    @Override
    public ResourceErrorException get() {
        return new ResourceErrorException();
    }

}
