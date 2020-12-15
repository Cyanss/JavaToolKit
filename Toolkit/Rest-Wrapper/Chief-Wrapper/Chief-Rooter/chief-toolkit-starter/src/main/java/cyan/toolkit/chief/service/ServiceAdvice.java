package cyan.toolkit.chief.service;

import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.rest.RestException;

/**
 * <p>ServiceHandler</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 11:22 2020/12/14
 */
public interface ServiceAdvice<I, F extends IdFilter<I>> {

    default void doServiceHandle() throws RestException {}

    default String queryWhereSql(F filter) throws RestException {
        return filter.toSql();
    }

    default String deleteWhereSql(F filter) throws RestException {
        return queryWhereSql(filter);
    }

    default Boolean[] loadArray(F filter) throws RestException {
        return filter.toLoadArray();
    }

}
