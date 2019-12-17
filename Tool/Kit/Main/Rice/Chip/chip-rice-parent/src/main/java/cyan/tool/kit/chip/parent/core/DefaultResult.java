package cyan.tool.kit.chip.parent.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * <p>Result</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:26 2019/12/16
 */
@Data
public class DefaultResult<T> {
    private Integer status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    private Date time;

    public DefaultResult() {
    }

    public DefaultResult(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public DefaultResult(DefaultResult.Builder<T> builder) {
        this(builder.status, builder.message, builder.data);
    }

    public DefaultResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.time = new Date();
    }

    public static <T> DefaultResult<T> ok() {
        return (new DefaultResult.Builder<T>()).status(DefaultResultStatus.SUCCESS.getStatus()).build();
    }

    public static <T> DefaultResult<T> ok(String message) {
        return (new DefaultResult.Builder<T>()).status(DefaultResultStatus.SUCCESS.getStatus()).message(message).build();
    }

    public static <T> DefaultResult<T> ok(String message, T data) {
        return (new DefaultResult.Builder<T>()).status(DefaultResultStatus.SUCCESS.getStatus()).message(message).data(data).build();
    }

    public static <T> DefaultResult<T> fail(int status, String message, T data) {
        return (new DefaultResult.Builder<T>()).status(status).message(message).data(data).build();
    }

    public static <T> DefaultResult<T> fail(int status, String message) {
        return (new DefaultResult.Builder<T>()).status(status).message(message).build();
    }

    public static <T> DefaultResult.Builder<T> builder() {
        return new DefaultResult.Builder<>();
    }

    public static class Builder<T> {
        private Integer status;
        private String message;
        private T data;

        public Builder() {
        }

        public DefaultResult.Builder<T> status(Integer status) {
            this.status = status;
            return this;
        }

        public DefaultResult.Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public DefaultResult.Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public DefaultResult<T> build() {
            return new DefaultResult<T>(this);
        }
    }

}
