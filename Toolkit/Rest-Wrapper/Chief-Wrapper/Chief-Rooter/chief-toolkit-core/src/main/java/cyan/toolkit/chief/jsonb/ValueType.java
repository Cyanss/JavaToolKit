package cyan.toolkit.chief.jsonb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cyan.toolkit.rest.util.common.GeneralUtils;
import org.springframework.lang.NonNull;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>ValueType</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:52 2021/5/7
 */
public enum ValueType {
    /** 短整型 */
    SHORT(1, "int2"),
    /** 整型 */
    INTEGER(2, "int4"),
    /** 长整型 */
    LONG(3, "int8"),
    /** 单精度浮点类型 */
    FLOAT(4, "float4"),
    /** 双精度浮点类型 */
    DOUBLE(5, "float8"),
    /** 文本类型 */
    TEXT(6, "text"),
    /** 日期类型 */
    DATE(7, "date"),
    /** 布尔类型 */
    BOOLEAN(8, "bool"),
    /** 字符串类型 */
    STRING(9, "varchar"),
            ;
    private final Integer key;
    private final String value;

    ValueType(Integer key,String value) {
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

    @JsonCreator
    public static ValueType parserKey(@NonNull Integer key) {
        Map<Integer, ValueType> valueTypeEnums = Stream.of(ValueType.values()).collect(Collectors.toMap(ValueType::getKey, Function.identity()));
        return Optional.ofNullable(valueTypeEnums.get(key)).orElse(ValueType.STRING);
    }

    public static ValueType parserValue(@NonNull String value) {
        Map<String, ValueType> valueTypeEnums = Stream.of(ValueType.values()).collect(Collectors.toMap(ValueType::getValue, Function.identity()));
        return Optional.ofNullable(valueTypeEnums.get(value)).orElse(ValueType.STRING);
    }

    public static boolean isPresent(Integer key) {
        if (GeneralUtils.isEmpty(key)) {
            return false;
        }
        Map<Integer, ValueType> valueTypeEnums = Stream.of(ValueType.values()).collect(Collectors.toMap(ValueType::getKey, Function.identity()));
        return Optional.ofNullable(valueTypeEnums.get(key)).isPresent();
    }

    public static boolean isContrast(Integer key) {
        if (isPresent(key)) {
            ValueType valueType = parserKey(key);
            switch (valueType) {
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                case SHORT:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    public static boolean isRange(Integer key) {
        return isContrast(key);
    }

    public static boolean isEqual(Integer key) {
        if (isPresent(key)) {
            ValueType valueType = parserKey(key);
            switch (valueType) {
                case STRING:
                case TEXT:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    public static boolean isContain(Integer key) {
        if (isPresent(key)) {
            ValueType valueType = parserKey(key);
            switch (valueType) {
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                case SHORT:
                case TEXT:
                case STRING:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }


}
