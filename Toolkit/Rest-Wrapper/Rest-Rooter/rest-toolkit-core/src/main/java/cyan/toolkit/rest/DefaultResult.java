package cyan.toolkit.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>DefaultResult</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:26 2019/12/16
 */
@Data
public class DefaultResult<T> implements Serializable {
    private Integer status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    

    public DefaultResult() {
    }

    public DefaultResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
    public DefaultResult(DefaultResult.Builder<T> builder) {
        this(builder.status, builder.message, builder.data);
    }

    public DefaultResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> DefaultResult<T> success() {
        return (new DefaultResult.Builder<T>()).status(RestErrorStatus.SUCCESS.getStatus()).build();
    }

    public static <T> DefaultResult<T> success(T data) {
        return (new DefaultResult.Builder<T>()).status(RestErrorStatus.SUCCESS.getStatus()).data(data).build();
    }

    public static <T> DefaultResult<T> success(String message) {
        return (new DefaultResult.Builder<T>()).status(RestErrorStatus.SUCCESS.getStatus()).message(message).build();
    }

    public static <T> DefaultResult<T> success(String message, T data) {
        return (new DefaultResult.Builder<T>()).status(RestErrorStatus.SUCCESS.getStatus()).message(message).data(data).build();
    }

    public static <T> DefaultResult<T> success(RestStatus status) {
        return (new DefaultResult.Builder<T>()).status(status.getStatus()).message(status.getMessage()).build();
    }

    public static <T> DefaultResult<T> success(RestStatus status, T data) {
        return (new DefaultResult.Builder<T>()).status(status.getStatus()).message(status.getMessage()).data(data).build();
    }

    public static <T> DefaultResult<T> fail(String message) {
        return (new DefaultResult.Builder<T>()).status(RestErrorStatus.FAILED.getStatus()).message(message).build();
    }

    public static <T> DefaultResult<T> fail(String message, T data) {
        return (new DefaultResult.Builder<T>()).status(RestErrorStatus.FAILED.getStatus()).message(message).data(data).build();
    }

    public static <T> DefaultResult<T> fail(Integer status, String message, T data) {
        return (new DefaultResult.Builder<T>()).status(status).message(message).data(data).build();
    }

    public static <T> DefaultResult<T> fail(Integer status, String message) {
        return (new DefaultResult.Builder<T>()).status(status).message(message).build();
    }

    public static <T> DefaultResult<T> fail(RestStatus status) {
        return (new DefaultResult.Builder<T>()).status(status.getStatus()).message(status.getMessage()).build();
    }

    public static <T> DefaultResult<T> fail(RestStatus status, T data) {
        return (new DefaultResult.Builder<T>()).status(status.getStatus()).message(status.getMessage()).data(data).build();
    }

    public static <T> DefaultResult.Builder<T> defaultBuilder() {
        return new DefaultResult.Builder<>();
    }

    public static class Builder<T> {
        protected Integer status;
        protected String message;
        protected T data;

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
            return new DefaultResult<>(this);
        }
    }

}
