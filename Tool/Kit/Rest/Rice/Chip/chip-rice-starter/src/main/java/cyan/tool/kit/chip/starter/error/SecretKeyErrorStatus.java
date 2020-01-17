package cyan.tool.kit.chip.starter.error;

import cyan.tool.kit.rice.core.rice.rest.RestStatus;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;

/**
 * <p>SecretKeyErrorStatus</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:38 2020/1/17
 */
@Getter
public enum SecretKeyErrorStatus implements RestStatus {
    SECRET_KEY_ERROR(11030, "加密错误"),
    SECRET_KEY_INVALID(11031, "加密算法错误"),
    ;

    private final Integer status;
    private final String message;

    SecretKeyErrorStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getName() {
        return this.name().toLowerCase().replace("_", " ");
    }

    public Map<Integer, String> entry() {
        return Collections.singletonMap(this.status, this.message);
    }
}
