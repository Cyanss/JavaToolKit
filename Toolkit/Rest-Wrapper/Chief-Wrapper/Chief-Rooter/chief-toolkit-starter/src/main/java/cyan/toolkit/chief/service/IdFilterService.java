package cyan.toolkit.chief.service;

import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.IdModel;

/**
 * <p>IdFilterService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:03 2020/10/13
 */
public interface IdFilterService<I,M extends IdModel<I,M>, F extends IdFilter<I,F>> extends IdDefaultService<I,M> {
    /**
     * 通过过滤器查询
     * @param filter 过滤器
     * @return GxPage<M> 查询的数据（分页）
     * @throws RestException 模块异常
     */
    RestPage<M> queryAllWithFilter(F filter) throws RestException;

    /**
     * 通过过滤器删除
     * @param filter 过滤器
     * @throws RestException 模块异常
     */
    void deleteAllWithFilter(F filter) throws RestException;
}
