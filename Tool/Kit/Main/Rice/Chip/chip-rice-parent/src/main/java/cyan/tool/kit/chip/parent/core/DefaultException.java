package cyan.tool.kit.chip.parent.core;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>RiceException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:11 2019/12/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DefaultException extends Exception implements DefaultStatus {
    protected DefaultError error;
    protected Integer status;

    public DefaultException() {
        super(DefaultResultStatus.FAILED.getMessage());
        this.status = DefaultResultStatus.FAILED.getStatus();
    }

    public DefaultException(String message) {
        super(message);
        this.status = DefaultResultStatus.FAILED.getStatus();
    }

    public DefaultException(Integer status) {
        super(DefaultResultStatus.FAILED.getMessage());
        this.status = status;
    }

    public DefaultException(DefaultError error) {
        super(error.getMessage());
        this.error = new DefaultError();
        this.status = DefaultResultStatus.FAILED.getStatus();
        this.error = error;
    }

    public DefaultException(DefaultResultStatus result) {
        super(result.getMessage());
        this.status = result.getStatus();
    }

    public DefaultException(DefaultStatus status) {
        super(status.getMessage());
        this.status = status.getStatus();
    }

    public DefaultException(Throwable cause) {
        super(DefaultResultStatus.FAILED.getMessage(), cause);
        this.status = DefaultResultStatus.FAILED.getStatus();
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

    public DefaultException(Integer status, DefaultResultStatus result) {
        super(result.getMessage());
        this.status = status;
    }

    public DefaultException(Integer status, DefaultStatus riceStatus) {
        super(riceStatus.getMessage());
        this.status = status;
    }

    public DefaultException(Integer status, Throwable cause) {
        super(DefaultResultStatus.FAILED.getMessage(), cause);
        this.status = status;
    }

    public DefaultException(String message, DefaultResultStatus result) {
        super(message);
        this.status = result.getStatus();
    }

    public DefaultException(String message, DefaultStatus status) {
        super(message);
        this.status = status.getStatus();
    }

    public DefaultException(DefaultStatus status, DefaultResultStatus result) {
        super(status.getMessage());
        this.status = status.getStatus();
    }

    public DefaultException(DefaultStatus status, DefaultError error) {
        super(status.getMessage());
        this.error = new DefaultError();
        this.status = status.getStatus();
        this.error = error;
    }

    public DefaultException(DefaultResultStatus result, DefaultError error) {
        super(result.getMessage());
        this.error = new DefaultError();
        this.status = result.getStatus();
        this.error = error;
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(DefaultError error, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = new DefaultError();
        this.status = DefaultResultStatus.FAILED.getStatus();
        this.error = error;
    }

    public DefaultException(DefaultResultStatus result, Throwable cause) {
        super(result.getMessage(), cause);
        this.status = result.getStatus();
    }

    public DefaultException(DefaultStatus status, Throwable cause) {
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

    public DefaultException(Integer status, DefaultResultStatus result, Throwable cause) {
        super(result.getMessage(), cause);
        this.status = status;
    }

    public DefaultException(Integer status, DefaultStatus riceStatus, Throwable cause) {
        super(riceStatus.getMessage(), cause);
        this.status = status;
    }

    public DefaultException(String message, DefaultResultStatus result, Throwable cause) {
        super(message, cause);
        this.status = result.getStatus();
    }

    public DefaultException(String message, DefaultStatus riceStatus, Throwable cause) {
        super(message, cause);
        this.status = riceStatus.getStatus();
    }

    public DefaultException(DefaultResultStatus result, DefaultError error, Throwable cause) {
        super(result.getMessage(), cause);
        this.error = new DefaultError();
        this.status = result.getStatus();
        this.error = error;
    }

    public DefaultException(DefaultStatus status, DefaultResultStatus result, Throwable cause) {
        super(status.getMessage(), cause);
        this.status = result.getStatus();
    }

    public DefaultException(DefaultStatus status, DefaultError error, Throwable cause) {
        super(status.getMessage(), cause);
        this.error = new DefaultError();
        this.status = status.getStatus();
        this.error = error;
    }

    public DefaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = DefaultResultStatus.FAILED.getStatus();
    }

    public DefaultException(DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(error.getMessage(), cause, enableSuppression, writableStackTrace);
        this.error = new DefaultError();
        this.status = DefaultResultStatus.FAILED.getStatus();
        this.error = error;
    }

    public DefaultException(DefaultResultStatus result, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(result.getMessage(), cause, enableSuppression, writableStackTrace);
        this.status = result.getStatus();
    }

    public DefaultException(DefaultStatus status, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
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

    public DefaultException(Integer status, DefaultResultStatus result, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(result.getMessage(), cause, enableSuppression, writableStackTrace);
        this.status = status;
    }

    public DefaultException(Integer status, DefaultStatus riceStatus, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(riceStatus.getMessage(), cause, enableSuppression, writableStackTrace);
        this.status = status;
    }

    public DefaultException(String message, DefaultResultStatus result, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = result.getStatus();
    }

    public DefaultException(String message, DefaultStatus status, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status.getStatus();
    }

    public DefaultException(DefaultStatus status, DefaultResultStatus result, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status.getMessage(), cause, enableSuppression, writableStackTrace);
        this.status = result.getStatus();
    }

    public DefaultException(DefaultResultStatus result, DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(result.getMessage(), cause, enableSuppression, writableStackTrace);
        this.error = new DefaultError();
        this.status = result.getStatus();
        this.error = error;
    }

    public DefaultException(DefaultStatus status, DefaultError error, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(status.getMessage(), cause, enableSuppression, writableStackTrace);
        this.error = new DefaultError();
        this.status = status.getStatus();
        this.error = error;
    }

    public final DefaultResult buildResult() {
        return DefaultResult.builder().status(this.status).message(getMessage()).data(this.error).build();
    }
}
