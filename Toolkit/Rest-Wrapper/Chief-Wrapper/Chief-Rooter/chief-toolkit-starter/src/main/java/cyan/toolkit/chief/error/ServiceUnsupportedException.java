package cyan.toolkit.chief.error;

import cyan.toolkit.rest.error.natives.ServiceErrorException;

/**
 * <p>ServiceUnsupportedException</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 16:40 2020/12/15
 */
public class ServiceUnsupportedException extends ServiceErrorException {
    public ServiceUnsupportedException() {
        super(ServiceErrorStatus.SERVICE_UNSUPPORTED_ERROR);
    }

    public ServiceUnsupportedException(String resource, String service) {
        super(resource, service, ServiceErrorStatus.SERVICE_UNSUPPORTED_ERROR);
    }

    public ServiceUnsupportedException(String resource, String service, String error) {
        super(resource, service, ServiceErrorStatus.SERVICE_UNSUPPORTED_ERROR, error);
    }

    @Override
    public ServiceUnknownException get() {
        return new ServiceUnknownException();
    }
}
