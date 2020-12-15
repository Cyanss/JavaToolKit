package cyan.toolkit.chief.service;

import cyan.toolkit.chief.entity.IdEntity;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.IdModel;

/**
 * <p>BuilderAdvice</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 15:11 2020/12/14
 */
public interface BuilderAdvice <I,D,M extends IdModel<I>, E extends IdEntity<I,D>> {

    @SuppressWarnings(value = "unchecked")
    default void buildEntity(E entity, M model, I... idArray) throws RestException {}

    default void buildModel(M model, E entity, Boolean... isLoadArray) throws RestException {}

}
