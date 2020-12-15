package cyan.toolkit.chief.error;

import cyan.toolkit.rest.error.natives.ServiceErrorException;

/**
 * <p>ServiceUnknowException</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 11:34 2020/10/30
 */
public class ServiceUnknownException extends ServiceErrorException {
    public ServiceUnknownException() {
        super(ServiceErrorStatus.SERVICE_ANNOTATION_ERROR);
    }

    public ServiceUnknownException(String resource, String service) {
        super(resource, service, ServiceErrorStatus.SERVICE_ANNOTATION_ERROR);
    }

    public ServiceUnknownException(String resource, String service, String error) {
        super(resource, service, ServiceErrorStatus.SERVICE_ANNOTATION_ERROR, error);
    }

    public ServiceUnknownException(String resource, String service, String error, Throwable cause) {
        super(resource, service, ServiceErrorStatus.SERVICE_ANNOTATION_ERROR, error, cause);
    }

    @Override
    public ServiceUnknownException get() {
        return new ServiceUnknownException();
    }

}
