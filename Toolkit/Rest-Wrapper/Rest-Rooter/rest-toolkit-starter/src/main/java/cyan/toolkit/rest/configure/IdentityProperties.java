package cyan.toolkit.rest.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>IdentityProperties</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:32 2020/1/16
 */
@Data
@Component
@ConfigurationProperties(prefix = "cyan.toolkit.identity")
public class IdentityProperties {
    private Long workerId = 1L;
    private Long centerId = 2L;
}
