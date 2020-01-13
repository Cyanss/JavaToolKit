package cyan.tool.kit.rice.core.rice.error.natives;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>ParseError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:03 2019/12/17
 */
public class ParseErrorException extends RestErrorException {

    public ParseErrorException() {
        super(RestErrorStatus.PARSE_ERROR);
    }

    public ParseErrorException(RestErrorStatus status) {
        super(status);
    }

    public ParseErrorException(String error) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(RestErrorStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(RestStatus status) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(status));
    }

    public ParseErrorException(RestStatus status, String error) {
        super(RestErrorStatus.PARSE_ERROR,RestError.error(status, error));
    }

    public ParseErrorException(String property, String error) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(property, RestErrorStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(String property, Object parser, String error) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(property, parser, RestErrorStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(String property, RestStatus status) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(property, status));
    }

    public ParseErrorException(String property, RestStatus status, String error) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(property, status, error));
    }

    public ParseErrorException(String property, Object parser, RestStatus status) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(property, parser, status));
    }

    public ParseErrorException(String property, Object parser, RestStatus status, String error) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(property, parser, status, error));
    }

    public ParseErrorException(String resource, String field, String error) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(resource, field, RestErrorStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(String resource, String field, RestStatus status) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(resource, field, status));
    }

    public ParseErrorException(String resource, String field, RestStatus status, String error) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(resource, field, status, error));
    }

    public ParseErrorException(String resource, String field, Object parser, String error) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(resource, field, parser, RestErrorStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(String resource, String field, Object parser, RestStatus status) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(resource, field, parser, status));
    }

    public ParseErrorException(String resource, String field, Object parser, RestStatus status, String error) {
        super(RestErrorStatus.PARSE_ERROR, RestError.error(resource, field, parser, status, error));
    }

    @Override
    public ParseErrorException get() {
        return new ParseErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.PARSE_ERROR).getName();
    }
}
