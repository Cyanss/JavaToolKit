package cyan.toolkit.chief.jts.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import cyan.toolkit.rest.RestStatus;

/**
 * <p>JtsParseException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:25 2020/9/22
 */
public class JtsParseException extends JsonProcessingException implements RestStatus {
    public static final Integer ERROR_STATUS = 10700;
    public static final String ERROR_MESSAGE = "Jts相关数据解析错误";

    protected Integer status;

    public JtsParseException() {
        super(ERROR_MESSAGE);
        this.status = ERROR_STATUS;
    }

    public JtsParseException(String message) {
        super(message);
        this.status = ERROR_STATUS;
    }

    public JtsParseException(Integer status, String message) {
        super(message);
        this.status = ERROR_STATUS;
    }

    public JtsParseException(String message, RestStatus status) {
        super(message);
        this.status = status.getStatus();
    }

    public JtsParseException(String message, Throwable cause) {
        super(message,cause);
        this.status = ERROR_STATUS;
    }

    public JtsParseException(String message, RestStatus status, Throwable cause) {
        super(message,cause);
        this.status = status.getStatus();
    }

    public JtsParseException(Integer status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public JtsParseException get() {
        return new JtsParseException();
    }

    public String name() {
        return "jts parse exception";
    }

    @Override
    public Integer getStatus() {
        return this.status;
    }
}
