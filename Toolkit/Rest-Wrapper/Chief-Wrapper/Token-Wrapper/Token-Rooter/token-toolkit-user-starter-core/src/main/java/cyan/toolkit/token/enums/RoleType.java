package cyan.toolkit.token.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cyan.toolkit.rest.RestValue;
import cyan.toolkit.rest.util.common.GeneralUtils;
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
    COMPLEX(0,"复合角色"),
    USER(2,"用户"),
    MEMBER(4,"成员"),
    LEADER(8,"组长"),
    MANAGER(16,"主管员"),
    ADMIN(32,"管理员"),
    SUPER(64,"超级管理员")
    ;

    private Integer key;
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

    private RoleType toKey(Integer complex) {
        this.key = complex;
        return this;
    }

    @JsonCreator
    public static RoleType parserKey(@NonNull Integer key) {
        RoleType sortTypeEnum = RestValue.parserKey(RoleType.class, key);
        return Optional.ofNullable(sortTypeEnum).orElse(RoleType.USER);
    }
    
    public static RoleType parserValue(@NonNull String value) {
        RoleType sortTypeEnum = RestValue.parserValue(RoleType.class, value);
        return Optional.ofNullable(sortTypeEnum).orElse(RoleType.USER);
    }

    public static RoleType encode(@NonNull RoleType... roleTypes) {
        if (GeneralUtils.isNotEmpty(roleTypes)) {
            int complex = 1;
            for (RoleType roleType : roleTypes) {
                complex = roleType.getKey() | complex;
            }
            return COMPLEX.toKey(complex);
        }
        return USER;
    }

    public static boolean decode(RoleType complex, RoleType roleType) {
        return decode(complex.getKey(),roleType);
    }

    public static boolean decode(Integer complex, RoleType roleType) {
        if (GeneralUtils.isNotEmpty(complex) && GeneralUtils.isNotEmpty(complex)) {
            return GeneralUtils.isNotEmpty(roleType.getKey() & complex);
        }
        return false;
    }

}
