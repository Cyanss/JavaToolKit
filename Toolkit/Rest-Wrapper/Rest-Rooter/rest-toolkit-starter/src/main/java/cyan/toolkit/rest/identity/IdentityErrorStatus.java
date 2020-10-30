package cyan.toolkit.rest.identity;

import cyan.toolkit.rest.RestStatus;
import lombok.Getter;

/**
 * <p>IdentityErrorStatus</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:51 2020/1/13
 */
@Getter
public enum IdentityErrorStatus implements RestStatus {
    WORKER_ID_INVALID(10530,"workerId无效"),
    CENTER_ID_INVALID(10531,"centerId无效"),
    IDENTITY_WORKER_ERROR(10532,"worker错误"),
    IDENTITY_WORKER_TIME_ERROR(10533,"centerId无效"),
    WORKER_TYPE_IS_NULL(10534,"WorkerType为空"),
    ;
    private final Integer status;
    private final String message;

    IdentityErrorStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getName() {
        return this.name().toLowerCase().replace("_", " ");
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
