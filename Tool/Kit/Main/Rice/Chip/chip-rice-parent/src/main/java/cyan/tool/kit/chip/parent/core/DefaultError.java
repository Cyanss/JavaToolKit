package cyan.tool.kit.chip.parent.core;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = true)
public class DefaultError extends Error{
    private String name;
    private Integer domain;
    private String message;
    private String resource;
    private String debug;
    private List<DefaultErrorIssue> contents;

    public DefaultError() {
    }

    public DefaultError(String name, Integer domain) {
        this.name = name;
        this.domain = domain;
    }

    public DefaultError(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public DefaultError(String name, Integer domain, String message) {
        this.name = name;
        this.domain = domain;
        this.message = message;
    }

    private DefaultError(DefaultError.Builder builder) {
        this.name = builder.name;
        this.message = builder.message;
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

        public DefaultError.Builder name(DefaultResultStatus errorResult) {
            this.name = errorResult.name();
            return this;
        }


        public DefaultError.Builder message(String message) {
            this.message = message;
            return this;
        }

        public DefaultError.Builder message(DefaultResultStatus errorResult) {
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

    public static DefaultError timeout(String resource) {
        return (new DefaultError.Builder()).resource(resource).message(DefaultResultStatus.TIME_OUT).build();
    }

    public static DefaultError fieldError(String resource, String field) {
        return (new DefaultError.Builder()).name(DefaultResultStatus.FIELD_ERROR).message(DefaultResultStatus.FIELD_ERROR).add(new DefaultErrorIssue(resource, field, "")).build();
    }

    public static DefaultError jsonParseError(String resource, String json, String error) {
        return (new DefaultError.Builder()).name(DefaultResultStatus.JSON_PARSING_ERROR).resource(resource).message(DefaultResultStatus.JSON_PARSING_ERROR).add(new DefaultErrorIssue(json, error)).build();
    }

    public static DefaultError resourceAccessError(String field, String id) {
        return (new DefaultError.Builder()).name(DefaultResultStatus.RESOURCE_ACCESS_ERROR).message(DefaultResultStatus.RESOURCE_ACCESS_ERROR).add(new DefaultErrorIssue(field, id, "")).build();
    }


    public static DefaultError fileAccessError(String resource, String user, String auth) {
        return (new DefaultError.Builder()).name(DefaultResultStatus.FILE_ACCESS_ERROR).resource(resource).message(DefaultResultStatus.FILE_ACCESS_ERROR).add(new DefaultErrorIssue(user, auth, "")).build();
    }

    public static DefaultError accessAuthError(String resource, String user, String auth) {
        return (new DefaultError.Builder()).name(DefaultResultStatus.ACCESS_AUTH_ERROR).resource(resource).message(DefaultResultStatus.ACCESS_AUTH_ERROR).add(new DefaultErrorIssue(user, auth, "")).build();
    }


    public static DefaultError authTokenError(String resource, String user) {
        return (new DefaultError.Builder()).name(DefaultResultStatus.AUTH_TOKEN_ERROR).resource(resource).message(DefaultResultStatus.AUTH_TOKEN_ERROR).add(new DefaultErrorIssue(resource, user, "")).build();
    }

    public static DefaultError serviceAccessError(String resource, String service, String error) {
        return (new DefaultError.Builder()).name(DefaultResultStatus.SERVICE_ACCESS_ERROR).resource(resource).message(DefaultResultStatus.SERVICE_ACCESS_ERROR).add(new DefaultErrorIssue(resource, service, error)).build();
    }


}
