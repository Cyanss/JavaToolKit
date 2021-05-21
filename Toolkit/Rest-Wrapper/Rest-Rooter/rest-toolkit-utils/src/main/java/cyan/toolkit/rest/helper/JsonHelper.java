package cyan.toolkit.rest.helper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import cyan.toolkit.rest.error.ClassUnsupportedException;
import cyan.toolkit.rest.error.json.JsonParseBeanException;
import cyan.toolkit.rest.error.json.JsonParseListException;
import cyan.toolkit.rest.error.json.JsonParseMapException;
import cyan.toolkit.rest.error.json.JsonParseSetException;
import cyan.toolkit.rest.error.supply.JsonParseException;
import cyan.toolkit.rest.util.common.GeneralUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>JsonHelper</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 18:25 2019/11/20
 */
public class JsonHelper {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 序列化为Json字符串
     * @param target 目标数据
     * @param <T> 目标类型
     * @return String json字符串
     */
    public static <T> String parseJson(T target) throws JsonParseException {
        if(GeneralUtils.isEmpty(target)) {
            return null;
        }
        try {
            return MAPPER.writeValueAsString(target);
        } catch (JsonProcessingException exception) {
            throw new JsonParseException(target.getClass().getName(), exception.getMessage());
        }
    }
    /**
     * 序列化为Json字符串
     * @param target 目标数据
     * @param <T> 目标类型
     * @return String json字符串
     */
    public static <T> String parseJson(T target, TypeReference typeReference) throws JsonParseException {
        if(GeneralUtils.isEmpty(target)) {
            return null;
        }
        try {
            return MAPPER.writerFor(typeReference).writeValueAsString(target);
        } catch (JsonProcessingException exception) {
            throw new JsonParseException(target.getClass().getName(), exception.getMessage());
        }
    }

