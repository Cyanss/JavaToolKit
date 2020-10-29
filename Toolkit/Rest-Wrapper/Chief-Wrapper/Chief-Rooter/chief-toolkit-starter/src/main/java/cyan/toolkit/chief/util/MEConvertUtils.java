package cyan.toolkit.chief.util;

import cyan.toolkit.chief.entity.IdEntity;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.actuator.BiConsumerActuator;
import cyan.toolkit.rest.actuator.BiFunctionActuator;
import cyan.toolkit.rest.actuator.FunctionActuator;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rice.model.IdModel;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>MEConvertUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:00 2020/9/23
 */
public class MEConvertUtils {
    
    public static<I,D,M extends IdModel<I,M>, E extends IdEntity<I,D,E>> List<E> createEntityList(Collection<M> modelList, FunctionActuator<M,Boolean> function, BiFunctionActuator<M,Boolean,E> biFunction) throws RestException {
        if (GeneralUtils.isEmpty(modelList)) {
            return Collections.emptyList();
        }
        List<M> collect = modelList.stream().filter(Objects::nonNull).collect(Collectors.toList());
        List<E> entityList = new ArrayList<>();
        for (M model : collect) {
            if (model != null) {
                Boolean isInsert = function.actuate(model);
                entityList.add(biFunction.actuate(model,isInsert));
            }
        }
        return entityList;
    }

    public static<I,D,M extends IdModel<I,M>, E extends IdEntity<I,D,E>> List<M> createModelList(Collection<E> entityList, FunctionActuator<E,M> function, BiConsumerActuator<M,E> biConsumer) throws RestException {
        if (GeneralUtils.isEmpty(entityList)) {
            return Collections.emptyList();
        }
        List<M> modelList = new ArrayList<>();
        for (E entity : entityList) {
            if (entity != null) {
                M model = function.actuate(entity);
                biConsumer.actuate(model,entity);
                modelList.add(model);
            }
        }
        return modelList;
    }

    public static<I,D,M extends IdModel<I,M>, E extends IdEntity<I,D,E>> List<M> createModelList(Collection<E> entityList,FunctionActuator<E,M> function) throws RestException {
        if (GeneralUtils.isEmpty(entityList)) {
            return Collections.emptyList();
        }
        List<M> modelList = new ArrayList<>();
        for (E entity : entityList) {
            if (entity != null) {
                modelList.add(function.actuate(entity));
            }
        }
        return modelList;
    }
    
}
