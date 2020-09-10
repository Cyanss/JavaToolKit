package cyan.toolkit.rest.error.supply;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>ResourceNotFoundException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:19 2019/12/24
 */
public class ResourceNotFoundException extends RestErrorException {
    public ResourceNotFoundException() {
        super(RestErrorStatus.RESOURCE_NOT_FOUND);
    }

    public ResourceNotFoundException(String resource) {
        super(RestErrorStatus.RESOURCE_NOT_FOUND, RestError.error(resource, RestErrorStatus.RESOURCE_NOT_FOUND));
    }

    @Override
    public ResourceNotFoundException get() {
        return new ResourceNotFoundException();
    }

    @Override
    public String name() {
        return RestErrorStatus.RESOURCE_NOT_FOUND.name();
    }
}