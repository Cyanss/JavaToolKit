package cyan.toolkit.rest;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>RiceError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:13 2019/12/16
 */
@Data
@EqualsAndHashCode(callSuper = false)
class DefaultError extends Error implements Serializable {
    protected Integer domain;
    protected String resource;
    protected String debug;
    protected List<DefaultErrorIssue> issues;

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
        super(builder.message);
        this.debug = builder.debug;
        this.resource = builder.resource;
        this.issues = builder.issues;
    }

    public static class Builder {
        protected String message;
        protected String debug;
        protected String resource;
        protected List<DefaultErrorIssue> issues;

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
