package cyan.tool.kit.generate.core.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>IdentityGenerateProperties</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:32 2020/1/16
 */
@Data
@Component
@ConfigurationProperties(prefix = "cyan.tool.kit.generate.identity")
public class IdentityProperties {
    private Long workerId;
    private Long centerId;
}
