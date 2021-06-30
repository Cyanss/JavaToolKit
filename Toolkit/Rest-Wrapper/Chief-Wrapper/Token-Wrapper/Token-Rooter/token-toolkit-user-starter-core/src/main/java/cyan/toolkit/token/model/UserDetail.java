package cyan.toolkit.token.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.bean.BeanUtils;
import cyan.toolkit.token.entity.UserDetailEntity;
import cyan.toolkit.token.enums.AccountType;
import cyan.toolkit.token.enums.AuthorityType;
import cyan.toolkit.token.enums.RoleType;

import java.util.Date;
import java.util.Optional;

/**
 * <p>UserInfo</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:02 2021/6/28
 */
public class UserDetail extends UserInfo {
    /** 密码 */
    @JsonIgnore
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    protected Date registime;
    /** 激活时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    protected Date activatime;

    public UserDetail() {
    }

    public UserDetail(Long id) {
        super(id);
    }

    public UserDetail(Builder builder) {
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
    public UserDetailEntity toEntity() throws RestException {
        return BeanUtils.copyNullProperties(this, new UserDetailEntity());
    }

    public static class Builder extends UserInfo.Builder {
        protected String password;
        protected String mobile;
        protected String address;
        protected String signature;
        protected String description;
        protected Date registime;
        protected Date activatime;

        public Builder() {
        }

        public UserInfo.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public UserDetail.Builder account(String email) {
            this.account = account;
            return this;
        }

        public UserDetail.Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public UserDetail.Builder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserDetail.Builder role(RoleType role) {
            this.role = role;
            return this;
        }

        public UserDetail.Builder authority(AuthorityType authority) {
            this.authority = authority;
            return this;
        }

        public UserDetail.Builder status(AccountType status) {
            this.status = status;
            return this;
        }

        public UserDetail.Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public UserDetail.Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserDetail.Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public UserDetail.Builder address(String address) {
            this.address = address;
            return this;
        }

        public UserDetail.Builder signature(String signature) {
            this.signature = signature;
            return this;
        }

        public UserDetail.Builder description(String description) {
            this.description = description;
            return this;
        }

        public UserDetail.Builder registime(Long registime) {
            this.registime = Optional.ofNullable(registime).map(Date::new).orElse(null);
            return this;
        }

        public UserDetail.Builder registime(Date registime) {
            this.registime = registime;
            return this;
        }

        public UserDetail.Builder activatime(Long activatime) {
            this.activatime = Optional.ofNullable(activatime).map(Date::new).orElse(null);
            return this;
        }

        public UserDetail.Builder activatime(Date activatime) {
            this.activatime = activatime;
            return this;
        }

        public UserDetail build() {
            return new UserDetail(this);
        }
    }
}
