package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>IdNullException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:10 2019/12/24
 */
public class FieldNullException extends RestErrorException {

    public FieldNullException() {
        super(RestErrorStatus.FIELD_IS_NULL, RestError.error("Field", RestErrorStatus.FIELD_IS_NULL));
    }

    public FieldNullException(String message) {
        super(RestErrorStatus.FIELD_IS_NULL, RestError.error("Field", RestErrorStatus.FIELD_IS_NULL,message));
    }

    public FieldNullException(String field, String message) {
        super(RestErrorStatus.FIELD_IS_NULL, RestError.error(field, RestErrorStatus.FIELD_IS_NULL,message));
    }

    @Override
    public FieldNullException get() {
        return new FieldNullException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.FIELD_IS_NULL.getName();
    }
}
