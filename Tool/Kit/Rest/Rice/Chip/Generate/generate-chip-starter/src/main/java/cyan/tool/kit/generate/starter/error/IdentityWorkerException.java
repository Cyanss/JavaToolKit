package cyan.tool.kit.generate.starter.error;

import cyan.tool.kit.generate.starter.identity.IdentityErrorStatus;
import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>IdentityWorkerException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:30 2020/1/13
 */
public class IdentityWorkerException extends GenerateException {

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

    public String getName() {
        return Optional.ofNullable(this.error).map(RestError::getName).orElse("identity worker exception");
    }
}
