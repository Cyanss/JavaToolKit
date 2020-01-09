package cyan.tool.kit.rice.core.rice.rest;

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
public class RestResult<T> {
    private Integer status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date time;

    public RestResult() {
    }

    public RestResult(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public RestResult(RestResult.Builder<T> builder) {
        this(builder.status, builder.message, builder.data);
    }

    public RestResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.time = new Date();
    }

    public static <T> RestResult<T> success() {
        return (new RestResult.Builder<T>()).status(RestResultStatus.SUCCESS.getStatus()).build();
    }

    public static <T> RestResult<T> success(String message) {
        return (new RestResult.Builder<T>()).status(RestResultStatus.SUCCESS.getStatus()).message(message).build();
    }

    public static <T> RestResult<T> success(String message, T data) {
        return (new RestResult.Builder<T>()).status(RestResultStatus.SUCCESS.getStatus()).message(message).data(data).build();
    }

    public static <T> RestResult<T> error(int status, String message, T data) {
        return (new RestResult.Builder<T>()).status(status).message(message).data(data).build();
    }

    public static <T> RestResult<T> error(int status, String message) {
        return (new RestResult.Builder<T>()).status(status).message(message).build();
    }

    public static <T> RestResult.Builder<T> builder() {
        return new RestResult.Builder<>();
    }

    public static class Builder<T> {
        private Integer status;
        private String message;
        private T data;

        public Builder() {
        }

        public RestResult.Builder<T> status(Integer status) {
            this.status = status;
            return this;
        }

        public RestResult.Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public RestResult.Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public RestResult<T> build() {
            return new RestResult<T>(this);
        }
    }

}
