package cyan.toolkit.rest.identity.error;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestStatus;
import cyan.toolkit.rest.identity.IdentityErrorStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>IdentityWorkerException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:30 2020/1/13
 */
public class IdentityWorkerException extends IdentityException {

    public IdentityWorkerException() {
        super(IdentityErrorStatus.IDENTITY_WORKER_ERROR);
    }

    public IdentityWorkerException(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public IdentityWorkerException(String error) {
        super(error,IdentityErrorStatus.IDENTITY_WORKER_ERROR);
    }

    public IdentityWorkerException(RestStatus status) {
        super(status);
    }

    public IdentityWorkerException get() {
        return new IdentityWorkerException();
    }

    public String name() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("identity worker exception");
    }
}
