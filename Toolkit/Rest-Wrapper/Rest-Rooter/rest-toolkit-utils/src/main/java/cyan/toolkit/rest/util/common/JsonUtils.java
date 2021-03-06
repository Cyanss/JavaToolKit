package cyan.toolkit.rest.util.common;

import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import cyan.toolkit.rest.error.ClassUnsupportedException;
import cyan.toolkit.rest.error.json.JsonParseBeanException;
import cyan.toolkit.rest.error.json.JsonParseListException;
import cyan.toolkit.rest.error.json.JsonParseMapException;
import cyan.toolkit.rest.error.json.JsonParseSetException;
import cyan.toolkit.rest.error.supply.JsonParseException;
import cyan.toolkit.rest.helper.JsonHelper;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>JsonUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 18:25 2019/11/20
 */
@Slf4j
public class JsonUtils {

    /**
     * 序列化为Json字符串
     * @param target 目标数据
     * @param <T>    目标类型
     * @return String json字符串
     */
    public static <T> String parseJson(T target) {
        try {
            return JsonHelper.parseJson(target);
        } catch (JsonParseException exception) {
            log.error("It is failed during bean to parse as json!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    /**
     * json字符串解析为Bean
     * @param json  json字符串数据
     * @param clazz bean类
     * @param <T>   bean类型
     * @return T Bean
     */
    public static <T> T parseBean(String json, Class<T> clazz) {
        try {
            return JsonHelper.parseBean(json, clazz);
        } catch (JsonParseBeanException exception) {
            log.error("It is failed during json to parse as bean!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    public static <T, U> T parseBean(String json, Class<T> clazz, Class<U> innerClazz) {
        try {
            return JsonHelper.parseBean(json, clazz, innerClazz);
        } catch (JsonParseBeanException exception) {
            log.error("It is failed during json to parse as bean<E>!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    /**
     * json字符串解析为BeanList
     * @param json     json字符串数据
     * @param listType 序列化指定的CollectionType类型
     * @param <T>      Bean类型
     * @return List<T> BeanList
     */
    public static <T> List<T> parseList(String json, CollectionType listType) {
        try {
            return JsonHelper.parseList(json, listType);
        } catch (JsonParseListException exception) {
            log.error("It is failed during json to parse as list of bean!", exception);
            exception.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * json字符串解析为BeanList
     * @param json       json字符串数据
     * @param parseClazz List类
     * @param clazz      Bean类
     * @param <Z>        List类型
     * @param <T>        Bean类型
     * @return List<T> BeanList
     */
    public static <Z extends List, T> List<T> parseList(String json, Class<Z> parseClazz, Class<T> clazz) {
        CollectionType listType = JsonHelper.MAPPER.getTypeFactory().constructCollectionType(parseClazz, clazz);
        return parseList(json, listType);
    }

    /**
     * json字符串解析为BeanList
     * @param json  json字符串数据
     * @param clazz Bean类
     * @param <T>   Bean类型
     * @return List<T> BeanList
     */
    public static <T> List<T> parseList(String json, Class<T> clazz) {
        return parseList(json, List.class, clazz);
    }

    /**
     * json字符串解析为BeanSet
     * @param json    json字符串数据
     * @param setType 序列化指定的CollectionType类型
     * @param <T>     Bean类型
     * @return Set<T> BeanSet
     */
    public static <T> Set<T> parseSet(String json, CollectionType setType) {
        try {
            return JsonHelper.parseSet(json, setType);
        } catch (JsonParseSetException exception) {
            log.error("It is failed during json to parse as set of bean!", exception);
            exception.printStackTrace();
            return Collections.emptySet();
        }
    }

    /**
     * json字符串解析为BeanSet
     * @param json       json字符串数据
     * @param parseClazz Set类
     * @param clazz      Bean类
     * @param <Z>        Set类型
     * @param <T>        Bean类型
     * @return Set<T> BeanSet
     */
    public static <Z extends Set, T> Set<T> parseSet(String json, Class<Z> parseClazz, Class<T> clazz) {
        CollectionType setType = JsonHelper.MAPPER.getTypeFactory().constructCollectionType(parseClazz, clazz);
        return parseSet(json, setType);
    }

    /**
     * json字符串解析为BeanSet
     * @param json  json字符串数据
     * @param clazz Bean类
     * @param <T>   Bean类型
     * @return Set<T> BeanSet
     */
    public static <T> Set<T> parseSet(String json, Class<T> clazz) {
        return parseSet(json, Set.class, clazz);
    }

    /**
     * json字符串解析为BeanMap
     * @param json    json字符串数据
     * @param mapType 序列化指定的MapType类型
     * @param <T>     key类型
     * @param <K>     value类型
     * @return Map<T, K> BeanMap
     */
    public static <T, K> Map<T, K> parseMap(String json, MapType mapType) {
        try {
            return JsonHelper.parseMap(json, mapType);
        } catch (JsonParseMapException exception) {
            log.error("It is failed during json to parse as map of bean!", exception);
            exception.printStackTrace();
            return Collections.emptyMap();
        }
    }


    /**
     * json字符串解析为BeanList
     * @param json      json字符串数据
     * @param arrayType 序列化指定的ArrayType类型
     * @param <T>       Bean类型
     * @return List<T> BeanList
     */
    public static <T> T[] parseArray(String json, ArrayType arrayType) {
        try {
            return JsonHelper.parseArray(json, arrayType);
        } catch (JsonParseListException exception) {
            log.error("It is failed during json to parse as map of bean!", exception);
            exception.printStackTrace();
            return null;
        }

    }

    /**
     * json字符串解析为BeanList
     * @param json  json字符串数据
     * @param clazz Bean类
     * @param <Z>   List类型
     * @param <T>   Bean类型
     * @return List<T> BeanList
     */
    public static <Z extends List, T> T[] parseArray(String json, Class<T> clazz) {
        ArrayType arrayType = JsonHelper.MAPPER.getTypeFactory().constructArrayType(clazz);
        return parseArray(json, arrayType);
    }

    /**
     * json字符串解析为BeanMap
     * @param json       json字符串数据
     * @param parseClazz Map类
     * @param keyClazz   key类
     * @param valueClazz value类
     * @param <Z>        Map类型
     * @param <T>        key类型
     * @param <K>        value类型
     * @return
     */
    public static <Z extends Map, T, K> Map<T, K> parseMap(String json, Class<Z> parseClazz, Class<T> keyClazz, Class<K> valueClazz) {
        MapType mapType = JsonHelper.MAPPER.getTypeFactory().constructMapType(parseClazz, keyClazz, valueClazz);
        return parseMap(json, mapType);
    }

    /**
     * json字符串解析为BeanMap
     * @param json       json字符串数据
     * @param keyClazz   key类
     * @param valueClazz value类
     * @param <T>        key类型
     * @param <K>        value类型
     * @return Map<T, K> BeanMap
     */
    public static <T, K> Map<T, K> parseMap(String json, Class<T> keyClazz, Class<K> valueClazz) {
        return parseMap(json, Map.class, keyClazz, valueClazz);
    }


    /**
     * json字符串解析为BeanMapList
     * @param json           json字符串数据
     * @param parseListClazz List类
     * @param parseMapClazz  Map类
     * @param keyClazz       key类
     * @param valueClazz     value类
     * @param <H>            List类型
     * @param <Y>            Map类型
     * @param <T>            key类型
     * @param <K>            value类型
     * @return Map<T, List < K>> BeanMapList
     */
    public static <H extends List, Y extends Map, T, K> Map<T, List<K>> parseMapList(String json, Class<H> parseListClazz, Class<Y> parseMapClazz, Class<T> keyClazz, Class<K> valueClazz) {
        CollectionType collectionType = JsonHelper.MAPPER.getTypeFactory().constructCollectionType(parseListClazz, valueClazz);
        MapType mapType = JsonHelper.MAPPER.getTypeFactory().constructMapType(parseMapClazz, keyClazz, collectionType.getRawClass());
        return parseMap(json, mapType);
    }

    /**
     * json字符串解析为BeanMapList
     * @param json       json字符串数据
     * @param keyClazz   key类
     * @param valueClazz value类
     * @param <T>        key类型
     * @param <K>        value类型
     * @return Map<T, List < K>> BeanMapList
     */
    public static <T, K> Map<T, List<K>> parseMapList(String json, Class<T> keyClazz, Class<K> valueClazz) {
        return parseMapList(json, List.class, Map.class, keyClazz, valueClazz);
    }

    /**
     * json多层map数据解析
     * @param json              json数据
     * @param contentKeyClazz   内层mapKey
     * @param contentValueClazz 内层mapValue
     * @param <T>               内层mapKey类型
     * @param <K>               内层mapValue类型
     * @return Map<Z, Map < T, K>> BeanMapMap
     */
    public static <Z extends List, Y extends Map, T, K> List<Map<T, K>> parseListMap(String json, Class<Z> wrapKeyClazz, Class<Y> contentMapClazz, Class<T> contentKeyClazz, Class<K> contentValueClazz) {
        MapType contentType = JsonHelper.MAPPER.getTypeFactory().constructMapType(contentMapClazz, contentKeyClazz, contentValueClazz);
        CollectionType collectionType = JsonHelper.MAPPER.getTypeFactory().constructCollectionType(wrapKeyClazz, contentType.getRawClass());
        return parseList(json, collectionType);
    }

    /**
     * json多层map数据解析
     * @param json              json数据
     * @param contentKeyClazz   内层mapKey
     * @param contentValueClazz 内层mapValue
     * @param <T>               内层mapKey类型
     * @param <K>               内层mapValue类型
     * @return Map<Z, Map < T, K>> BeanMapMap
     */
    public static <T, K> List<Map<T, K>> parseListMap(String json, Class<T> contentKeyClazz, Class<K> contentValueClazz) {
        MapType contentType = JsonHelper.MAPPER.getTypeFactory().constructMapType(Map.class, contentKeyClazz, contentValueClazz);
        CollectionType collectionType = JsonHelper.MAPPER.getTypeFactory().constructCollectionType(List.class, contentType.getRawClass());
        return parseList(json, collectionType);
    }

    /**
     * json字符串解析为BeanMapList
     * @param json              json字符串数据
     * @param wrapMapClazz      外层Map类
     * @param contentMapClazz   内层Map类
     * @param wrapKeyClazz      外层key类型
     * @param contentKeyClazz   内层mapKey
     * @param contentValueClazz 内层mapValue
     * @param <H>               外层Map类型
     * @param <Y>               内层Map类型
     * @param <Z>               外层mapKey类型
     * @param <T>               内层mapKey类型
     * @param <K>               内层mapValue类型
     * @return Map<Z, Map < T, K>> BeanMapMap
     */
    public static <H extends Map, Y extends Map, Z, T, K> Map<Z, Map<T, K>> parseMapMap(String json, Class<H> wrapMapClazz, Class<Y> contentMapClazz, Class<Z> wrapKeyClazz, Class<T> contentKeyClazz, Class<K> contentValueClazz) {
        MapType contentType = JsonHelper.MAPPER.getTypeFactory().constructMapType(contentMapClazz, contentKeyClazz, contentValueClazz);
        MapType mapType = JsonHelper.MAPPER.getTypeFactory().constructMapType(wrapMapClazz, wrapKeyClazz, contentType.getRawClass());
        return parseMap(json, mapType);
    }

    /**
     * json多层map数据解析
     * @param json              json数据
     * @param wrapKeyClazz      外层mapKey
     * @param contentKeyClazz   内层mapKey
     * @param contentValueClazz 内层mapValue
     * @param <Z>               外层mapKey类型
     * @param <T>               内层mapKey类型
     * @param <K>               内层mapValue类型
     * @return Map<Z, Map < T, K>> BeanMapMap
     */
    public static <Z, T, K> Map<Z, Map<T, K>> parseMapMap(String json, Class<Z> wrapKeyClazz, Class<T> contentKeyClazz, Class<K> contentValueClazz) {
        return parseMapMap(json, Map.class, Map.class, wrapKeyClazz, contentKeyClazz, contentValueClazz);
    }


    public static <T> T parseConvert(Object value, Class<T> clazz) {
        try {
            return JsonHelper.parseConvert(value, clazz);
        } catch (ClassUnsupportedException exception) {
            log.error("It is failed during object to convert as clazz of bean!", exception);
            exception.printStackTrace();
            return null;
        }
    }

}
