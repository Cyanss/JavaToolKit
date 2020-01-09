package cyan.tool.kit.rice.flux.rice.flux;

import com.google.common.collect.Lists;
import cyan.tool.kit.rice.core.actuator.ConsumerActuator;
import cyan.tool.kit.rice.core.actuator.FunctionActuator;
import cyan.tool.kit.rice.core.rice.defaults.RestException;
import cyan.tool.kit.rice.flux.rice.util.natives.RiceEmptyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>GxPartitionUtils</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 17:50 2019/12/5
 */
public class RicePartitionFluxes {

    /**
     * queryAll的分段处理
     * @param idList id集合
     * @param maxSize 分段大小
     * @param function 执行器（伪函数指针）
     * @param <T> 注册实体类型
     * @return List<T> 实体集合
     */
    public static <K,T> List<T> query(List<K> idList, Integer maxSize, FunctionActuator<List<K>, List<T>> function) throws RestException {
        if (RiceEmptyUtils.isEmpty(idList)) {
            return Collections.emptyList();
        }
        List<T> entityList;
        if (idList.size() > maxSize) {
            entityList = new ArrayList<>();
            List<List<K>> partitionList = Lists.partition(idList, maxSize);
            for (List<K> partition : partitionList) {
                entityList.addAll(function.actuate(partition));
            }
        } else {
            entityList = function.actuate(idList);
        }
        return entityList;
    }

    /**
     * insertAll的分段处理
     * @param modelList 模型集合
     * @param maxSize 分段大小
     * @param function 执行器（伪函数指针）
     * @param <T> 模型类型
     * @return Integer 数量
     */
    public static <T> Boolean insert(List<T> modelList, Integer maxSize, FunctionActuator<List<T>,Integer> function) throws RestException {
        if (RiceEmptyUtils.isEmpty(modelList)) {
            return true;
        }
        Integer resultSize = 0;
        if (modelList.size() > maxSize) {
            List<List<T>> partitionList = Lists.partition(modelList, maxSize);
            for (List<T> partition : partitionList) {
                resultSize += function.actuate(partition);
            }
        } else {
            resultSize = function.actuate(modelList);
        }
        return resultSize == modelList.size();
    }


    /**
     * saveAll的分段处理
     * @param modelList 模型集合
     * @param maxSize 分段大小
     * @param function 执行器（伪函数指针）
     * @param <T> 模型类型
     * @return Boolean 是否成功
     */
    public static <T> Boolean save(List<T> modelList, Integer maxSize, FunctionActuator<List<T>, Integer> function) throws RestException {
        return insert(modelList,maxSize,function);
    }


    /**
     * updateAll的分段处理
     * @param modelList 模型集合
     * @param maxSize 分段大小
     * @param function 执行器（伪函数指针）
     * @param <T> 模型类型
     * @return Integer 数量
     */
    public static <T> Boolean update(List<T> modelList, Integer maxSize, FunctionActuator<List<T>, Integer> function) throws RestException {
        if (RiceEmptyUtils.isEmpty(modelList)) {
            return true;
        }
        /* 数据分段处理 */
        boolean comparer;
        int size = modelList.size();
        if (size > maxSize) {
            List<List<T>> partitionList = Lists.partition(modelList, maxSize);
            Integer resultSize = 0;
            for (List<T> partition : partitionList) {
                resultSize += function.actuate(partition);
            }
            comparer = resultSize == partitionList.size();
        } else {
            Integer result = function.actuate(modelList);
            comparer = result > 0;
        }
        return comparer;
    }





    /**
     * deleteAll的分段处理
     * @param idList id集合
     * @param maxSize 分段大小
     * @param consumer 执行器（伪函数指针）
     * @throws RestException SDM模块异常
     */
    public static <K> void delete(List<K> idList, Integer maxSize, ConsumerActuator<List<K>> consumer) throws RestException {
        if (RiceEmptyUtils.isEmpty(idList)) {
            return;
        }
        if (idList.size() > maxSize) {
            List<List<K>> partitionList = Lists.partition(idList, maxSize);
            for (List<K> partition : partitionList) {
                consumer.actuate(partition);
            }
        } else {
            consumer.actuate(idList);
        }
    }


}
