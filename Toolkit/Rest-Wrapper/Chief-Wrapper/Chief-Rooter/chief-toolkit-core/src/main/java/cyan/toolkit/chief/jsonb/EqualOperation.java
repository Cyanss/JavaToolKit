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
 * <p>EqualOperation</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:10 2021/5/7
 */
public enum EqualOperation {
    /** 相等 */
    EQUAL_OPERATION(1, "target = 'values'"),
    /** 左模糊 */
    LEFT_LIKE_OPERATION(2, "target like concat('%','values')"),
    /** 右模糊 */
    RIGHT_LIKE_OPERATION(3, "target like concat('values','%')"),
    /** 全模糊 */
    ALL_LIKE_OPERATION(4, "target like concat('%','values','%')"),
    /** 不为空 */
    NOT_NULL_OPERATION(5, "target is not null"),
    ;

    private final Integer key;
    private final String value;

    public static final String TARGET = "target";
    public static final String VALUE = "values";

    EqualOperation(Integer key,String value) {
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

    public String translateSql(String target, Object value) {
        return this.value.replace(TARGET, target).replace(VALUE, String.valueOf(value));
    }

    @JsonCreator
    public static EqualOperation parserKey(@NonNull Integer key) {
        Map<Integer, EqualOperation> operationEnums = Stream.of(EqualOperation.values()).collect(Collectors.toMap(EqualOperation::getKey, Function.identity()));
        return Optional.ofNullable(operationEnums.get(key)).orElse(EqualOperation.EQUAL_OPERATION);
    }

    public static EqualOperation parserValue(@NonNull String value) {
        Map<String, EqualOperation> operationEnums = Stream.of(EqualOperation.values()).collect(Collectors.toMap(EqualOperation::getValue, Function.identity()));
        return Optional.ofNullable(operationEnums.get(value)).orElse(EqualOperation.EQUAL_OPERATION);
    }
}
