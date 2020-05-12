package cyan.toolkit.rest.kit;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.error.often.FieldNullException;
import cyan.toolkit.rest.error.often.IdentityNullException;
import cyan.toolkit.rest.error.supply.ParamMissingException;
import cyan.toolkit.rest.RestStatus;

import java.util.List;
import java.util.Optional;

/**
 * <p>属性校验辅助类</p>
 *
 * @author liuqingpo(snow22314@outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c)2016-2021
 * @date created on 上午 11:57 2019-7-16
 */
public class CheckKitUtils {

    public static void checkNullId(Long id) throws RestException {
        Optional.ofNullable(id).orElseThrow(IdentityNullException::new);
    }

    public static void checkNullId(Long id,String message) throws RestException {
        Optional.ofNullable(id).orElseThrow(() ->new IdentityNullException(message));
    }

    public static <T> void checkNullObject(T object) throws RestException {
        Optional.ofNullable(object).orElseThrow(FieldNullException::new);
    }

    public static <T> void checkNullObject(T object,String message) throws RestException {
        Optional.ofNullable(object).orElseThrow(() ->new FieldNullException(message));
    }

    public static <T> void checkMissField(T object) throws RestException {
        Optional.ofNullable(object).orElseThrow(ParamMissingException::new);
        if (object instanceof List) {
            for (Object o : ((List<?>) object)) {
                Optional.ofNullable(o).orElseThrow(ParamMissingException::new);
            }
        }
    }

    public static <T> void checkMissField(T object, String field) throws RestException {
        Optional.ofNullable(object).orElseThrow(() ->new ParamMissingException(field));
    }

    public static void checkComparerTrue(Boolean comparer, RestStatus status, String message) throws RestException {
        if (comparer) {
            throw new RestErrorException(message, RestError.error(status,message));
        }
    }

    public static void checkComparerFalse(Boolean comparer, RestStatus status, String message) throws RestException {
        if (!comparer) {
            throw new RestErrorException(message, RestError.error(status,message));
        }
    }

}
