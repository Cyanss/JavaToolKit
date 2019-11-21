package cyan.tool.kit.common.flux.util.base;

import java.util.*;

/**
 * <p>ShuntUtils</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:26 2019/11/21
 */
public class ShuntUtils {
    /**
     * 数据归类分拣
     * @param key  分拣依据
     * @param data 分拣的数据
     * @param falseList 条件假的集合
     * @param trueList 条件真的集合
     * @param <T> 分拣数据类型
     */
    public static <T> void shuntData(Boolean key, T data, List<T> falseList, List<T> trueList) {
        if (key) {
            trueList.add(data);
        } else {
            falseList.add(data);
        }
    }

    /**
     * 数据归类分拣
     *
     * @param key     分拣依据 即Map的key键
     * @param data    分拣的数据 即Map的value键集合的数据
     * @param dataMap 分拣的结果
     * @param <K>     分拣依据的类型
     * @param <T>     分拣的数据的类型
     */
    public static <K, T> void shuntData(K key, T data, Map<K, List<T>> dataMap) {
        Optional.ofNullable(key).ifPresent(value -> {
            if (dataMap.containsKey(value)) {
                dataMap.get(value).add(data);
            } else {
                List<T> tempList = new ArrayList<>();
                tempList.add(data);
                dataMap.put(value, tempList);
            }
        });
    }

    /**
     * 数据归类分拣
     *
     * @param key     分拣依据 即Map的key键
     * @param dataList    分拣的数据 即Map的value键集合的数据
     * @param dataMap 分拣的结果
     * @param <K>     分拣依据的类型
     * @param <T>     分拣的数据的类型
     */
    public static <K, T> void shuntData(K key, List<T> dataList, Map<K, List<T>> dataMap) {
        Optional.ofNullable(key).ifPresent(value -> {
            if (dataMap.containsKey(value)) {
                dataMap.get(value).addAll(dataList);
            } else {
                List<T> tempList = new ArrayList<>(dataList);
                dataMap.put(value, tempList);
            }
        });
    }

    /**
     * 数据空值归类分拣
     *
     * @param key       分拣依据
     * @param data      分拣的数据
     * @param falseList 不存在的list结果集
     * @param trueMap   存在的map结果集
     * @param <K>       分拣依据的类型
     * @param <T>       分拣的数据的类型
     */
    public static <K, T> void shuntNullData(K key, T data, List<T> falseList, Map<K, List<T>> trueMap) {
        Optional<K> optional = Optional.ofNullable(key);
        if (optional.isPresent()) {
            shuntData(key, data, trueMap);
        } else {
            falseList.add(data);
        }
    }

    /**
     * 数据空值分拣
     *
     * @param key       分拣依据
     * @param data      分拣的数据
     * @param falseList 不存在的list结果集
     * @param trueList  存在的list结果集
     * @param <K>       分拣依据的类型
     * @param <T>       分拣的数据的类型
     */
    public static <K, T> void shuntNullData(K key, T data, List<T> falseList, List<T> trueList) {
        Optional<K> optional = Optional.ofNullable(key);
        if (optional.isPresent()) {
            trueList.add(data);
        } else {
            falseList.add(data);
        }
    }

    /**
     * 数据对比分拣
     *
     * @param srcKey     对比值
     * @param targetKey  目标值
     * @param data       分拣数据
     * @param equalList  相等结果List集
     * @param unequalMap 不相等结果List集
     * @param <T>        分拣的数据的类型
     */
    public static <T> void shuntContrastData(Long srcKey, Long targetKey, T data, List<T> equalList, Map<Long, List<T>> unequalMap) {
        if (srcKey.equals(targetKey)) {
            equalList.add(data);
        } else {
            shuntData(targetKey, data, unequalMap);
        }
    }

    /**
     * 数据对比分拣
     *
     * @param srcKey      对比值
     * @param targetKey   目标值
     * @param data        分拣数据
     * @param equalList   相等结果List集
     * @param unequalList 不相等结果List集
     * @param <T>         分拣的数据的类型
     */
    public static <K, T> void shuntContrastData(K srcKey, K targetKey, T data, List<T> equalList, List<T> unequalList) {
        if (srcKey.equals(targetKey)) {
            equalList.add(data);
        } else {
            unequalList.add(data);
        }
    }

    /**
     * 数据对比分拣
     *
     * @param srcKey 对比值
     * @param targetKeyList 目标值集合
     * @param data 分拣数据
     * @param dataMap 分拣结果
     * @param <K> 对比值类型
     * @param <T> 分拣数据类型
     */
    public static <K, T> void shuntContainData(K srcKey, List<K> targetKeyList, T data, Map<K, List<T>> dataMap) {
        if (targetKeyList.contains(srcKey)) {
            shuntData(srcKey,data,dataMap);
        }
    }
}
