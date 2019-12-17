package cyan.tool.kit.chip.core.rice.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;
import lombok.Data;

import java.util.Collections;
import java.util.Map;

/**
 * <p>Status</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:34 2019/12/17
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ErrorStatus implements RestStatus {

    private Integer status;

    private String message;

    public ErrorStatus() {
    }

    public ErrorStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public Map<Integer, String> entry() {
        return Collections.singletonMap(this.status,this.message);
    }

    @Override
    public ErrorStatus cast() {
        return this;
    }
}
