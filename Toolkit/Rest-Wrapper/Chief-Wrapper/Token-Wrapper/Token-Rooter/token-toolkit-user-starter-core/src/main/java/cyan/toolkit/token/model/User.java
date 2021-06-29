package cyan.toolkit.token.model;

import cyan.toolkit.rice.model.IdModel;
import cyan.toolkit.token.enums.RoleType;

/**
 * <p>User</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:01 2021/6/28
 */
public class User extends IdModel<Long> {
    /** 账号 */
    protected String account;
    /** 昵称 */
    protected String nickname;
    /** 头像 */
    protected String avatar;
    /** 角色 */
    protected RoleType role = RoleType.USER;
    /** 级别 */
    protected Integer level;

    public User() {
    }

    public User(Long id) {
        super(id);
    }

    public User(User.Builder builder) {
        super(builder);
        this.account = builder.account;
        this.nickname = builder.nickname;
        this.avatar = builder.avatar;
        this.role = builder.role;
        this.level = builder.level;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public static class Builder extends IdModel.Builder<Long>{
        protected String account;
        protected String nickname;
        protected String avatar;
        protected RoleType role;
        protected Integer level;

        public Builder() {
        }

        public User.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public User.Builder account(String email) {
            this.account = account;
            return this;
        }

        public User.Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public User.Builder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public User.Builder role(RoleType role) {
            this.role = role;
            return this;
        }

        public User.Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
