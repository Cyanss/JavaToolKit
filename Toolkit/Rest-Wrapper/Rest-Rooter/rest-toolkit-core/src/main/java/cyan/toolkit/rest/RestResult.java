package cyan.toolkit.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.ResponseEntity;

import java.util.Date;

/**
 * <p>RestResult</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:41 2020/8/14
 */


@Data
@EqualsAndHashCode(callSuper = true)
public class RestResult<T> extends DefaultResult<T,RestResult<T>> {
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date time;

    public RestResult() {
    }

    public RestResult(Integer status, String message) {
        super(status,message);
        this.time = new Date();
    }
    public RestResult(RestResult.Builder<T> builder) {
        super(builder.status, builder.message, builder.data);
        this.time = builder.time;
    }

    public RestResult(Integer status, String message, T data) {
        super(status,message,data);
        this.time = new Date();
    }

    public static <T> ResponseEntity<RestResult<T>> ok() {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(RestErrorStatus.SUCCESS.getStatus()).build());
    }

    public static <T> ResponseEntity<RestResult<T>> ok(T data) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(RestErrorStatus.SUCCESS.getStatus()).data(data).build());
    }

    public static <T> ResponseEntity<RestResult<T>> ok(String message) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(RestErrorStatus.SUCCESS.getStatus()).message(message).build());
    }

    public static <T> ResponseEntity<RestResult<T>> ok(String message, T data) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(RestErrorStatus.SUCCESS.getStatus()).message(message).data(data).build());
    }

    public static <T> ResponseEntity<RestResult<T>> ok(RestStatus status) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(status.getStatus()).message(status.getMessage()).build());
    }

    public static <T> ResponseEntity<RestResult<T>> ok(RestStatus status, T data) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(status.getStatus()).message(status.getMessage()).data(data).build());
    }

    public static <T> ResponseEntity<RestResult<T>> error(String message) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(RestErrorStatus.FAILED.getStatus()).message(message).build());
    }

    public static <T> ResponseEntity<RestResult<T>> error(String message, T data) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(RestErrorStatus.FAILED.getStatus()).message(message).data(data).build());
    }

    public static <T> ResponseEntity<RestResult<T>> error(Integer status, String message, T data) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(status).message(message).data(data).build());
    }

    public static <T> ResponseEntity<RestResult<T>> error(Integer status, String message) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(status).message(message).build());
    }

    public static <T> ResponseEntity<RestResult<T>> error(RestStatus status) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(status.getStatus()).message(status.getMessage()).build());
    }

    public static <T> ResponseEntity<RestResult<T>> error(RestStatus status, T data) {
        return ResponseEntity.ok((new RestResult.Builder<T>()).status(status.getStatus()).message(status.getMessage()).data(data).build());
    }

    public static <T> RestResult.Builder<T> builder() {
        return new RestResult.Builder<>();
    }

    public static class Builder<T> extends DefaultResult.Builder<T,RestResult<T>> {
        protected Date time;

        public Builder() {
            this.time = new Date();
        }

        public RestResult.Builder<T> status(Integer status) {
            super.status(status);
            return this;
        }

        public RestResult.Builder<T> message(String message) {
            super.message(message);
            return this;
        }

        public RestResult.Builder<T> data(T data) {
            super.data(data);
            return this;
        }

        public RestResult.Builder<T> time(Date time) {
            this.time = time;
            return this;
        }

        public RestResult.Builder<T> time(Long time) {
            this.time = new Date(time);
            return this;
        }

        public RestResult<T> build() {
            return new RestResult<>(this);
        }
    }
}
