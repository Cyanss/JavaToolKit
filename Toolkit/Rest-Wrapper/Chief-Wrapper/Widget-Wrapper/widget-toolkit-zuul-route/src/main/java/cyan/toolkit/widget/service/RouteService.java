package cyan.toolkit.widget.service;

import cyan.toolkit.chief.filter.PageFilter;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.widget.model.WidgetRoute;

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
     */
    WidgetRoute save(WidgetRoute model);

    /**
     * 批量保存（存在更新,不存在新增）
     * @param modelList 对象信息集合
     * @return List<M> 更新的对象
     */
    List<WidgetRoute> saveAll(Collection<WidgetRoute> modelList);

    /**
     * 通过name集合批量删除
     * @param nameList 对象的name集合
     */
    void deleteAll(Collection<String> nameList);

    /**
     * 通过name单个删除
     * @param name 对象的name
     */
    void deleteById(String name);

    /**
     * 通过name集合查询所有
     * @param nameList 对象name集合
     * @return List<M> 查询的数据
     */
    List<WidgetRoute> queryAll(Collection<String> nameList);

    /**
     * 通过name集合查询单个
     * @param name 对象name
     * @return M 查询的对象
     */
    WidgetRoute queryById(String name);

    /**
     * 通过过滤器查询
     * @param filter 过滤器
     * @return RestPage<M> 查询的数据（分页）
     */
    RestPage<WidgetRoute> queryAllWithFilter(PageFilter filter);

    /**
     * 查询所有新增的路由
     * @return List<RouteModel> 新增的路由列表
     */
    List<WidgetRoute> queryAllNew();

    /**
     * 更新所有新增的路由状态
     * @return Integer 更新的路由数量
     */
    Integer updateAllNew();
}
