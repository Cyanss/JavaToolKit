package cyan.toolkit.chief.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cyan.toolkit.rest.RestValue;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * <p>SortEnum</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:44 2020/9/8
 */
public enum SortType implements RestValue<Integer,String> {
    ASC(1,"ASC"),
    DESC(2,"DESC")
    ;

    private final Integer key;
    private final String value;

    SortType(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return this.key;
    }

    @Override
    @JsonValue
    public String getValue() {
        return this.value;
    }
    
    public static SortType parserKey(@NonNull Integer key) {
        SortType sortTypeEnum = RestValue.parserKey(SortType.class, key);
        return Optional.ofNullable(sortTypeEnum).orElse(SortType.DESC);
    }
    
    @JsonCreator
    public static SortType parserValue(@NonNull String value) {
        SortType sortTypeEnum = RestValue.parserValue(SortType.class, value);
        return Optional.ofNullable(sortTypeEnum).orElse(SortType.DESC);
    }


}
