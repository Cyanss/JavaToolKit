package cyan.toolkit.token.model;

import cyan.toolkit.chief.ChiefIdModel;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.bean.BeanUtils;
import cyan.toolkit.token.entity.UserInfoEntity;
import cyan.toolkit.token.enums.AccountType;
import cyan.toolkit.token.enums.AuthorityType;
import cyan.toolkit.token.enums.RoleType;

/**
 * <p>User</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:01 2021/6/28
 */
public class UserInfo extends ChiefIdModel<UserInfo, UserInfoEntity> {
    /** 账号 */
    protected String account;
    /** 昵称 */
    protected String nickname;
    /** 头像 */
    protected String avatar;
    /** 角色 */
    protected RoleType role = RoleType.USER;
    /** 权限 */
    protected AuthorityType authority = role.getAuthority();
    /** 状态 */
    protected AccountType status = AccountType.ACTIVATED;
    /** 级别 */
    protected Integer level;

    public UserInfo() {
    }

    public UserInfo(Long id) {
        super(id);
    }

    public UserInfo(UserInfo.Builder builder) {
        super(builder);
        this.account = builder.account;
        this.nickname = builder.nickname;
        this.avatar = builder.avatar;
        this.role = builder.role;
        this.authority = builder.authority;
        this.status = builder.status;
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

    public AuthorityType getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityType authority) {
        this.authority = authority;
    }

    public AccountType getStatus() {
        return status;
    }

    public void setStatus(AccountType status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public UserInfoEntity toEntity() throws RestException {
        return BeanUtils.copyNullProperties(this,new UserInfoEntity());
    }

    public static class Builder extends ChiefIdModel.Builder{
        protected String account;
        protected String nickname;
        protected String avatar;
        protected RoleType role;
        protected AuthorityType authority;
        protected AccountType status;
        protected Integer level;

        public Builder() {
        }

        public UserInfo.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public UserInfo.Builder account(String email) {
            this.account = account;
            return this;
        }

        public UserInfo.Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public UserInfo.Builder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserInfo.Builder role(RoleType role) {
            this.role = role;
            return this;
        }

        public UserInfo.Builder authority(AuthorityType authority) {
            this.authority = authority;
            return this;
        }

        public UserInfo.Builder status(AccountType status) {
            this.status = status;
            return this;
        }

        public UserInfo.Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this);
        }
    }
}
