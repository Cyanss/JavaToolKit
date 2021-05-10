package cyan.toolkit.chief.jsonb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.NonNull;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>ContrastOperation</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:00 2021/5/7
 */
public enum ContrastOperation {
    /** 相等 */
    EQUAL_OPERATION(1, "target = values"),
    /** 大于 */
    GREATER_OPERATION(2, "target > values"),
    /** 大于等于 */
    GREATER_EQUAL_OPERATION(3, "target >= values"),
    /** 小于 */
    LESS_OPERATION(4, "target < values"),
    /** 小于等于 */
    LESS_EQUAL_OPERATION(5, "target <= values"),
    /** 不等于 */
    UNEQUAL_OPERATION(6, "target != values"),
    ;
    private final Integer key;
    private final String value;

    public static final String TARGET = "target";
    public static final String VALUE = "values";

    ContrastOperation(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @JsonValue
    public Integer getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String translateSql(String target,Object value) {
       return this.value.replace(TARGET, target).replace(VALUE, String.valueOf(value));
    }

    @JsonCreator
    public static ContrastOperation parserKey(@NonNull Integer key) {
        Map<Integer, ContrastOperation> operationEnums = Stream.of(ContrastOperation.values()).collect(Collectors.toMap(ContrastOperation::getKey, Function.identity()));
        return Optional.ofNullable(operationEnums.get(key)).orElse(ContrastOperation.EQUAL_OPERATION);
    }

    public static ContrastOperation parserValue(@NonNull String value) {
        Map<String, ContrastOperation> operationEnums = Stream.of(ContrastOperation.values()).collect(Collectors.toMap(ContrastOperation::getValue, Function.identity()));
        return Optional.ofNullable(operationEnums.get(value)).orElse(ContrastOperation.EQUAL_OPERATION);
    }
}
