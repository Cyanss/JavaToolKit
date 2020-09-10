package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;

/**
 * <p>ConfigureErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:13 2020/8/18
 */
public class ConfigErrorException extends RestErrorException {

    public ConfigErrorException() {
        super(RestErrorStatus.CONFIG_ERROR);
    }

    public ConfigErrorException(RestErrorStatus status) {
        super(status);
    }

    public ConfigErrorException(String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(RestErrorStatus.CONFIG_ERROR, error));
    }

    public ConfigErrorException(RestStatus status) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(status));
    }

    public ConfigErrorException(RestStatus status, String error) {
        super(RestErrorStatus.CONFIG_ERROR,RestError.error(status, error));
    }

    public ConfigErrorException(String user, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, user, null, RestErrorStatus.CONFIG_ERROR, error));
    }

    public ConfigErrorException(String user, Object auth) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, user, auth, RestErrorStatus.CONFIG_ERROR));
    }

    public ConfigErrorException(String user, Object auth, RestStatus status) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, user, auth, status));
    }

    public ConfigErrorException(String user, Object auth, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, user, auth, RestErrorStatus.CONFIG_ERROR, error));
    }

    public ConfigErrorException(String user, Object auth, RestStatus status, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, user, auth, status, error));
    }

    public ConfigErrorException(String resource, String user, Object auth) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(resource, user, auth, RestErrorStatus.CONFIG_ERROR));
    }

    public ConfigErrorException(String resource, String user, Object auth, RestStatus status) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(resource, user, auth, status));
    }

    public ConfigErrorException(String resource, String user, Object auth, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(resource, user, auth, RestErrorStatus.CONFIG_ERROR, error));
    }

    public ConfigErrorException(String resource, String user, Object auth, RestStatus status, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(resource, user, auth, status, error));
    }

    @Override
    public ConfigErrorException get() {
        return new ConfigErrorException();
    }

    @Override
    public String name() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.CONFIG_ERROR).name();
    }
}
