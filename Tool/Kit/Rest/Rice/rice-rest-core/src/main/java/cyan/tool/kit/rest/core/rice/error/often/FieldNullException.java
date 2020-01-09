package cyan.tool.kit.rest.core.rice.error.often;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;

/**
 * <p>IdNullException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:10 2019/12/24
 */
public class FieldNullException extends RestErrorException {

    public FieldNullException() {
        super(RestResultStatus.FIELD_IS_NULL, RestError.error("Field",RestResultStatus.FIELD_IS_NULL));
    }

    public FieldNullException(String message) {
        super(RestResultStatus.FIELD_IS_NULL, RestError.error("Field",RestResultStatus.FIELD_IS_NULL,message));
    }

    public FieldNullException(String field, String message) {
        super(RestResultStatus.FIELD_IS_NULL, RestError.error(field,RestResultStatus.FIELD_IS_NULL,message));
    }

    @Override
    public FieldNullException get() {
        return new FieldNullException();
    }

    @Override
    public String getName() {
        return RestResultStatus.FIELD_IS_NULL.getName();
    }
}
