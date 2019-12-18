package cyan.tool.kit.chip.core.rice.defaults;

import cyan.tool.kit.chip.core.rice.rest.RestStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.Map;

/**
 * <p>RestErrrorIssue</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:43 2019/12/18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RestErrorIssue extends DefaultErrorIssue implements RestStatus{

    private Integer status;

    public RestErrorIssue() {
    }

    public RestErrorIssue(RestStatus status) {
        super(status.name(),status.getMessage());
        this.status = status.getStatus();
    }

    public RestErrorIssue(String field, String issue) {
        super(field, issue);
    }

    public RestErrorIssue(String field, String value, String issue) {
        super(field, value, issue);
    }

    public RestErrorIssue(Integer status) {
        this.status = status;
    }

    public RestErrorIssue(Integer status, String field, String issue) {
        super(field, issue);
        this.status = status;
    }

    public RestErrorIssue(RestStatus status, String field) {
        super(field, status.getMessage());
        this.status = status.getStatus();
    }

    public RestErrorIssue(RestStatus status, String field, String value) {
        super(field, value, status.getMessage());
        this.status = status.getStatus();
    }

    @Override
    public String name() {
        return this.getField();
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
