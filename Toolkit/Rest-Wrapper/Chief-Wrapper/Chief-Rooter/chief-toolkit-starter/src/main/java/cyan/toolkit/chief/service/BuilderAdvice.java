package cyan.toolkit.chief.service;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.entity.IdEntity;
import cyan.toolkit.rice.model.IdModel;

import java.util.Collection;
import java.util.List;

/**
 * <p>BuilderAdvice</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 15:11 2020/12/14
 */
public interface BuilderAdvice <I,M extends IdModel<I>, E extends IdEntity<I>> {

    @SuppressWarnings(value = "unchecked")
    default void buildEntity(M model, E entity, I... idArray) throws RestException {}

    @SuppressWarnings(value = "unchecked")
    default void buildEntityList(Collection<M> modelList, List<E> entityList, I... idArray) throws RestException {}

    default void buildModel(E entity, M model, Boolean... isLoadArray) throws RestException {}

    default void buildModelList(Collection<E> entityList, List<M> modelList, Boolean... isLoadArray) throws RestException {}
}
