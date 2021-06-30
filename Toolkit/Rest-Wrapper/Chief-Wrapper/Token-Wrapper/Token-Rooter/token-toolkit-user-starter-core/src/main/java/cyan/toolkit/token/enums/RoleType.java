package cyan.toolkit.token.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cyan.toolkit.rest.RestValue;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * <p>RoleType</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:08 2021/6/28
 */
public enum RoleType implements RestValue<Integer,String> {
    GUEST(1,"来宾",AuthorityType.GUEST),
    USER(2,"用户",AuthorityType.USER),
    MEMBER(4,"成员",AuthorityType.MEMBER),
    LEADER(8,"组长",AuthorityType.LEADER),
    MANAGER(16,"主管员",AuthorityType.MANAGER),
    ADMIN(32,"管理员",AuthorityType.ADMIN),
    SUPER(64,"超级管理员",AuthorityType.SUPER)
    ;

    private final Integer key;
    private final String value;
    private final AuthorityType authority;
    RoleType(Integer key, String value,AuthorityType authority) {
        this.key = key;
        this.value = value;
        this.authority = authority;
    }

    @Override
    @JsonValue
    public Integer getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public AuthorityType getAuthority() {
        return this.authority;
    }

    @JsonCreator
    public static RoleType parserKey(@NonNull Integer key) {
        RoleType sortTypeEnum = RestValue.parserKey(RoleType.class, key);
        return Optional.ofNullable(sortTypeEnum).orElse(RoleType.GUEST);
    }
    
    public static RoleType parserValue(@NonNull String value) {
        RoleType sortTypeEnum = RestValue.parserValue(RoleType.class, value);
        return Optional.ofNullable(sortTypeEnum).orElse(RoleType.GUEST);
    }

}
