package cyan.tool.kit.rice.core.rice.defaults;

import cyan.tool.kit.rice.core.rice.rest.RestStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * <p>RestErrrorIssue</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:43 2019/12/18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RestErrorIssue extends DefaultErrorIssue implements RestStatus {

    private Integer status;

    public RestErrorIssue() {
    }

    public RestErrorIssue(RestStatus status) {
        super(status.getName(),status.getMessage());
        this.status = status.getStatus();
    }

    public RestErrorIssue(RestStatus status, String message) {
        super(message);
        this.status = status.getStatus();
    }

    public RestErrorIssue(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public RestErrorIssue(Integer status, RestStatus restStatus) {
        super(restStatus.getMessage());
        this.status = status;
    }

    public RestErrorIssue(String field, RestStatus status) {
        super(field, status.getMessage());
        this.status = status.getStatus();
    }

    public RestErrorIssue(String field, RestStatus status, String message) {
        super(field, message);
        this.status = status.getStatus();
    }

    public RestErrorIssue(String field, Integer status,  String message) {
        super(field, message);
        this.status = status;
    }

    public RestErrorIssue(String field, Object value, Integer status, String message) {
        super(field, value, message);
        this.status = status;
    }

    public RestErrorIssue(String field, Object value, RestStatus status) {
        super(field, value, status.getMessage());
        this.status = status.getStatus();
    }

    public RestErrorIssue(String field, Object value, RestStatus status, String message) {
        super(field, value, message);
        this.status = status.getStatus();
    }

    @Override
    public String getName() {
        return Optional.ofNullable(this.getField()).orElse("rest error issue");
    }

    @Override
    public String getMessage() {
        return this.getIssue();
    }

    @Override
    public Map<Integer, String> entry() {
        return Collections.singletonMap(this.status, getIssue());
    }
}
