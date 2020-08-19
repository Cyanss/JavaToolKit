package cyan.toolkit.auth.model;

import cyan.toolkit.rice.model.IdModel;

import java.util.Map;

/**
 * <p>AuthUser</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:41 2020/8/19
 */
public class AuthUser<K,V> extends IdModel<AuthUser<K,V>> {
    private String openId;
    private String username;
    private Map<K,V> otherInfo;
    private String nickname;
    private String avatar;

    public AuthUser() {
    }

    public AuthUser(Long id) {
        super(id);
    }

    public AuthUser(AuthUser.Builder builder) {
        super(builder);
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<K, V> getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(Map<K, V> otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
