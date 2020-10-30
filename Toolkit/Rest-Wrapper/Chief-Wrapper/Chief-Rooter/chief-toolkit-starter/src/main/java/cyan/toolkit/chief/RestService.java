package cyan.toolkit.chief;

import cyan.toolkit.chief.mapper.IdMapper;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * <p>RestService</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 17:55 2020/10/29
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RestService {
    @AliasFor(
            annotation = Service.class,
            attribute = "value"
    )
    String name() default "";

    Class<? extends IdMapper> mapper() default IdMapper.class;
}
