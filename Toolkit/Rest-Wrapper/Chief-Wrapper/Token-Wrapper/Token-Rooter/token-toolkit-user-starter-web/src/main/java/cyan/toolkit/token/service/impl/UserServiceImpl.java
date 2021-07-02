package cyan.toolkit.token.service.impl;

import cyan.toolkit.chief.ChiefIdService;
import cyan.toolkit.chief.service.stereotype.RestService;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.token.entity.UserInfoEntity;
import cyan.toolkit.token.filter.UserFilter;
import cyan.toolkit.token.model.UserInfo;
import cyan.toolkit.token.service.UserService;

/**
 * <p>UserServiceImpl</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:35 2021/6/29
 */
@RestService(name = "userInfoService")
public class UserServiceImpl extends ChiefIdService<UserInfo, UserInfoEntity, UserFilter> implements UserService {

    @Override
    public String queryWhereSql(UserFilter filter) throws RestException {
        return filter.toIdSql("id").toTimeSql("registime").toUserSql().addSorts("id").toSql();
    }

}
