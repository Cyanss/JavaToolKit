package cyan.toolkit.rest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>RiceExceptionAdvice</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:26 2019/12/16
 */
@CrossOrigin
@ControllerAdvice
@RestControllerAdvice
public class DefaultAdvice implements ApplicationContextAware, InitializingBean {
    @Nullable
    private ApplicationContext applicationContext;
    @Nullable
    private List<RestAdvice> restAdvices;

    @Override
    public void afterPropertiesSet() {
        if (this.restAdvices == null) {
            Assert.notNull(this.applicationContext, "No ApplicationContext");
            this.restAdvices = initRestAdvices(this.applicationContext);
        }
    }

    public List<RestAdvice> getRestAdvices() {
        return this.restAdvices != null ? this.restAdvices : Collections.emptyList();
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @ResponseBody
    @ExceptionHandler(value = Error.class)
    public ResponseEntity errorHandle(Error error) {
        preErrorHandle(error);
        if (error instanceof DefaultError) {
            DefaultError defaultError = (DefaultError) error;
            afterDefaultErrorHandle(defaultError);
            return ResponseEntity.ok(new DefaultException(defaultError).buildResult());
        } else {
            afterErrorHandle(error);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(DefaultResult.fail(RestErrorStatus.UNKNOWN_ERROR.getStatus(),error.getMessage()));
        }
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandle(Exception exception) {
        preExceptionHandle(exception);
        if (exception instanceof DefaultException) {
            DefaultException defaultException = (DefaultException) exception;
            afterDefaultExceptionHandle(defaultException);
            return ResponseEntity.ok(defaultException.buildResult());
        } else {
            afterExceptionHandle(exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(DefaultResult.fail(RestErrorStatus.UNKNOWN_ERROR.getStatus(),exception.getMessage()));
        }
    }

    private void preErrorHandle(Error error) {
        if (this.restAdvices != null) {
            this.restAdvices.forEach(advice -> advice.preErrorHandle(error));
        }
    }

    private void afterDefaultErrorHandle(DefaultError defaultError) {
        RestError restError = (RestError) defaultError;
        if (this.restAdvices != null) {
            this.restAdvices.forEach(advice -> advice.afterRestErrorHandle(restError));
        }
    }

    private void afterErrorHandle(Error error) {
        if (this.restAdvices != null) {
            this.restAdvices.forEach(advice -> advice.afterErrorHandle(error));
        }
    }

    private void preExceptionHandle(Exception exception) {
        if (this.restAdvices != null) {
            this.restAdvices.forEach(advice -> advice.preExceptionHandle(exception));
        }
    }

    private void afterDefaultExceptionHandle(DefaultException defaultException) {
        RestException restException = (RestException) defaultException;
        if (this.restAdvices != null) {
            this.restAdvices.forEach(advice -> advice.afterRestExceptionHandle(restException));
        }
    }

    private void afterExceptionHandle(Exception exception) {
        if (this.restAdvices != null) {
            this.restAdvices.forEach(advice -> advice.afterExceptionHandle(exception));
        }
    }


    private static List<RestAdvice> initRestAdvices(ApplicationContext applicationContext) {
        Map<String, RestAdvice> beans = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, RestAdvice.class, true, false);
        if (!beans.isEmpty()) {
            List<RestAdvice> advices = new ArrayList<>(beans.values());
            AnnotationAwareOrderComparator.sort(advices);
            return Collections.unmodifiableList(advices);
        }
        return Collections.emptyList();
    }

}
