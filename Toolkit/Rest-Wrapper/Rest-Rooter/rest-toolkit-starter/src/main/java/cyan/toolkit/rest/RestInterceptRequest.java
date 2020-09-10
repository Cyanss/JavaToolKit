package cyan.toolkit.rest;

import java.util.Date;

/**
 * <p>RestIntercept</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:34 2020/9/9
 */
public class RestInterceptRequest<T extends RestInterceptRequest<T>> {
    private Long time;
    private Long startTime;
    private Long endTime;
    private Long costTime;
    private String ipAddress;
    private String userAgent;
    private String method;
    private String url;
    private String param;
    private Integer status;
    private String message;

    public RestInterceptRequest() {
    }

    private RestInterceptRequest(RestInterceptRequest.Builder<T> builder) {
        this.time = builder.time;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.costTime = builder.costTime;
        this.ipAddress = builder.ipAddress;
        this.userAgent = builder.userAgent;
        this.method = builder.method;
        this.url = builder.url;
        this.param = builder.param;
        this.status = builder.status;
        this.message = builder.message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Builder<T extends RestInterceptRequest<T>> {
        protected Long time;
        protected Long startTime;
        protected Long endTime;
        protected Long costTime;
        protected String ipAddress;
        protected String userAgent;
        protected String method;
        protected String url;
        protected String param;
        protected Integer status;
        protected String message;
        public Builder() {
        }

        public RestInterceptRequest.Builder<T> time() {
            this.time = new Date().getTime();
            return this;
        }

        public RestInterceptRequest.Builder<T> time(Long time) {
            this.time = time;
            return this;
        }

        public RestInterceptRequest.Builder<T> startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }

        public RestInterceptRequest.Builder<T> endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }

        public RestInterceptRequest.Builder<T> costTime(Long costTime) {
            this.costTime = costTime;
            return this;
        }

        public RestInterceptRequest.Builder<T> ipAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public RestInterceptRequest.Builder<T> userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public RestInterceptRequest.Builder<T> method(String method) {
            this.method = method;
            return this;
        }

        public RestInterceptRequest.Builder<T> url(String url) {
            this.url = url;
            return this;
        }

        public RestInterceptRequest.Builder<T> param(String param) {
            this.param = param;
            return this;
        }

        public RestInterceptRequest.Builder<T> status(Integer status) {
            this.status = status;
            return this;
        }

        public RestInterceptRequest.Builder<T> message(String message) {
            this.message = message;
            return this;
        }
        
        public RestInterceptRequest<T> build() {
            return new RestInterceptRequest<>(this);
        }
    }
}
