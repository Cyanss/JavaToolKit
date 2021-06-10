package cyan.toolkit.widget.service;

import cyan.toolkit.chief.filter.PageFilter;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.rest.RestException;

import java.util.Collection;
import java.util.List;

/**
 * <p>WhiteService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:13 2021/6/8
 */
public interface WhiteService {

    /**
     * 单个保存
     * @param model 对象信息
     * @return M 创建的对象
     */
    String save(String model);

    /**
     * 批量保存（存在更新,不存在新增）
     * @param modelList 对象信息集合
     * @return List<M> 更新的对象
     */
    List<String> saveAll(Collection<String> modelList);
    
    /**
     * 通过path集合批量删除
     * @param pathList 对象的path集合
     */
    void deleteAll(Collection<String> pathList);

    /**
     * 通过path单个删除
     * @param path 对象的path
     */
    void deleteById(String path);

    /**
     * 通过path集合查询所有
     * @param pathList 对象path集合
     * @return List<M> 查询的数据
     */
    List<String> queryAll(Collection<String> pathList);

    /**
     * 通过path集合查询单个
     * @param path 对象path
     * @return M 查询的对象
     */
    String queryById(String path);

    /**
     * 通过过滤器查询
     * @param filter 过滤器
     * @return RestPage<M> 查询的数据（分页）
     */
    RestPage<String> queryAllWithFilter(PageFilter filter);

    /**
     * 查询所有新增的白名单
     * @return List<String> 新增的白名单列表
     */
    List<String> queryAllNew();

    /**
     * 更新所有新增的白名单状态
     * @return Integer 更新的白名单数量
     */
    Integer updateAllNew();

}
