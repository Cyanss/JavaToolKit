package cyan.tool.kit.chip.core.rice.defaults;

import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
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
public class DefaultError extends Error {
    private String name;
    private Integer domain;
    private String resource;
    private String debug;
    private List<DefaultErrorIssue> contents;

    public DefaultError() {
    }

    public DefaultError(String name, Integer domain) {
        this.name = name;
        this.domain = domain;
    }

    public DefaultError(String message, String name) {
        super(message);
        this.name = name;
    }

    public DefaultError(String message, Throwable cause, String name) {
        super(message, cause);
        this.name = name;
    }

    public DefaultError(Throwable cause, String name) {
        super(cause);
        this.name = name;
    }

    public DefaultError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String name) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.name = name;
    }

    public DefaultError(String message, String name, Integer domain) {
        super(message);
        this.name = name;
        this.domain = domain;
    }

    public DefaultError(String message, Throwable cause, String name, Integer domain) {
        super(message, cause);
        this.name = name;
        this.domain = domain;
    }

    public DefaultError(Throwable cause, String name, Integer domain) {
        super(cause);
        this.name = name;
        this.domain = domain;
    }

    public DefaultError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String name, Integer domain) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.name = name;
        this.domain = domain;
    }

    public DefaultError(String message, Throwable cause) {
        super(message, cause);
    }

    private DefaultError(String message,DefaultError.Builder builder,Throwable cause) {
        super(message,cause);
        this.name = builder.name;
        this.debug = builder.debug;
        this.contents = builder.contents;
    }

    public DefaultError(Throwable cause) {
        super(cause);
    }

    private DefaultError(DefaultError.Builder builder,Throwable cause) {
        super(builder.message,cause);
        this.name = builder.name;
        this.debug = builder.debug;
        this.contents = builder.contents;
    }

    public DefaultError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    private DefaultError(DefaultError.Builder builder) {
        super(builder.message);
        this.name = builder.name;
        this.debug = builder.debug;
        this.contents = builder.contents;
    }

    @Data
    public static class Builder {
        private String name;
        private String message;
        private String debug;
        private String resource;
        private List<DefaultErrorIssue> contents;

        public Builder() {
        }

        public DefaultError.Builder name(String name) {
            this.name = name;
            return this;
        }

        public DefaultError.Builder name(RestResultStatus errorResult) {
            this.name = errorResult.name();
            return this;
        }


        public DefaultError.Builder message(String message) {
            this.message = message;
            return this;
        }

        public DefaultError.Builder message(RestResultStatus errorResult) {
            this.message = errorResult.getMessage();
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

        public DefaultError.Builder add(DefaultErrorIssue content) {
            this.contents = Optional.ofNullable(this.contents).orElseGet(ArrayList::new);
            this.contents.add(content);
            return this;
        }

        public DefaultError build() {
            return new DefaultError(this);
        }
    }

    public static DefaultError timeoutError(String resource) {
        return (new DefaultError.Builder()).resource(resource).message(RestResultStatus.TIME_OUT).build();
    }

    public static DefaultError paramError(String resource, String field, String error) {
        return (new DefaultError.Builder()).name(RestResultStatus.PARAM_ERROR).resource(resource).message(RestResultStatus.PARAM_ERROR).add(new DefaultErrorIssue(field, error)).build();
    }

    public static DefaultError parseError(String resource, String json, String error) {
        return (new DefaultError.Builder()).name(RestResultStatus.PARSE_ERROR).resource(resource).message(RestResultStatus.PARSE_ERROR).add(new DefaultErrorIssue(json, error)).build();
    }

    public static DefaultError resourceError(String field, String id, String error) {
        return (new DefaultError.Builder()).name(RestResultStatus.RESOURCE_ERROR).message(RestResultStatus.RESOURCE_ERROR).add(new DefaultErrorIssue(field, id, error)).build();
    }

    public static DefaultError fileError(String resource, String file, String error) {
        return (new DefaultError.Builder()).name(RestResultStatus.FILE_ERROR).resource(resource).message(RestResultStatus.FILE_ERROR).add(new DefaultErrorIssue(file, error)).build();
    }

    public static DefaultError authError(String resource, String user, String auth, String error) {
        return (new DefaultError.Builder()).name(RestResultStatus.AUTH_ERROR).resource(resource).message(RestResultStatus.AUTH_ERROR).add(new DefaultErrorIssue(user, auth, error)).build();
    }

    public static DefaultError tokenError(String resource, String user, String error) {
        return (new DefaultError.Builder()).name(RestResultStatus.TOKEN_ERROR).resource(resource).message(RestResultStatus.TOKEN_ERROR).add(new DefaultErrorIssue(resource, user, error)).build();
    }

    public static DefaultError serviceError(String resource, String service, String error) {
        return (new DefaultError.Builder()).name(RestResultStatus.SERVICE_ERROR).resource(resource).message(RestResultStatus.SERVICE_ERROR).add(new DefaultErrorIssue(resource, service, error)).build();
    }

    public static DefaultError dataError(String resource, String data, String error) {
        return (new DefaultError.Builder()).name(RestResultStatus.DATA_ERROR).resource(resource).message(RestResultStatus.DATA_ERROR).add(new DefaultErrorIssue(resource, data, error)).build();
    }


}
