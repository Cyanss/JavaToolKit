package cyan.toolkit.chief.helper;

import cyan.toolkit.chief.entity.IdEntity;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.actuator.BiFunctionActuator;
import cyan.toolkit.rest.actuator.FunctionActuator;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rice.model.IdModel;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>MEConvertHelper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:00 2020/9/23
 */
public class MEBuilderHelper {

    public static<I,M extends IdModel<I>, E extends IdEntity<I,D>,D> List<E> entityList(Collection<M> modelList, FunctionActuator<M,Boolean> function, BiFunctionActuator<M,Boolean,E> biFunction) throws RestException {
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

    public static<I,M extends IdModel<I>, E extends IdEntity<I,D>,D> List<M> modelList(Collection<E> entityList,FunctionActuator<E,M> function) throws RestException {
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
