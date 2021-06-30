package cyan.toolkit.token.entity;

import cyan.toolkit.chief.ChiefIdEntity;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.bean.BeanUtils;
import cyan.toolkit.token.enums.AccountType;
import cyan.toolkit.token.enums.RoleType;
import cyan.toolkit.token.model.UserInfo;

import javax.persistence.Table;

/**
 * <p>UserEnitiy</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:08 2021/6/29
 */
@Table(name = "token_user_list")
public class UserInfoEntity extends ChiefIdEntity<UserInfoEntity, UserInfo> {
    /** 账号 */
    protected String account;
    /** 昵称 */
    protected String nickname;
    /** 头像 */
    protected String avatar;
    /** 角色 */
    protected Integer role;
    /** 状态 */
    protected Integer status;
    /** 级别 */
    protected Integer level;

    public UserInfoEntity() {
    }

    public UserInfoEntity(Long id) {
        super(id);
    }

    public UserInfoEntity(Builder builder) {
        super(builder);
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public UserInfo toModel() throws RestException {
        return BeanUtils.copyNullProperties(this, new UserInfo());
    }

    public static class Builder extends ChiefIdEntity.Builder {
        protected String account;
        protected String nickname;
        protected String avatar;
        protected RoleType role;
        protected AccountType status;
        protected Integer level;

        public Builder() {
        }

        public UserInfoEntity.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public UserInfoEntity.Builder account(String email) {
            this.account = account;
            return this;
        }

        public UserInfoEntity.Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public UserInfoEntity.Builder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserInfoEntity.Builder role(RoleType role) {
            this.role = role;
            return this;
        }

        public UserInfoEntity.Builder status(AccountType status) {
            this.status = status;
            return this;
        }

        public UserInfoEntity.Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public UserInfoEntity build() {
            return new UserInfoEntity(this);
        }
    }
}
