package cyan.toolkit.rest.error.natives;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestStatus;

import java.util.Optional;

/**
 * <p>ConfigureErrorException</p>
 * @valueor Cyan (snow22314@outlook.com)
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

    public ConfigErrorException(RestStatus status, RestError error) {
        super(status, error);
    }

    public ConfigErrorException(RestStatus status, String error) {
        super(RestErrorStatus.CONFIG_ERROR,RestError.error(status, error));
    }

    public ConfigErrorException(String filed, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, filed, null, RestErrorStatus.CONFIG_ERROR, error));
    }

    public ConfigErrorException(String filed, Object value) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, filed, value, RestErrorStatus.CONFIG_ERROR));
    }

    public ConfigErrorException(String filed, Object value, RestStatus status) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, filed, value, status));
    }

    public ConfigErrorException(String filed, Object value, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, filed, value, RestErrorStatus.CONFIG_ERROR, error));
    }

    public ConfigErrorException(String filed, Object value, RestStatus status, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(null, filed, value, status, error));
    }

    public ConfigErrorException(String resource, String filed, Object value) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(resource, filed, value, RestErrorStatus.CONFIG_ERROR));
    }

    public ConfigErrorException(String resource, String filed, Object value, RestStatus status) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(resource, filed, value, status));
    }

    public ConfigErrorException(String resource, String filed, Object value, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(resource, filed, value, RestErrorStatus.CONFIG_ERROR, error));
    }

    public ConfigErrorException(String resource, String filed, Object value, RestStatus status, String error) {
        super(RestErrorStatus.CONFIG_ERROR, RestError.error(resource, filed, value, status, error));
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
