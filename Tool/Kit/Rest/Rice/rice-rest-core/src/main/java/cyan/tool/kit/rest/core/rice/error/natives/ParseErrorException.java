package cyan.tool.kit.rest.core.rice.error.natives;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;
import cyan.tool.kit.rest.core.rice.rest.RestStatus;

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
        super(RestResultStatus.PARSE_ERROR);
    }

    public ParseErrorException(RestResultStatus status) {
        super(status);
    }

    public ParseErrorException(String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(RestResultStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(status));
    }

    public ParseErrorException(RestStatus status, String error) {
        super(RestResultStatus.PARSE_ERROR,RestError.error(status, error));
    }

    public ParseErrorException(String property, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(property, RestResultStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(String property, Object parser, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(property, parser, RestResultStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(String property, RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(property, status));
    }

    public ParseErrorException(String property, RestStatus status, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(property, status, error));
    }

    public ParseErrorException(String property, Object parser, RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(property, parser, status));
    }

    public ParseErrorException(String property, Object parser, RestStatus status, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(property, parser, status, error));
    }

    public ParseErrorException(String resource, String field, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource, field, RestResultStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(String resource, String field, RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource, field, status));
    }

    public ParseErrorException(String resource, String field, RestStatus status, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource, field, status, error));
    }

    public ParseErrorException(String resource, String field, Object parser, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource, field, parser, RestResultStatus.PARSE_ERROR, error));
    }

    public ParseErrorException(String resource, String field, Object parser, RestStatus status) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource, field, parser, status));
    }

    public ParseErrorException(String resource, String field, Object parser, RestStatus status, String error) {
        super(RestResultStatus.PARSE_ERROR, RestError.error(resource, field, parser, status, error));
    }

    @Override
    public ParseErrorException get() {
        return new ParseErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.PARSE_ERROR).getName();
    }
}
