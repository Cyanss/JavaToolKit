package cyan.tool.kit.chip.core.rice.defaults;

import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

/**
 * <p>RiceError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:13 2019/12/16
 */
@Data
@EqualsAndHashCode(callSuper = false)
class DefaultError extends Error {
    private Integer domain;
    private String resource;
    private String debug;
    private List<DefaultErrorIssue> issues;

    public DefaultError() {
    }

    public DefaultError(String message) {
        super(message);
    }

    public DefaultError(String message, Integer domain) {
        super(message);
        this.domain = domain;
    }


    public DefaultError(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DefaultError(String message, Integer domain,Throwable cause) {
        super(message, cause);
        this.domain = domain;
    }


    public DefaultError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String name, Integer domain) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.domain = domain;
    }

    protected DefaultError(Builder builder) {
        super(builder.getMessage());
        this.debug = builder.getDebug();
        this.issues = builder.getIssues();
    }

    @Data
    public static class Builder {
        private String message;
        private String debug;
        private String resource;
        private List<DefaultErrorIssue> issues;

        public Builder() {
        }

        public Builder(RestStatus status) {
            this.message = status.getMessage();
        }

        public DefaultError.Builder message(String message) {
            if (message != null && message.length() > 0) {
                this.message = message;
            }
            return this;
        }

        public DefaultError.Builder message(RestStatus status) {
            this.message = status.getMessage();
            return this;
        }

        public DefaultError.Builder debug(String debug) {
            this.debug = debug;
            return this;
        }

        public DefaultError.Builder resource(String resource) {
            this.resource = resource;
            return this;
        }

        public DefaultError.Builder add(DefaultErrorIssue issue) {
            this.issues = Optional.ofNullable(this.issues).orElseGet(ArrayList::new);
            this.issues.add(issue);
            return this;
        }

        public DefaultError build() {
            return new DefaultError(this);
        }
    }

}