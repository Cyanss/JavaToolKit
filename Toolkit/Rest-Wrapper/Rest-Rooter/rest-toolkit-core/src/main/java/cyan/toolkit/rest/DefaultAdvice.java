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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private List<RestExceptionAdvice> restExceptionAdvices;

    @Override
    public void afterPropertiesSet() {
        if (this.restExceptionAdvices == null) {
            Assert.notNull(this.applicationContext, "No ApplicationContext");
            this.restExceptionAdvices = initRestAdvices(this.applicationContext);
        }
    }

    public List<RestExceptionAdvice> getRestExceptionAdvices() {
        return this.restExceptionAdvices != null ? this.restExceptionAdvices : Collections.emptyList();
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandle(Exception exception,HttpServletRequest request, HttpServletResponse response) {
        preExceptionHandle(exception,request,response);
        if (exception instanceof DefaultException) {
            DefaultException defaultException = (DefaultException) exception;
            doDefaultExceptionHandle(defaultException,request,response);
            return ResponseEntity.ok(defaultException.buildResult());
        } else {
            doExceptionHandle(exception,request,response);
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(DefaultResult.fail(RestErrorStatus.UNKNOWN_ERROR,exception));
        }
    }

    private void preExceptionHandle(Exception exception,HttpServletRequest request, HttpServletResponse response)  {
        if (this.restExceptionAdvices != null) {
            for (RestExceptionAdvice advice : this.restExceptionAdvices) {
                advice.preExceptionHandle(exception, request, response);
            }
        }
    }

    private void doDefaultExceptionHandle(DefaultException defaultException, HttpServletRequest request, HttpServletResponse response)  {
        RestException restException = (RestException) defaultException;
        if (this.restExceptionAdvices != null) {
            for (RestExceptionAdvice advice : this.restExceptionAdvices) {
                advice.doRestExceptionHandle(restException, request, response);
            }
        }
    }

    private void doExceptionHandle(Exception exception,HttpServletRequest request, HttpServletResponse response)  {
        if (this.restExceptionAdvices != null) {
            for (RestExceptionAdvice advice : this.restExceptionAdvices) {
                advice.doExceptionHandle(exception, request, response);
            }
        }
    }

    private static List<RestExceptionAdvice> initRestAdvices(ApplicationContext applicationContext) {
        Map<String, RestExceptionAdvice> beans = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, RestExceptionAdvice.class, true, false);
        if (!beans.isEmpty()) {
            List<RestExceptionAdvice> advices = new ArrayList<>(beans.values());
            AnnotationAwareOrderComparator.sort(advices);
            return Collections.unmodifiableList(advices);
        }
        return Collections.emptyList();
    }

}
