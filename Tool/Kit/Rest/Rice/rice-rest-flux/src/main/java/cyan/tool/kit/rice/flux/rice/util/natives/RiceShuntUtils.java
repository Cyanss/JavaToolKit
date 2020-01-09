package cyan.tool.kit.rice.flux.rice.util.natives;

import java.util.*;

/**
 * <p>ShuntUtils</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:26 2019/11/21
 */
public class RiceShuntUtils {

    public static <T> void shunt(Boolean key, T data, List<T> falseList, List<T> trueList) {
        if (key) {
            trueList.add(data);
        } else {
            falseList.add(data);
        }
    }

    public static <K, T> void shunt(K key, T data, Map<K, List<T>> dataMap) {
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

    public static <K, T> void shunt(K key, List<T> dataList, Map<K, List<T>> dataMap) {
        Optional.ofNullable(key).ifPresent(value -> {
            if (dataMap.containsKey(value)) {
                dataMap.get(value).addAll(dataList);
            } else {
                List<T> tempList = new ArrayList<>(dataList);
                dataMap.put(value, tempList);
            }
        });
    }

    public static <K, T> void shuntNull(K key, T data, List<T> falseList, Map<K, List<T>> trueMap) {
        Optional<K> optional = Optional.ofNullable(key);
        if (optional.isPresent()) {
            shunt(key, data, trueMap);
        } else {
            falseList.add(data);
        }
    }

    public static <K, T> void shuntNull(K key, T data, List<T> falseList, List<T> trueList) {
        Optional<K> optional = Optional.ofNullable(key);
        if (optional.isPresent()) {
            trueList.add(data);
        } else {
            falseList.add(data);
        }
    }

    public static <T> void shuntContrast(Long srcKey, Long targetKey, T data, List<T> equalList, Map<Long, List<T>> unequalMap) {
        if (srcKey.equals(targetKey)) {
            equalList.add(data);
        } else {
            shunt(targetKey, data, unequalMap);
        }
    }

    public static <K, T> void shuntContrast(K srcKey, K targetKey, T data, List<T> equalList, List<T> unequalList) {
        if (srcKey.equals(targetKey)) {
            equalList.add(data);
        } else {
            unequalList.add(data);
        }
    }

    public static <K, T> void shuntContain(K srcKey, List<K> targetKeyList, T data, Map<K, List<T>> dataMap) {
        if (targetKeyList.contains(srcKey)) {
            shunt(srcKey,data,dataMap);
        }
    }
}
