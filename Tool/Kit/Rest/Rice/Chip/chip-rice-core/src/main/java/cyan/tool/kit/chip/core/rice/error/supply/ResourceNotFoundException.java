package cyan.tool.kit.chip.core.rice.error.supply;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>ResourceNotFoundException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:19 2019/12/24
 */
public class ResourceNotFoundException extends RestErrorException {
    public ResourceNotFoundException() {
        super(RestResultStatus.RESOURCE_NOT_FOUND);
    }

    public ResourceNotFoundException(String resource) {
        super(RestResultStatus.RESOURCE_NOT_FOUND, RestError.error(resource, RestResultStatus.RESOURCE_NOT_FOUND));
    }

    @Override
    public ResourceNotFoundException get() {
        return new ResourceNotFoundException();
    }

    @Override
    public String getName() {
        return RestResultStatus.RESOURCE_NOT_FOUND.getName();
    }
}