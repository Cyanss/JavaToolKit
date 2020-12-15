package cyan.toolkit.chief.error;

import cyan.toolkit.rest.error.natives.ServiceErrorException;

/**
 * <p>ServiceException</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 10:28 2020/10/30
 */
public class ServiceRealizationException extends ServiceErrorException {

    public ServiceRealizationException() {
        super(ServiceErrorStatus.SERVICE_ANNOTATION_ERROR);
    }

    public ServiceRealizationException(String service) {
        super(service, ServiceErrorStatus.SERVICE_ANNOTATION_ERROR);
    }

    public ServiceRealizationException(String service, String error) {
        super(service, ServiceErrorStatus.SERVICE_ANNOTATION_ERROR, error);
    }

    @Override
    public ServiceRealizationException get() {
        return new ServiceRealizationException();
    }
}
