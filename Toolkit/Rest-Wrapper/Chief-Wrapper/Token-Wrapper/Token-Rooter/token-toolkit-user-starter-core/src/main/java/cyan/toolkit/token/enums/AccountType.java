package cyan.toolkit.token.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cyan.toolkit.rest.RestValue;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * <p>AccountType</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:45 2021/6/29
 */
public enum AccountType implements RestValue<Integer,String> {
    INACTIVE(1,"未激活"),
    ACTIVATED(2,"已激活"),
    LOCKING(4,"锁定"),
    LOGOUT(8,"注销")
    ;

    private final Integer key;
    private final String value;

    AccountType(Integer key, String value) {
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

    @JsonCreator
    public static AccountType parserKey(@NonNull Integer key) {
        AccountType sortTypeEnum = RestValue.parserKey(AccountType.class, key);
        return Optional.ofNullable(sortTypeEnum).orElse(AccountType.INACTIVE);
    }

    public static AccountType parserValue(@NonNull String value) {
        AccountType sortTypeEnum = RestValue.parserValue(AccountType.class, value);
        return Optional.ofNullable(sortTypeEnum).orElse(AccountType.INACTIVE);
    }
}
