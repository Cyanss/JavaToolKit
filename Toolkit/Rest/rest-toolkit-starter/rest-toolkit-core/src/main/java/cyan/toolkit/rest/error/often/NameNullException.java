package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>NameNullException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:13 2019/12/24
 */
public class NameNullException extends RestErrorException {
    public NameNullException() {
        super(RestErrorStatus.NAME_IS_NULL, RestError.error("Name", RestErrorStatus.NAME_IS_NULL));
    }

    public NameNullException(String message) {
        super(RestErrorStatus.NAME_IS_NULL, RestError.error("Name", RestErrorStatus.NAME_IS_NULL,message));
    }

    public NameNullException(String field, String message) {
        super(RestErrorStatus.NAME_IS_NULL, RestError.error(field, RestErrorStatus.NAME_IS_NULL,message));
    }

    @Override
    public NameNullException get() {
        return new NameNullException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.NAME_IS_NULL.getName();
    }
}
