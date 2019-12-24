package cyan.tool.kit.chip.core.rice.error.often;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>IdNullException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:10 2019/12/24
 */
public class IdNullException extends RestErrorException {
    public IdNullException() {
        super(RestResultStatus.ID_IS_NULL);
    }

    public IdNullException(Object value) {
        super(RestResultStatus.ID_IS_NULL, RestError.error("Id",value,RestResultStatus.ID_IS_NULL));
    }

    public IdNullException(String message) {
        super(RestResultStatus.ID_IS_NULL, RestError.error("Id",RestResultStatus.ID_IS_NULL,message));
    }

    public IdNullException(String field, Object value,String message) {
        super(RestResultStatus.ID_IS_NULL, RestError.error(field,value,RestResultStatus.ID_IS_NULL,message));
    }

    @Override
    public IdNullException get() {
        return new IdNullException();
    }

    @Override
    public String getName() {
        return RestResultStatus.ID_IS_NULL.getName();
    }
}
