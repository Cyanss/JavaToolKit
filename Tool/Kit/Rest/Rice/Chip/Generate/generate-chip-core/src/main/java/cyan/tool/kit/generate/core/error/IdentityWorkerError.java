package cyan.tool.kit.generate.core.error;

import cyan.tool.kit.generate.core.identity.IdentityErrorStatus;
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
public class IdentityWorkerError extends RestError {

    public IdentityWorkerError() {
        super(IdentityErrorStatus.IDENTITY_WORKER_ERROR);
    }

    public IdentityWorkerError(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public IdentityWorkerError(String error) {
        super(error,IdentityErrorStatus.IDENTITY_WORKER_ERROR);
    }

    public IdentityWorkerError(RestStatus status) {
        super(status);
    }

    public IdentityWorkerError get() {
        return new IdentityWorkerError();
    }

    public String getName() {
        return Optional.ofNullable(this.name).orElse("identity worker error");
    }
}
