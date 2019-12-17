package cyan.tool.kit.chip.core.rice.defaults;

import ch.qos.logback.core.status.ErrorStatus;
import cyan.tool.kit.chip.core.rice.rest.RestResult;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.Map;

/**
 * <p>RiceException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:11 2019/12/16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DefaultException extends Exception implements RestStatus {
    protected DefaultError error;
    protected Integer status;

    public DefaultException() {
        super(RestResultStatus.FAILED.getMessage());
        this.status = RestResultStatus.FAILED.getStatus();
    }

    public DefaultException(String message) {
        super(message);
        this.status = RestResultStatus.FAILED.getStatus();
    }

    public DefaultException(Integer status) {
        super(RestResultStatus.FAILED.getMessage());
        this.status = status;
    }

    public DefaultException(DefaultError error) {
        super(error.getMessage());
        this.error = new DefaultError();
        this.status = RestResultStatus.FAILED.getStatus();
        this.error = error;
    }


    public DefaultException(RestStatus status) {
        super(status.getMessage());
        this.status = status.getStatus();
    }

    public DefaultException(Throwable cause) {
        super(RestResultStatus.FAILED.getMessage(), cause);
        this.status = RestResultStatus.FAILED.getStatus();
    }

    public DefaultException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public DefaultException(Integer status, DefaultError error) {
        super(error.getMessage());
        this.error = new DefaultError();
        this.status = status;
        this.error = error;
    }

    public DefaultException(Integer status, RestStatus riceStatus) {
        super(riceStatus.getMessage());
        this.status = status;
    }

    public DefaultException(Integer status, Throwable cause) {
        super(RestResultStatus.FAILED.getMessage(), cause);
        this.status = status;
    }

    public DefaultException(String message, RestStatus status) {
        super(message);
        this.status = status.getStatus();
    }

    public DefaultException(RestStatus status, DefaultError error) {
        super(status.getMessage());
        this.error = new DefaultError();
        this.status = status.getStatus();
        this.error = error;
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(DefaultError error, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = new DefaultError();
        this.status = RestResultStatus.FAILED.getStatus();
        this.error = error;
    }

    public DefaultException(RestStatus status, Throwable cause) {
        super(status.getMessage(), cause);
        this.status = status.getStatus();
    }

    public DefaultException(int status, String message, DefaultError error) {
        super(message);
        this.error = new DefaultError();
        this.status = status;
        this.error = error;
    }

    public DefaultException(Integer status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public DefaultException(Integer status, DefaultError error, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = new DefaultError();
        this.status = status;
        this.error = error;
    }

    public DefaultException(Integer status, RestStatus riceStatus, Throwable cause) {
        super(riceStatus.getMessage(), cause);
        this.status = status;
    }

    public DefaultException(String message, RestStatus riceStatus, Throwable cause) {
        super(message, cause);
        this.status = riceStatus.getStatus();
    }

    public DefaultException(RestStatus status, DefaultError error, Throwable cause) {
        super(status.getMessage(), cause);
        this.error = new DefaultError();
        this.status = status.getStatus();
        this.error = error;
    }

    public DefaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = RestResultStatus.FAILED.getStatus();
    }

    public DefaultException(DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(error.getMessage(), cause, enableSuppression, writableStackTrace);
        this.error = new DefaultError();
        this.status = RestResultStatus.FAILED.getStatus();
        this.error = error;
    }

    public DefaultException(RestStatus status, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status.getMessage(), cause, enableSuppression, writableStackTrace);
        this.status = status.getStatus();
    }

    public DefaultException(Integer status, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
    }

    public DefaultException(Integer status, DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(error.getMessage(), cause, enableSuppression, writableStackTrace);
        this.error = new DefaultError();
        this.status = status;
        this.error = error;
    }

    public DefaultException(Integer status, RestStatus riceStatus, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(riceStatus.getMessage(), cause, enableSuppression, writableStackTrace);
        this.status = status;
    }

    public DefaultException(String message, RestStatus status, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status.getStatus();
    }

    public DefaultException(RestStatus status, DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status.getMessage(), cause, enableSuppression, writableStackTrace);
        this.error = new DefaultError();
        this.status = status.getStatus();
        this.error = error;
    }

    public final RestResult buildResult() {
        return RestResult.builder().status(this.status).message(getMessage()).data(this.error).build();
    }

    @Override
    public Map<Integer, String> entry() {
        return Collections.singletonMap(this.status,this.getMessage());
    }

}
