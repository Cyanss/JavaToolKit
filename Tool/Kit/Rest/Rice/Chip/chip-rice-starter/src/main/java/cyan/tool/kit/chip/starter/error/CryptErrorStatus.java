package cyan.tool.kit.chip.starter.error;

import cyan.tool.kit.rice.core.rice.rest.RestStatus;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;

/**
 * <p>CipherErrorStatus</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:02 2020/1/17
 */
@Getter
public enum CryptErrorStatus implements RestStatus {
    CRYPT_ERROR(11020, "加密或解密错误"),
    CRYPT_ALGORITHM_ERROR(11021, "加密或解密算法错误"),
    CRYPT_ALGORITHM_INVALID(11022, "加密或解密算法无效"),
    ;

    private final Integer status;
    private final String message;

    CryptErrorStatus(Integer status, String message) {
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
