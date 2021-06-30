package cyan.toolkit.token.entity;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.bean.BeanUtils;
import cyan.toolkit.token.enums.AccountType;
import cyan.toolkit.token.enums.RoleType;
import cyan.toolkit.token.model.UserDetail;

import javax.persistence.Table;
import java.util.Date;

/**
 * <p>UserDetail</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:29 2021/6/29
 */
@Table(name = "token_user_list")
public class UserDetailEntity extends UserInfoEntity {
    /** 密码 */
    protected String password;
    /** 电话 */
    protected String mobile;
    /** 地址 */
    protected String address;
    /** 签名 */
    protected String signature;
    /** 简介 */
    protected String description;
    /** 注册时间 */
    protected Date registime;
    /** 激活时间 */
    protected Date activatime;

    public UserDetailEntity() {
    }

    public UserDetailEntity(Long id) {
        super(id);
    }

    public UserDetailEntity(Builder builder) {
        super(builder);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegistime() {
        return registime;
    }

    public void setRegistime(Date registime) {
        this.registime = registime;
    }

    public Date getActivatime() {
        return activatime;
    }

    public void setActivatime(Date activatime) {
        this.activatime = activatime;
    }

    @Override
    public UserDetail toModel() throws RestException {
        return BeanUtils.copyNullProperties(this,new UserDetail());
    }

    public static class Builder extends UserInfoEntity.Builder {
        protected String password;
        protected String mobile;
        protected String address;
        protected String signature;
        protected String description;
        protected Date registime;
        protected Date activatime;

        public Builder() {
        }

        public UserDetailEntity.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public UserDetailEntity.Builder account(String email) {
            this.account = account;
            return this;
        }

        public UserDetailEntity.Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public UserDetailEntity.Builder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserDetailEntity.Builder role(RoleType role) {
            this.role = role;
            return this;
        }

        public UserDetailEntity.Builder status(AccountType status) {
            this.status = status;
            return this;
        }

        public UserDetailEntity.Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public UserDetailEntity.Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserDetailEntity.Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public UserDetailEntity.Builder address(String address) {
            this.address = address;
            return this;
        }

        public UserDetailEntity.Builder signature(String signature) {
            this.signature = signature;
            return this;
        }

        public UserDetailEntity.Builder description(String description) {
            this.description = description;
            return this;
        }

        public UserDetailEntity.Builder registime(Date registime) {
            this.registime = registime;
            return this;
        }

        public UserDetailEntity.Builder activatime(Date activatime) {
            this.activatime = activatime;
            return this;
        }

        public UserDetailEntity build() {
            return new UserDetailEntity(this);
        }
    }
}
