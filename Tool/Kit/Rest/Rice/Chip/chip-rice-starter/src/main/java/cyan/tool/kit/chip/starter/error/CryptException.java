package cyan.tool.kit.chip.starter.error;

import cyan.tool.kit.chip.core.error.RiceException;
import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>CipherException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:07 2020/1/17
 */
public class CryptException extends RiceException {
    public CryptException() {
        super(CryptErrorStatus.CRYPT_ERROR);
    }

    public CryptException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public CryptException(String message) {
        super(message, CryptErrorStatus.CRYPT_ERROR);
    }

    public CryptException(Integer status) {
        super(status, CryptErrorStatus.CRYPT_ERROR);
    }

    public CryptException(RestStatus status) {
        super(status);
    }

    public CryptException(Integer status, RestStatus restStatus) {
        super(status, restStatus);
    }

    public CryptException(String message, RestStatus status) {
        super(message, status);
    }

    public CryptException get() {
        return new CryptException();
    }

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("cipher exception");
    }
}
