package cyan.toolkit.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>RestKey</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:07 2019/12/16
 */
public interface RestKey<K> {
    /**
     * 获取名字
     * @return String
     */
    String name();

    /**
     * 获取编码
     * @return K
     */
    K getKey();

    /**
     * T 集合 <K>
     * @return Set<T>
     */
    static <T extends RestKey<K>,K> List<T> values(Class<T> clazz) {
        return Arrays.asList(clazz.getEnumConstants());
    }

    /**
     * K 集合 <K>
     * @return Set<K>
     */
    static <T extends RestKey<K>,K> List<K> keys(Class<T> clazz) {
        return values(clazz).stream().map(RestKey::getKey).distinct().collect(Collectors.toList());
    }
    /**
     * 根据status获取枚举值
     * @param clazz 枚举类型
     * @param key status值
     * @param <T> 泛型
     * @return T
     */
    static <T extends RestValue<K,V>,K,V> T parseKey(Class<T> clazz, K key){
        if (key != null && clazz.isEnum()) {
            Map<K, T> restValueMap = Stream.of(clazz.getEnumConstants()).collect(Collectors.toMap(RestKey::getKey, Function.identity()));
            return restValueMap.get(key);
        }
        return null;
    }



}
