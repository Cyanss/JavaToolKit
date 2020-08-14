package cyan.toolkit.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>RiceValue</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:07 2019/12/16
 */
public interface RestValue<K,V> extends RestKey<K> {

    /**
     * 获取值
     * @return Integer
     */
    V getValue();

    /**
     * 枚举信息 <status,message>
     * @return Map<Integer,String>
     */
    Map<K,V> entry();

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestValue<K,V>,K,V> List<T> list(Class<T> clazz) {
        return Arrays.asList(clazz.getEnumConstants());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestValue<K,V>,K,V> List<Map<K,V>> entry(Class<T> clazz) {
        return list(clazz).stream().map(RestValue::entry).distinct().collect(Collectors.toList());
    }


    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestValue<K,V>,K,V> List<V> value(Class<T> clazz) {
        return list(clazz).stream().map(RestValue::getValue).distinct().collect(Collectors.toList());
    }

    /**
     * pa
     * @param clazz 枚举类型
     * @param key key值
     * @param <T> 泛型
     * @return boolean
     */
    static <T extends RestValue<K,V>,K,V> Boolean confirm(Class<T> clazz, K key) {
        return Optional.ofNullable(map(clazz,key)).isPresent();
    }


    /**
     * 根据status获取枚举值
     * @param clazz 枚举类型
     * @param key status值
     * @param <T> 泛型
     * @return T
     */
    static <T extends RestValue<K,V>,K,V> T map(Class<T> clazz, K key){
       if (key != null && clazz.isEnum()) {
           List<T> enumList = Arrays.asList(clazz.getEnumConstants());
           Map<K, T> riceMap = enumList.stream().collect(Collectors.toMap(RestKey::getKey, rice -> rice));
           return riceMap.get(key);
       }
       return null;
    }
    
}
