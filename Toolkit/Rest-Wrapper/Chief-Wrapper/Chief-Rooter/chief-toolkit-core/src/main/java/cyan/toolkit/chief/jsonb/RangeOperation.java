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
 * <p>RangeOperation</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:16 2021/5/7
 */
public enum RangeOperation {
    /** 大于等于且小于等于 */
    GREATER_EQUAL_LESS_EQUAL_OPERATION(1, "(target >= start and target <= end)"),
    /** 大于等于且小于 */
    GREATER_EQUAL_LESS_OPERATION(2, "(target >= start and target < end)"),
    /** 大于且小于等于 */
    GREATER_LESS_EQUAL_OPERATION(3, "(target > start and target <= end)"),
    /** 大于且小于 */
    GREATER_LESS_OPERATION(4, "(target > start and target < end)"),
    ;

    private final Integer key;
    private final String value;

    public static final String TARGET = "target";
    public static final String START = "start";
    public static final String END = "end";

    RangeOperation(Integer key, String value) {
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

    public String translateSql(String target, Object startValue, Object endValue) {
        return this.value.replace(TARGET, target)
                .replace(START, String.valueOf(startValue))
                .replace(END, String.valueOf(endValue));
    }

    @JsonCreator
    public static RangeOperation parserKey(@NonNull Integer key) {
        Map<Integer, RangeOperation> operationEnums = Stream.of(RangeOperation.values()).collect(Collectors.toMap(RangeOperation::getKey, Function.identity()));
        return Optional.ofNullable(operationEnums.get(key)).orElse(RangeOperation.GREATER_EQUAL_LESS_EQUAL_OPERATION);
    }

    public static RangeOperation parserValue(@NonNull String value) {
        Map<String, RangeOperation> operationEnums = Stream.of(RangeOperation.values()).collect(Collectors.toMap(RangeOperation::getValue, Function.identity()));
        return Optional.ofNullable(operationEnums.get(value)).orElse(RangeOperation.GREATER_EQUAL_LESS_EQUAL_OPERATION);
    }
}
