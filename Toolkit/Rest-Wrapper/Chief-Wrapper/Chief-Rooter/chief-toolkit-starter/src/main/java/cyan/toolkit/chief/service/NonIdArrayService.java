package cyan.toolkit.chief.service;

import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.IdModel;

import java.util.List;

/**
 * <p>NoIdArrayService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:42 2020/9/23
 */
public interface NonIdArrayService<I,M extends IdModel<I>, F extends IdFilter<I>> {
    /**
     * 单个创建
     * @param model 对象信息
     * @return M 创建的对象
     * @throws RestException 模块异常
     */
    M create(M model) throws RestException;

    /**
     * 单个更新
     * @param model 对象信息
     * @return M 创建的对象
     * @throws RestException 模块异常
     */
    M update(M model) throws RestException;

    /**
     * 批量保存（存在更新,不存在新增）
     * @param modelList 对象信息集合
     * @return List<M> 更新的对象
     * @throws RestException 模块异常
     */
    List<M> saveAll(List<M> modelList) throws RestException;

    /**
     * 通过id集合批量删除
     * @param idList 对象的id集合
     * @throws RestException 模块异常
     */
    void deleteAll(List<I> idList) throws RestException;

    /**
     * 通过id单个删除
     * @param id 对象的id
     * @throws RestException 模块异常
     */
    void deleteById(I id) throws RestException;

    /**
     * 通过id集合查询所有
     * @param idList 对象id集合
     * @param isLoadArray 是否只加载基本信息
     * @return List<M> 查询的数据
     * @throws RestException 模块异常
     */
    List<M> queryAll(List<I> idList, boolean... isLoadArray) throws RestException;

    /**
     * 通过id集合查询单个
     * @param id 对象id
     * @param isLoadArray 是否只加载基本信息
     * @return M 查询的对象
     * @throws RestException 模块异常
     */
    M queryById(I id, boolean... isLoadArray) throws RestException;

    /**
     * 通过过滤器查询
     * @param filter 过滤器
     * @return GxPage<M> 查询的数据（分页）
     * @throws RestException 模块异常
     */
    RestPage<M> queryAllWithFilter(F filter) throws RestException;
}
