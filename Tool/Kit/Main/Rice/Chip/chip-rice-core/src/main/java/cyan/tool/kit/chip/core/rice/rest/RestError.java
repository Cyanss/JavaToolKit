package cyan.tool.kit.chip.core.rice.rest;

import cyan.tool.kit.chip.core.rice.defaults.DefaultError;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.Map;

/**
 * <p>BaseError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 18:10 2019/12/17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RestError extends DefaultError implements RestStatus {
    private Integer status;

    public RestError(Integer status) {
        this.status = status;
    }

    public RestError(String name, Integer domain, Integer status) {
        super(name, domain);
        this.status = status;
    }

    public RestError(String message, String name, Integer status) {
        super(message, name);
        this.status = status;
    }

    public RestError(String message, Throwable cause, String name, Integer status) {
        super(message, cause, name);
        this.status = status;
    }

    public RestError(Throwable cause, String name, Integer status) {
        super(cause, name);
        this.status = status;
    }

    public RestError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String name, Integer status) {
        super(message, cause, enableSuppression, writableStackTrace, name);
        this.status = status;
    }

    public RestError(String message, String name, Integer domain, Integer status) {
        super(message, name, domain);
        this.status = status;
    }

    public RestError(String message, Throwable cause, String name, Integer domain, Integer status) {
        super(message, cause, name, domain);
        this.status = status;
    }

    public RestError(Throwable cause, String name, Integer domain, Integer status) {
        super(cause, name, domain);
        this.status = status;
    }

    public RestError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String name, Integer domain, Integer status) {
        super(message, cause, enableSuppression, writableStackTrace, name, domain);
        this.status = status;
    }

    public RestError(String message, Throwable cause, Integer status) {
        super(message, cause);
        this.status = status;
    }

    public RestError(Throwable cause, Integer status) {
        super(cause);
        this.status = status;
    }

    public RestError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
    }

    @Override
    public Map<Integer, String> entry() {
        return Collections.singletonMap(this.status,this.getMessage());
    }
}
