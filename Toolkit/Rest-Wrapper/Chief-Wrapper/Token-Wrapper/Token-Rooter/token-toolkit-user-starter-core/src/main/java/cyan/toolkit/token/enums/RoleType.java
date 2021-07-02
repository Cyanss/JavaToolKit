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
    GUEST(1,"来宾"),
    USER(2,"用户"),
    MEMBER(4,"成员"),
    LEADER(8,"组长"),
    MANAGER(16,"主管员"),
    ADMIN(32,"管理员"),
    SUPER(64,"超级管理员")
    ;

    private final Integer key;
    private final String value;

    RoleType(Integer key, String value) {
        this.key = key;
        this.value = value;
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
        return AuthorityType.valueOf(this.name());
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
