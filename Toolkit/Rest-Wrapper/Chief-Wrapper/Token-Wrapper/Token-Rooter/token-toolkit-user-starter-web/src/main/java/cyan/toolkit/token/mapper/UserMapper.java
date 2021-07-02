package cyan.toolkit.token.mapper;

import cyan.toolkit.chief.mapper.IdMapper;
import cyan.toolkit.chief.mapper.LoadMapper;
import cyan.toolkit.token.entity.UserInfoEntity;
import org.springframework.stereotype.Component;

/**
 * <p>UserMapper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:16 2021/6/30
 */
@Component
public interface UserMapper extends LoadMapper<UserInfoEntity,Long>, IdMapper<UserInfoEntity, Long> {

}
