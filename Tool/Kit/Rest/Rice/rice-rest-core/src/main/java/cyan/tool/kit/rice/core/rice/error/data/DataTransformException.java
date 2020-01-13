package cyan.tool.kit.rice.core.rice.error.data;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

/**
 * <p>DataTransformException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:17 2019/12/24
 */
public class DataTransformException extends RestErrorException {
    public DataTransformException() {
        super(RestErrorStatus.DATA_TRANSFORM_FAILED);
    }

    public DataTransformException(String resource) {
        super(RestErrorStatus.DATA_TRANSFORM_FAILED, RestError.error(resource, RestErrorStatus.DATA_TRANSFORM_FAILED));
    }

    public DataTransformException(String resource, String message) {
        super(RestErrorStatus.DATA_TRANSFORM_FAILED, RestError.error(resource, RestErrorStatus.DATA_TRANSFORM_FAILED, message));
    }

    public DataTransformException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_TRANSFORM_FAILED, RestError.error(resource, value, RestErrorStatus.DATA_TRANSFORM_FAILED, message));
    }

    @Override
    public DataTransformException get() {
        return new DataTransformException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.DATA_TRANSFORM_FAILED.getName();
    }
}