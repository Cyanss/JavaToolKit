package cyan.tool.kit.chip.core.rice.defaults;

import lombok.Data;

/**
 * <p>RiceErrorContent</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:17 2019/12/16
 */
@Data
class DefaultErrorIssue {
    private String field;
    private Object value;
    private String issue;

    public DefaultErrorIssue() {
    }

    protected DefaultErrorIssue(String issue) {
        this.issue = issue;
    }

    public DefaultErrorIssue(String field, String issue) {
        this.field = field;
        this.issue = issue;
    }

    public DefaultErrorIssue(String field, Object value, String issue) {
        this.field = field;
        this.value = value;
        this.issue = issue;
    }
}
