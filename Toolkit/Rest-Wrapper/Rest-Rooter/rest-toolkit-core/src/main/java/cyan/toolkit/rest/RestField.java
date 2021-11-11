package cyan.toolkit.rest;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>RestField</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date created on 18:53 2021/9/9
 */
public interface RestField extends RestValue<Integer,String> {

    String getField();

    static <T extends RestField> T parserField(Class<T> clazz, String field) {
        if (field != null && clazz.isEnum()) {
            Map<String,T> valueEnumMap =Stream.of(clazz.getEnumConstants()).collect(Collectors.toMap(RestField::getField, Function.identity()));
            return valueEnumMap.get(field);
        } else {
            return null;
        }
    }

}
