package cyan.toolkit.token.service;

import cyan.toolkit.chief.service.FilterService;
import cyan.toolkit.token.filter.UserFilter;
import cyan.toolkit.token.model.UserInfo;

/**
 * <p>UserInfoService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:38 2021/6/29
 */
public interface UserService extends FilterService<Long, UserInfo, UserFilter> {
}
