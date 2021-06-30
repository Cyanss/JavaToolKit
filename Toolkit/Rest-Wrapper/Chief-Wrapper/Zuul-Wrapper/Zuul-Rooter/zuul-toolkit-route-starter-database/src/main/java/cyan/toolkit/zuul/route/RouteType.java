package cyan.toolkit.zuul.route;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cyan.toolkit.chief.enums.SortType;
import cyan.toolkit.rest.RestValue;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * <p>RouteStatus</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:15 2021/6/10
 */
public enum RouteType implements RestValue<Integer,String> {
    DEFAULT(0,"默认"),
    UPDATE(1,"新增"),
    REMOVE(2,"移除"),
    ;

    private final Integer key;
    private final String value;

    RouteType(Integer key, String value) {
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
    public static SortType parserKey(@NonNull Integer key) {
        SortType sortTypeEnum = RestValue.parserKey(SortType.class, key);
        return Optional.ofNullable(sortTypeEnum).orElse(SortType.DESC);
    }

    public static SortType parserValue(@NonNull String value) {
        SortType sortTypeEnum = RestValue.parserValue(SortType.class, value);
        return Optional.ofNullable(sortTypeEnum).orElse(SortType.DESC);
    }
}
