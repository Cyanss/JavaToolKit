package cyan.toolkit.chief.error;

import cyan.toolkit.rest.RestStatus;
import lombok.Getter;

/**
 * <p>ServiceErrorStatus</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 10:29 2020/10/30
 */
@Getter
public enum ServiceErrorStatus implements RestStatus {
    SERVICE_REALIZATION_ERROR(10402,"服务必须实现IdFilterService接口"),
    SERVICE_ANNOTATION_ERROR(10403,"服务必须使用@RestService注解"),
    SERVICE_UNKNOWN_ERROR(10404,"资源服务未知")
    ;

    private final Integer status;
    private final String message;

    ServiceErrorStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getName() {
        return this.name().toLowerCase().replace("_", " ");
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

}
