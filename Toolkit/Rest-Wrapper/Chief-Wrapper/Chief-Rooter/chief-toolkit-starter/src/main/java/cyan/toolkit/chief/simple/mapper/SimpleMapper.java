package cyan.toolkit.chief.simple.mapper;

import cyan.toolkit.chief.mapper.InfoMapper;
import cyan.toolkit.chief.simple.SimpleEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>SimpleMapper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:50 2020/9/24
 */
@Component
public interface SimpleMapper extends InfoMapper<SimpleEntity, Long, Date,SimpleMapper> {
}
