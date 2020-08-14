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
public class DefaultResult<T,S extends DefaultResult<T,S>> implements Serializable {
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
    public DefaultResult(DefaultResult.Builder<T,S> builder) {
        this(builder.status, builder.message, builder.data);
    }

    public DefaultResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> success() {
        return (new DefaultResult.Builder<T,S>()).status(RestErrorStatus.SUCCESS.getStatus()).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> success(T data) {
        return (new DefaultResult.Builder<T,S>()).status(RestErrorStatus.SUCCESS.getStatus()).data(data).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> success(String message) {
        return (new DefaultResult.Builder<T,S>()).status(RestErrorStatus.SUCCESS.getStatus()).message(message).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> success(String message, T data) {
        return (new DefaultResult.Builder<T,S>()).status(RestErrorStatus.SUCCESS.getStatus()).message(message).data(data).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> success(RestStatus status) {
        return (new DefaultResult.Builder<T,S>()).status(status.getStatus()).message(status.getMessage()).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> success(RestStatus status, T data) {
        return (new DefaultResult.Builder<T,S>()).status(status.getStatus()).message(status.getMessage()).data(data).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> fail(Integer status, String message, T data) {
        return (new DefaultResult.Builder<T,S>()).status(status).message(message).data(data).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> fail(Integer status, String message) {
        return (new DefaultResult.Builder<T,S>()).status(status).message(message).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> fail(RestStatus status) {
        return (new DefaultResult.Builder<T,S>()).status(status.getStatus()).message(status.getMessage()).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult<T,S> fail(RestStatus status, T data) {
        return (new DefaultResult.Builder<T,S>()).status(status.getStatus()).message(status.getMessage()).data(data).build();
    }

    public static <T,S extends DefaultResult<T,S>> DefaultResult.Builder<T,S> defaultBuilder() {
        return new DefaultResult.Builder<>();
    }

    public static class Builder<T,S extends DefaultResult<T,S>> {
        protected Integer status;
        protected String message;
        protected T data;

        public Builder() {
        }

        public DefaultResult.Builder<T,S> status(Integer status) {
            this.status = status;
            return this;
        }

        public DefaultResult.Builder<T,S> message(String message) {
            this.message = message;
            return this;
        }

        public DefaultResult.Builder<T,S> data(T data) {
            this.data = data;
            return this;
        }

        public DefaultResult<T,S> build() {
            return new DefaultResult<>(this);
        }
    }

}
