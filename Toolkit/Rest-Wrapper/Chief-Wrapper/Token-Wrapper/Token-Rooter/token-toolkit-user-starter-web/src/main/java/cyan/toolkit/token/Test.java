package cyan.toolkit.token;

import cyan.toolkit.rest.util.bean.BeanUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.token.entity.UserInfoEntity;
import cyan.toolkit.token.model.UserInfo;

/**
 * <p>Test</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:05 2021/6/30
 */
public class Test {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        System.out.println("userInfo: " + JsonUtils.parseJson(userInfo));
//        UserInfo userInfo = new UserInfo.Builder().id(125L).account("account").nickname("nickname").level(1).build();
//        System.out.println("userInfo: " + JsonUtils.parseJson(userInfo));
//        UserInfoEntity userInfoEntity = BeanUtils.copyNullProperties(userInfo, new UserInfoEntity());
//        System.out.println("userInfoEntity: " + userInfoEntity);
    }
}
