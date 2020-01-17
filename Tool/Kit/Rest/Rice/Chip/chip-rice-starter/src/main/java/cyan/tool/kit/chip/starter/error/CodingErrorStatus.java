package cyan.tool.kit.chip.starter.error;

import cyan.tool.kit.rice.core.rice.rest.RestStatus;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;

/**
 * <p>EncodingErrorStatus</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:25 2020/1/17
 */
@Getter
public enum CodingErrorStatus implements RestStatus {
    ENCODING_ERROR(11010, "编码错误"),
    ENCODING_INVALID(11011, "编码格式无效"),
    DECODING_ERROR(11012, "解码错误"),
    DECODING_INVALID(11013, "解码格式无效"),
    ENCODING_TRANSFORM_ERROR(11014, "编码格式转换错误"),
    ;

    private final Integer status;
    private final String message;

    CodingErrorStatus(Integer status, String message) {
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
