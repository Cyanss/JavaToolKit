package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;

/**
 * <p>ParseError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:03 2019/12/17
 */
public class ParseErrorException extends RestErrorException {

    public ParseErrorException(Integer status) {
        super(RestError.error(status,RestResultStatus.PARSE_ERROR));
    }
    public ParseErrorException(String error) {
        super(RestError.error(RestResultStatus.PARSE_ERROR,error));
    }

    public ParseErrorException(RestResultStatus status) {
        super(status);
    }

    public ParseErrorException(RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(status));
    }

    public ParseErrorException(String filed, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(filed, error));
    }

    public ParseErrorException(String filed, Object value, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(filed, value, error));
    }

    public ParseErrorException(String filed, RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(filed, status));
    }

    public ParseErrorException(String filed, Object value, RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(filed, value, status));
    }

    public ParseErrorException(String resource, String field, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource,field,error));
    }

    public ParseErrorException(String resource, String field, RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource,field,status));
    }

    public ParseErrorException(String resource, String field, Object value, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource,field, value,RestResultStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(String resource, String field, Object value, RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource,field, value, status));
    }
}
