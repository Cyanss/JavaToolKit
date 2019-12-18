package cyan.tool.kit.chip.core.rice.defaults;

import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;
import cyan.tool.kit.chip.core.rice.rest.RestStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * <p>BaseError</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 18:10 2019/12/17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RestError extends DefaultError implements RestStatus {
    private Integer status;

    public RestError(Integer status) {
        this.status = status;
    }

    public RestError(Integer status, String name, Integer domain) {
        super(name, domain);
        this.status = status;
    }

    public RestError(Integer status, String message, String name) {
        super(message, name);
        this.status = status;
    }

    public RestError( Integer status, String message, String name, Throwable cause) {
        super(message, cause, name);
        this.status = status;
    }

    public RestError(RestStatus status, Throwable cause) {
        super(cause, status.name());
        this.status = status.getStatus();
    }

    public RestError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String name, Integer status) {
        super(message, cause, enableSuppression, writableStackTrace, name);
        this.status = status;
    }

    public RestError(Integer status, String message, String name, Integer domain) {
        super(message, name, domain);
        this.status = status;
    }

    public RestError(Integer status, String message, String name, Integer domain, Throwable cause) {
        super(message, cause, name, domain);
        this.status = status;
    }

    public RestError(Integer status, String name, Integer domain, Throwable cause) {
        super(cause, name, domain);
        this.status = status;
    }

    public RestError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String name, Integer domain, Integer status) {
        super(message, cause, enableSuppression, writableStackTrace, name, domain);
        this.status = status;
    }

    public RestError(Integer status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public RestError( Integer status,Throwable cause) {
        super(cause);
        this.status = status;
    }

    public RestError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
    }

    private RestError(RestError.Builder builder) {
        super(builder);
        this.status = builder.getStatus();

    }

    public static RestError timeout(Integer status, String message) {
        Optional<RestResultStatus> option = Optional.ofNullable(RestStatus.get(RestResultStatus.class, status));
        RestStatusEnum.add(RestResultStatus.class, status, message,RestResultStatus.TIME_OUT.name());
        return (new Builder()).status(option.map((resultStatus) -> RestResultStatus.TIME_OUT.getStatus()).orElse(status)).message(message).build();
    }

    public static RestError timeout(RestStatus status) {
        return (new Builder()).status(RestResultStatus.TIME_OUT).message(status).build();
    }

    public static RestError timeout(String resource, RestStatus status) {
        return (new Builder()).status(RestResultStatus.TIME_OUT).resource(resource).message(status).build();
    }

    public static RestError paramError(String resource, String field, String error) {
        return (new RestError.Builder()).name(RestResultStatus.PARAM_ERROR).resource(resource).message(RestResultStatus.PARAM_ERROR).add(new RestErrorIssue(field, error)).build();
    }

    public static RestError parseError(String resource, String json, String error) {
        return (new RestError.Builder()).name(RestResultStatus.PARSE_ERROR).resource(resource).message(RestResultStatus.PARSE_ERROR).add(new RestErrorIssue(json, error)).build();
    }

    public static RestError resourceError(String field, String id, String error) {
        return (new RestError.Builder()).name(RestResultStatus.RESOURCE_ERROR).message(RestResultStatus.RESOURCE_ERROR).add(new RestErrorIssue(field, id, error)).build();
    }

    public static RestError fileError(String resource, String file, String error) {
        return (new RestError.Builder()).name(RestResultStatus.FILE_ERROR).resource(resource).message(RestResultStatus.FILE_ERROR).add(new RestErrorIssue(file, error)).build();
    }

    public static RestError authError(String resource, String user, String auth, String error) {
        return (new RestError.Builder()).name(RestResultStatus.AUTH_ERROR).resource(resource).message(RestResultStatus.AUTH_ERROR).add(new RestErrorIssue(user, auth, error)).build();
    }

    public static RestError tokenError(String resource, String user, String error) {
        return (new RestError.Builder()).name(RestResultStatus.TOKEN_ERROR).resource(resource).message(RestResultStatus.TOKEN_ERROR).add(new RestErrorIssue(resource, user, error)).build();
    }

    public static RestError serviceError(String resource, String service, String error) {
        return (new RestError.Builder()).name(RestResultStatus.SERVICE_ERROR).resource(resource).message(RestResultStatus.SERVICE_ERROR).add(new RestErrorIssue(resource, service, error)).build();
    }

    public static DefaultError dataError(String resource, String data, String error) {
        return (new DefaultError.Builder()).name(RestResultStatus.DATA_ERROR).resource(resource).message(RestResultStatus.DATA_ERROR).add(new DefaultErrorIssue(resource, data, error)).build();
    }


    @Override
    public String name() {
        return getName();
    }

    @Override
    public Map<Integer, String> entry() {
        return Collections.singletonMap(this.status,this.getMessage());
    }


    @Data
    public static class Builder extends DefaultError.Builder {
        private Integer status;

        public RestError.Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public RestError.Builder status(RestStatus status) {
            this.status = status.getStatus();
            return this;
        }

        public RestError.Builder name(String name) {
            super.name(name);
            return this;
        }

        public RestError.Builder name(RestStatus status) {
            super.name(status.name());
            return this;
        }

        public RestError.Builder message(String message) {
            super.message(message);
            return this;
        }

        public RestError.Builder message(RestStatus status) {
            super.message(status.getMessage());
            this.status = status.getStatus();
            return this;
        }

        public RestError.Builder debug(String debug) {
            super.debug(debug);
            return this;
        }

        public RestError.Builder resource(String resource) {
            super.resource(resource);
            return this;
        }

        public RestError.Builder add(RestErrorIssue issue) {
            super.add(issue);
            return this;
        }

        @Override
        public RestError build() {
            return new RestError(this);
        }
    }
}
