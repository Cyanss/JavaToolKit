package cyan.toolkit.chief.service.stereotype;

import cyan.toolkit.chief.mapper.IdMapper;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * <p>RestService</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:03 2020/11/3
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RestService {
    @AliasFor(
            annotation = org.springframework.stereotype.Service.class,
            attribute = "value"
    )
    String name() default "";

    Class<? extends IdMapper> mapper() default IdMapper.class;
}
