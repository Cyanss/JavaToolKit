package cyan.toolkit.chief.error;

import cyan.toolkit.rest.RestStatus;
import cyan.toolkit.rest.error.natives.ServiceErrorException;

import java.util.Optional;

/**
 * <p>ServiceException</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 10:28 2020/10/30
 */
public class ServiceAnnotationException extends ServiceErrorException {

    public ServiceAnnotationException() {
        super(ServiceErrorStatus.SERVICE_REALIZATION_ERROR);
    }

    public ServiceAnnotationException(String service) {
        super(service, ServiceErrorStatus.SERVICE_REALIZATION_ERROR);
    }

    public ServiceAnnotationException(String service, String error) {
        super(service, ServiceErrorStatus.SERVICE_REALIZATION_ERROR, error);
    }

    @Override
    public ServiceAnnotationException get() {
        return new ServiceAnnotationException();
    }

    @Override
    public String name() {
        return Optional.ofNullable((RestStatus) this.error).orElse(ServiceErrorStatus.SERVICE_REALIZATION_ERROR).name();
    }
}
