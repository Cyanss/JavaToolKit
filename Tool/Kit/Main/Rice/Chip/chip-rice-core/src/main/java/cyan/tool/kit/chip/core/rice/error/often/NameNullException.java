package cyan.tool.kit.chip.core.rice.error.often;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>NameNullException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:13 2019/12/24
 */
public class NameNullException extends RestErrorException {
    public NameNullException() {
        super(RestResultStatus.NAME_IS_NULL);
    }

    public NameNullException(Object value) {
        super(RestResultStatus.NAME_IS_NULL, RestError.error("name",value,RestResultStatus.NAME_IS_NULL));
    }

    public NameNullException(String message) {
        super(RestResultStatus.NAME_IS_NULL, RestError.error("name",RestResultStatus.NAME_IS_NULL,message));
    }

    public NameNullException(String field, Object value,String message) {
        super(RestResultStatus.NAME_IS_NULL, RestError.error(field,value,RestResultStatus.NAME_IS_NULL,message));
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
