package cyan.toolkit.widget.service;

import cyan.toolkit.chief.filter.PageFilter;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.widget.model.RouteModel;

import java.util.Collection;
import java.util.List;

/**
 * <p>RouteService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:32 2021/6/8
 */
public interface RouteService {
    /**
     * 单个保存
     * @param model 对象信息
     * @return M 创建的对象
     * @throws RestException 模块异常
     */
    RouteModel save(RouteModel model) throws RestException;

    /**
     * 批量保存（存在更新,不存在新增）
     * @param modelList 对象信息集合
     * @return List<M> 更新的对象
     * @throws RestException 模块异常
     */
    List<RouteModel> saveAll(Collection<RouteModel> modelList) throws RestException;

    /**
     * 通过name集合批量删除
     * @param nameList 对象的name集合
     * @throws RestException 模块异常
     */
    void deleteAll(Collection<String> nameList) throws RestException;

    /**
     * 通过name单个删除
     * @param name 对象的name
     * @throws RestException 模块异常
     */
    void deleteById(String name) throws RestException;

    /**
     * 通过name集合查询所有
     * @param nameList 对象name集合
     * @return List<M> 查询的数据
     * @throws RestException 模块异常
     */
    List<RouteModel> queryAll(Collection<String> nameList) throws RestException;

    /**
     * 通过name集合查询单个
     * @param name 对象name
     * @return M 查询的对象
     * @throws RestException 模块异常
     */
    RouteModel queryById(String name) throws RestException;

    /**
     * 通过过滤器查询
     * @param filter 过滤器
     * @return RestPage<M> 查询的数据（分页）
     * @throws RestException 模块异常
     */
    RestPage<RouteModel> queryAllWithFilter(PageFilter filter) throws RestException;

    /**
     * 查询所有新增的路由
     * @return List<RouteModel> 新增的路由列表
     * @throws RestException 模块异常
     */
    List<RouteModel> queryAllNew() throws RestException;

    /**
     * 更新所有新增的路由状态
     * @return Integer 更新的路由数量
     * @throws RestException 模块异常
     */
    Integer updateAllNew() throws RestException;
}
