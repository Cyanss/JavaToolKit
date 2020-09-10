package cyan.toolkit.chief.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cyan.toolkit.rest.RestKey;
import cyan.toolkit.rest.RestValue;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>SortEnum</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:44 2020/9/8
 */
public enum SortTypeEnum implements RestValue<Integer,String> {
    ASC(1,"ASC"),
    DESC(2,"DESC")
    ;

    private final Integer key;
    private final String value;

    SortTypeEnum(Integer key, String value) {
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

    @Override
    public Map<Integer, String> entry() {
        return Collections.singletonMap(this.key,this.value);
    }

    @Override
    public SortTypeEnum parseKey(@NonNull Integer key) {
        Map<Integer, SortTypeEnum> enumMap = Stream.of(SortTypeEnum.values()).collect(Collectors.toMap(RestKey::getKey, Function.identity()));
        return enumMap.get(key);
    }

    @Override
    @JsonCreator
    public SortTypeEnum parseValue(@NonNull String value) {
        Map<String, SortTypeEnum> enumMap = Stream.of(SortTypeEnum.values()).collect(Collectors.toMap(RestValue::getValue, Function.identity()));
        return enumMap.get(value);
    }


}