    /**
     * json字符串解析为Bean
     * @param json json字符串数据
     * @param clazz bean类
     * @param <T> bean类型
     * @return T Bean
     */
    public static <T> T parseBean(String json, Class<T> clazz) throws JsonParseBeanException {
        if(GeneralUtils.isEmpty(json)) {
            return null;
        }
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException exception) {
            throw new JsonParseBeanException(json,clazz.getName(), exception.getMessage());
        }

    }

    /**
     * json字符串解析为Bean<E>
     * @param json json字符串数据
     * @param clazz bean类
     * @param innerClazz 内部类型
     * @param <T> bean类型
     * @param <U> 内部类型
     * @return T cast [(T<U>) T]
     * @throws JsonParseBeanException
     */
    public static <T,U> T parseBean(String json, Class<T> clazz, Class<U> innerClazz) throws JsonParseBeanException {
        if(GeneralUtils.isEmpty(json)) {
            return null;
        }
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(clazz, innerClazz);
        try {
            return MAPPER.readValue(json, javaType);
        } catch (JsonProcessingException exception) {
            throw new JsonParseBeanException(json,javaType.getRawClass().getName(), exception.getMessage());
        }
    }

    /**
     * json字符串解析为BeanList
     * @param json json字符串数据
     * @param arrayType 序列化指定的ArrayType类型
     * @param <T> Bean类型
     * @return List<T> BeanList
     */
    public static <T> T[] parseArray(String json, ArrayType arrayType) throws JsonParseListException {
        if(GeneralUtils.isEmpty(json)) {
            return null;
        }
        try {
            return MAPPER.readValue(json, arrayType);
        } catch (JsonProcessingException exception) {
            throw new JsonParseListException(json,arrayType.getRawClass().getName(), exception.getMessage());
        }

    }

    /**
     * json字符串解析为BeanList
     * @param json json字符串数据
     * @param clazz Bean类
     * @param <Z> List类型
     * @param <T> Bean类型
     * @return List<T> BeanList
     */
    public static <Z extends List,T> T[] parseArray(String json, Class<T> clazz) throws JsonParseListException {
        ArrayType arrayType = MAPPER.getTypeFactory().constructArrayType(clazz);
        return parseArray(json,arrayType);
    }

    /**
     * json字符串解析为BeanList
     * @param json json字符串数据
     * @param listType 序列化指定的CollectionType类型
     * @param <T> Bean类型
     * @return List<T> BeanList
     */
    public static <T> List<T> parseList(String json, CollectionType listType) throws JsonParseListException {
        if(GeneralUtils.isEmpty(json)) {
            return Collections.emptyList();
        }
        try {
            return MAPPER.readValue(json, listType);
        } catch (JsonProcessingException exception) {
            throw new JsonParseListException(json,listType.getRawClass().getName(), exception.getMessage());
        }

    }

    /**
     * json字符串解析为BeanList
     * @param json json字符串数据
     * @param parseClazz List类
     * @param clazz Bean类
     * @param <Z> List类型
     * @param <T> Bean类型
     * @return List<T> BeanList
     */
    public static <Z extends List,T> List<T> parseList(String json, Class<Z> parseClazz, Class<T> clazz) throws JsonParseListException {
        CollectionType listType = MAPPER.getTypeFactory().constructCollectionType(parseClazz, clazz);
        return parseList(json,listType);
    }

    /**
     * json字符串解析为BeanList
     * @param json json字符串数据
     * @param clazz Bean类
     * @param <T> Bean类型
     * @return List<T> BeanList
     */
    public static <T> List<T> parseList(String json, Class<T> clazz) throws JsonParseListException {
        return parseList(json,List.class,clazz);
    }

    /**
     * json字符串解析为BeanSet
     * @param json json字符串数据
     * @param setType 序列化指定的CollectionType类型
     * @param <T> Bean类型
     * @return Set<T> BeanSet
     */
    public static <T> Set<T> parseSet(String json, CollectionType setType) throws JsonParseSetException {
        if(GeneralUtils.isEmpty(json)) {
            return Collections.emptySet();
        }
        try {
            return MAPPER.readValue(json, setType);
        } catch (JsonProcessingException exception) {
            throw new JsonParseSetException(json,setType.getRawClass().getName(), exception.getMessage());
        }
    }

    /**
     * json字符串解析为BeanSet
     * @param json json字符串数据
     * @param parseClazz Set类
     * @param clazz Bean类
     * @param <Z> Set类型
     * @param <T> Bean类型
     * @return Set<T> BeanSet
     */
    public static <Z extends Set,T> Set<T> parseSet(String json, Class<Z> parseClazz, Class<T> clazz) throws JsonParseSetException {
        CollectionType setType = MAPPER.getTypeFactory().constructCollectionType(parseClazz, clazz);
        return parseSet(json,setType);
    }

    /**
     * json字符串解析为BeanSet
     * @param json json字符串数据
     * @param clazz Bean类
     * @param <T> Bean类型
     * @return Set<T> BeanSet
     */
    public static <T> Set<T> parseSet(String json, Class<T> clazz) throws JsonParseSetException {
        return parseSet(json,Set.class,clazz);
    }

    /**
     * json字符串解析为BeanMap
     * @param json json字符串数据
     * @param mapType 序列化指定的MapType类型
     * @param <T> key类型
     * @param <K> value类型
     * @return Map<T, K> BeanMap
     */
    public static <T,K> Map<T, K> parseMap(String json, MapType mapType) throws JsonParseMapException {
        if(GeneralUtils.isEmpty(json)) {
            return Collections.emptyMap();
        }
        try {
            return MAPPER.readValue(json, mapType);
        } catch (JsonProcessingException exception) {
            throw new JsonParseMapException(json,mapType.getRawClass().getName(), exception.getMessage());
        }
    }

    /**
     * json字符串解析为BeanMap
     * @param json json字符串数据
     * @param parseClazz Map类
     * @param keyClazz key类
     * @param valueClazz value类
     * @param <Z> Map类型
     * @param <T> key类型
     * @param <K> value类型
     * @return Map<T, K>
     */
    public static <Z extends Map,T,K> Map<T, K> parseMap(String json, Class<Z> parseClazz, Class<T> keyClazz, Class<K> valueClazz) throws JsonParseMapException {
        MapType mapType = MAPPER.getTypeFactory().constructMapType(parseClazz, keyClazz, valueClazz);
        return parseMap(json,mapType);
    }

    /**
     * json字符串解析为BeanMap
     * @param json json字符串数据
     * @param keyClazz key类
     * @param valueClazz value类
     * @param <T> key类型
     * @param <K> value类型
     * @return Map<T, K> BeanMap
     */
    public static <T,K> Map<T, K> parseMap(String json, Class<T> keyClazz, Class<K> valueClazz) throws JsonParseMapException {
        return parseMap(json, Map.class,keyClazz,valueClazz);
    }


    /**
     *
     * json字符串解析为BeanMapList
     * @param json json字符串数据
     * @param parseListClazz List类
     * @param parseMapClazz Map类
     * @param keyClazz key类
     * @param valueClazz value类
     * @param <H> List类型
     * @param <Y> Map类型
     * @param <T> key类型
     * @param <K> value类型
     * @return Map<T,List<K>> BeanMapList
     */
    public static <H extends List,Y extends Map,T,K> Map<T,List<K>> parseMapList(String json, Class<H> parseListClazz, Class<Y> parseMapClazz, Class<T> keyClazz, Class<K> valueClazz) throws JsonParseMapException {
        CollectionType collectionType = MAPPER.getTypeFactory().constructCollectionType(parseListClazz, valueClazz);
        MapType mapType = MAPPER.getTypeFactory().constructMapType(parseMapClazz, keyClazz, collectionType.getRawClass());
        return parseMap(json,mapType);
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
    public static <Z extends List, Y extends Map, T, K> List<Map<T, K>> parseListMap(String json, Class<Z> wrapKeyClazz, Class<Y> contentMapClazz, Class<T> contentKeyClazz, Class<K> contentValueClazz) throws JsonParseListException {
        MapType contentType = MAPPER.getTypeFactory().constructMapType(contentMapClazz, contentKeyClazz, contentValueClazz);
        CollectionType collectionType = MAPPER.getTypeFactory().constructCollectionType(wrapKeyClazz, contentType.getRawClass());
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
    public static <T, K> List<Map<T, K>> parseListMap(String json, Class<T> contentKeyClazz, Class<K> contentValueClazz) throws JsonParseListException {
        MapType contentType = MAPPER.getTypeFactory().constructMapType(Map.class, contentKeyClazz, contentValueClazz);
        CollectionType collectionType = MAPPER.getTypeFactory().constructCollectionType(List.class, contentType.getRawClass());
        return parseList(json, collectionType);
    }

    /**
     *
     * json字符串解析为BeanMapList
     * @param json json字符串数据
     * @param keyClazz key类
     * @param valueClazz value类
     * @param <T> key类型
     * @param <K> value类型
     * @return Map<T,List<K>> BeanMapList
     */
    public static <T,K> Map<T,List<K>> parseMapList(String json, Class<T> keyClazz, Class<K> valueClazz) throws JsonParseMapException {
        return parseMapList(json,List.class,Map.class,keyClazz,valueClazz);
    }

    /**
     *
     * json字符串解析为BeanMapList
     * @param json json字符串数据
     * @param wrapMapClazz 外层Map类
     * @param contentMapClazz 内层Map类
     * @param wrapKeyClazz 外层key类型
     * @param contentKeyClazz 内层mapKey
     * @param contentValueClazz 内层mapValue
     * @param <H> 外层Map类型
     * @param <Y> 内层Map类型
     * @param <Z> 外层mapKey类型
     * @param <T> 内层mapKey类型
     * @param <K> 内层mapValue类型
     * @return Map<Z, Map<T, K>> BeanMapMap
     */
    public static<H extends Map,Y extends Map,Z,T,K> Map<Z, Map<T, K>> parseMapMap(String json, Class<H> wrapMapClazz, Class<Y> contentMapClazz, Class<Z> wrapKeyClazz, Class<T> contentKeyClazz, Class<K> contentValueClazz) throws JsonParseMapException {
        MapType contentType = MAPPER.getTypeFactory().constructMapType(contentMapClazz, contentKeyClazz,contentValueClazz);
        MapType mapType = MAPPER.getTypeFactory().constructMapType(wrapMapClazz, wrapKeyClazz, contentType.getRawClass());
        return parseMap(json,mapType);
    }

    /**
     * json多层map数据解析
     * @param json json数据
     * @param wrapKeyClazz 外层mapKey
     * @param contentKeyClazz 内层mapKey
     * @param contentValueClazz 内层mapValue
     * @param <Z> 外层mapKey类型
     * @param <T> 内层mapKey类型
     * @param <K> 内层mapValue类型
     * @return Map<Z,Map<T, K>> BeanMapMap
     */
    public static <Z,T,K> Map<Z, Map<T, K>> parseMapMap(String json, Class<Z> wrapKeyClazz, Class<T> contentKeyClazz, Class<K> contentValueClazz) throws JsonParseMapException {
        return parseMapMap(json,Map.class,Map.class,wrapKeyClazz,contentKeyClazz,contentValueClazz);
    }


    public static <T> T parseConvert(Object value, Class<T> clazz) throws ClassUnsupportedException {
        if(GeneralUtils.isEmpty(value)) {
            return null;
        }
        try {
            if (value.getClass().equals(clazz)) {
                return MAPPER.convertValue(value, clazz);
            } else {
                throw new ClassUnsupportedException(value.getClass().getName(),clazz.getName());
            }
        } catch (Exception exception) {
            throw new ClassUnsupportedException(value.getClass().getName(),clazz.getName(), exception.getMessage());
        }
    }

}
