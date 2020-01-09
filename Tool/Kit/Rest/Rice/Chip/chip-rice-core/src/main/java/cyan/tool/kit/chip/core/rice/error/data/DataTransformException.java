package cyan.tool.kit.chip.core.rice.error.data;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>DataTransformException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:17 2019/12/24
 */
public class DataTransformException extends RestErrorException {
    public DataTransformException() {
        super(RestResultStatus.DATA_TRANSFORM_FAILED);
    }

    public DataTransformException(String resource) {
        super(RestResultStatus.DATA_TRANSFORM_FAILED, RestError.error(resource, RestResultStatus.DATA_TRANSFORM_FAILED));
    }

    public DataTransformException(String resource, String message) {
        super(RestResultStatus.DATA_TRANSFORM_FAILED, RestError.error(resource, RestResultStatus.DATA_TRANSFORM_FAILED, message));
    }

    public DataTransformException(String resource, Object value, String message) {
        super(RestResultStatus.DATA_TRANSFORM_FAILED, RestError.error(resource, value, RestResultStatus.DATA_TRANSFORM_FAILED, message));
    }

    @Override
    public DataTransformException get() {
        return new DataTransformException();
    }

    @Override
    public String getName() {
        return RestResultStatus.DATA_TRANSFORM_FAILED.getName();
    }
}