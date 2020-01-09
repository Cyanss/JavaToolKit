package cyan.tool.kit.rice.core.rice.error.often;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestResultStatus;

/**
 * <p>NameNullException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:13 2019/12/24
 */
public class NameNullException extends RestErrorException {
    public NameNullException() {
        super(RestResultStatus.NAME_IS_NULL, RestError.error("Name",RestResultStatus.NAME_IS_NULL));
    }

    public NameNullException(String message) {
        super(RestResultStatus.NAME_IS_NULL, RestError.error("Name",RestResultStatus.NAME_IS_NULL,message));
    }

    public NameNullException(String field, String message) {
        super(RestResultStatus.NAME_IS_NULL, RestError.error(field, RestResultStatus.NAME_IS_NULL,message));
    }

    @Override
    public NameNullException get() {
        return new NameNullException();
    }

    @Override
    public String getName() {
        return RestResultStatus.NAME_IS_NULL.getName();
    }
}
