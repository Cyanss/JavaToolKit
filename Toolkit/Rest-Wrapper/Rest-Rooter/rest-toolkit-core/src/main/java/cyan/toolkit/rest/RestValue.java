package cyan.toolkit.rest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>RiceValue</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:07 2019/12/16
 */
public interface RestValue<K, V> extends RestKey<K> {

    /**
     * 获取值
     * @return Integer
     */
    V getValue();

    /**
     * 枚举信息 <status,message>
     * @return Map<Integer, String>
     */
    default Map<K, V> entry() {
        return Collections.singletonMap(this.getKey(), this.getValue());
    }

    /**
     * 枚举集合 <message>
     * @return Set<String>
     */
    static <T extends RestValue<K, V>, K, V> List<T> lists(Class<T> clazz) {
        return Arrays.asList(clazz.getEnumConstants());
    }

    /**
     * 枚举Map集合 <message>
     * @return Set<String>
     */
    static <T extends RestValue<K, V>, K, V> List<Map<K, V>> entries(Class<T> clazz) {
        return lists(clazz).stream().map(RestValue::entry).distinct().collect(Collectors.toList());
    }


    static <T extends RestValue<K, V>, K, V> List<RestEnum> mapKey(Class<T> clazz) {
        return lists(clazz).stream().map(RestEnum::mapKey).distinct().collect(Collectors.toList());
    }

    static <T extends RestValue<K, V>, K, V> List<RestEnum> mapValue(Class<T> clazz) {
        return lists(clazz).stream().map(RestEnum::mapValue).distinct().collect(Collectors.toList());
    }

    /**
     * 枚举值集合 <message>
     * @return Set<String>
     */
    static <T extends RestValue<K, V>, K, V> List<V> values(Class<T> clazz) {
        return lists(clazz).stream().map(RestValue::getValue).distinct().collect(Collectors.toList());
    }

    /**
     * @param clazz 枚举类型
     * @param key   key值
     * @param <T>   泛型
     * @return boolean
     */
    static <T extends RestValue<K, V>, K, V> Boolean confirm(Class<T> clazz, K key) {
        return Optional.ofNullable(parserKey(clazz, key)).isPresent();
    }


    /**
     * 通过key获取
     * @param key key
     * @return RestValue<K, V>
     */
    static <T extends RestValue<K, V>, K, V> T parserKey(Class<T> clazz, K key) {
        if (key != null && clazz.isEnum()) {
            Map<K, T> keyEnumMap = Stream.of(clazz.getEnumConstants()).collect(Collectors.toMap(RestKey::getKey, Function.identity()));
            return keyEnumMap.get(key);
        }
        return null;
    }


    /**
     * 通过value获取
     * @param value value
     * @return RestValue<K, V>
     */
    static <T extends RestValue<K, V>, K, V> T parserValue(Class<T> clazz, V value) {
        if (value != null && clazz.isEnum()) {
            Map<V, T> valueEnumMap = Stream.of(clazz.getEnumConstants()).collect(Collectors.toMap(RestValue::getValue, Function.identity()));
            return valueEnumMap.get(value);
        }
        return null;
    }

}
