package cyan.toolkit.token.filter;

import cyan.toolkit.chief.ChiefFilter;
import cyan.toolkit.chief.builder.SqlBuilders;
import cyan.toolkit.chief.jsonb.ContainRule;
import cyan.toolkit.chief.jsonb.ContrastRule;
import cyan.toolkit.chief.jsonb.EqualRule;
import cyan.toolkit.chief.jsonb.RangeRule;
import cyan.toolkit.chief.model.RestSort;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.token.enums.AccountType;
import cyan.toolkit.token.enums.AuthorityType;
import cyan.toolkit.token.enums.RoleType;
import org.springframework.lang.NonNull;

import java.util.*;

/**
 * <p>UserInfoFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:44 2021/6/29
 */
public class UserFilter extends ChiefFilter {
    /** 账号模糊查询 */
    protected String account;
    /** 账号查找 */
    protected Set<String> accounts;
    /** 昵称模糊查询 */
    protected String nickname;
    /** 昵称查找 */
    protected Set<String> nicknames;
    /** 用户角色 */
    protected RoleType role;
    /** 用户角色 */
    protected AuthorityType authority;
    /** 账户状态 */
    protected AccountType status;
    /** 级别 */
    protected Integer level;
    /** 是否查询详细信息 */
    protected boolean isLoadDetail;

    public UserFilter() {
    }

    public UserFilter(Long... ids) {
        super(ids);
    }

    public UserFilter(UserFilter.Builder builder) {
        super(builder);
        this.account = builder.account;
        this.accounts = builder.accounts;
        this.nickname = builder.nickname;
        this.nicknames = builder.nicknames;
        this.role = builder.role;
        this.authority = builder.authority;
        this.status = builder.status;
        this.level = builder.level;
        this.isLoadDetail = builder.isLoadDetail;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Set<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<String> accounts) {
        this.accounts = accounts;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(Set<String> nicknames) {
        this.nicknames = nicknames;
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

    public boolean isLoadDetail() {
        return isLoadDetail;
    }

    public void setLoadDetail(boolean loadDetail) {
        isLoadDetail = loadDetail;
    }

    public UserFilter toUserSql() {
        /** account sql */
        if (GeneralUtils.isNotEmpty(this.account)) {
            SqlBuilders.like(SQL_BUILDER, "account", this.account);
        } else if (GeneralUtils.isNotEmpty(this.accounts)) {
            SqlBuilders.in(SQL_BUILDER, "account", this.accounts);
        }
        /** nickname sql */
        if (GeneralUtils.isNotEmpty(this.nickname)) {
            SqlBuilders.like(SQL_BUILDER, "nickname", this.nickname);
        } else if (GeneralUtils.isNotEmpty(this.nicknames)) {
            SqlBuilders.in(SQL_BUILDER, "nickname", this.nicknames);
        }
        /** role sql */
        if (GeneralUtils.isNotEmpty(this.role)) {
            SqlBuilders.equal(SQL_BUILDER, "role", this.role);
        }
        /** role sql */
        if (GeneralUtils.isNotEmpty(this.authority)) {
            SqlBuilders.equal(SQL_BUILDER, "authority", this.authority);
        }
        /** role sql */
        if (GeneralUtils.isNotEmpty(this.status)) {
            SqlBuilders.equal(SQL_BUILDER, "status", this.status);
        }
        /** role sql */
        if (GeneralUtils.isNotEmpty(this.status)) {
            SqlBuilders.equal(SQL_BUILDER, "status", this.status);
        }
        /** role sql */
        if (GeneralUtils.isNotEmpty(this.level)) {
            SqlBuilders.equal(SQL_BUILDER, "level", this.level);
        }
        return this;
    }

    @Override
    public ChiefFilter toJsonbSql(@NonNull String alias) {
        super.toJsonbSql(alias);
        return this;
    }

    @Override
    public UserFilter toJsonbSql(@NonNull String alias, String variable) {
        super.toJsonbSql(alias,variable);
        return this;
    }

    @Override
    public UserFilter toTimeSql(@NonNull String alias) {
        super.toTimeSql(alias);
        return this;
    }

    @Override
    public UserFilter toIdSql(@NonNull String alias) {
        super.toIdSql(alias);
        return this;
    }

    public static class Builder extends ChiefFilter.Builder {
        protected String account;
        protected Set<String> accounts;
        protected String nickname;
        protected Set<String> nicknames;
        protected RoleType role;
        protected AuthorityType authority;
        protected AccountType status;
        protected Integer level;
        protected boolean isLoadDetail;

        public Builder() {
        }

        public UserFilter.Builder account(String account) {
            this.account = account;
            return this;
        }

        public UserFilter.Builder accounts(@NonNull Collection<String> accounts) {
            this.accounts = new HashSet<>(accounts);
            return this;
        }

        public UserFilter.Builder accounts(@NonNull String... accounts) {
            this.accounts = new HashSet<>(Arrays.asList(accounts));
            return this;
        }

        public UserFilter.Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public UserFilter.Builder nicknames(@NonNull Collection<String> nicknames) {
            this.nicknames = new HashSet<>(nicknames);
            return this;
        }

        public UserFilter.Builder nicknames(@NonNull String... nicknames) {
            this.nicknames = new HashSet<>(Arrays.asList(nicknames));
            return this;
        }

        public UserFilter.Builder role(RoleType role) {
            this.role = role;
            return this;
        }

        public UserFilter.Builder authority(AuthorityType authority) {
            this.authority = authority;
            return this;
        }

        public UserFilter.Builder status(AccountType status) {
            this.status = status;
            return this;
        }

        public UserFilter.Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public UserFilter.Builder isLoadDetail(boolean isLoadDetail) {
            this.isLoadDetail = isLoadDetail;
            return this;
        }

        public UserFilter.Builder contrasts(Collection<ContrastRule> contrasts) {
            this.contrasts = Optional.ofNullable(contrasts).map(HashSet::new).orElse(null);
            return this;
        }

        public UserFilter.Builder contrasts(ContrastRule... contrasts) {
            this.contrasts = Optional.ofNullable(contrasts).map(contrastList -> new HashSet<>(Arrays.asList(contrastList))).orElse(null);
            return this;
        }

        public UserFilter.Builder ranges(Collection<RangeRule> ranges) {
            this.ranges = Optional.ofNullable(ranges).map(HashSet::new).orElse(null);
            return this;
        }

        public UserFilter.Builder ranges(RangeRule... ranges) {
            this.ranges = Optional.ofNullable(ranges).map(rangeList -> new HashSet<>(Arrays.asList(rangeList))).orElse(null);
            return this;
        }

        public UserFilter.Builder equals(Collection<EqualRule> equals) {
            this.equals = Optional.ofNullable(equals).map(HashSet::new).orElse(null);
            return this;
        }

        public UserFilter.Builder equals(EqualRule... equals) {
            this.equals = Optional.ofNullable(equals).map(equalList -> new HashSet<>(Arrays.asList(equalList))).orElse(null);
            return this;
        }

        public UserFilter.Builder contains(Collection<ContainRule> contains) {
            this.contains = Optional.ofNullable(contains).map(HashSet::new).orElse(null);
            return this;
        }

        public UserFilter.Builder contains(ContainRule... contains) {
            this.contains = Optional.ofNullable(contains).map(containList -> new HashSet<>(Arrays.asList(containList))).orElse(null);
            return this;
        }

        public UserFilter.Builder startTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public UserFilter.Builder endTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public UserFilter.Builder ids(@NonNull Collection<Long> ids) {
            this.ids = new HashSet<>(ids);
            return this;
        }

        public UserFilter.Builder ids(@NonNull Long... ids) {
            this.ids = new HashSet<>(Arrays.asList(ids));
            return this;
        }

        public UserFilter.Builder sorts(@NonNull Collection<RestSort> sorts) {
            this.sorts = new HashSet<>(sorts);
            return this;
        }

        public UserFilter.Builder sorts(@NonNull RestSort... sorts) {
            this.sorts = new HashSet<>(Arrays.asList(sorts));
            return this;
        }

        public UserFilter.Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public UserFilter.Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public UserFilter build() {
            return new UserFilter(this);
        }
    }

}
