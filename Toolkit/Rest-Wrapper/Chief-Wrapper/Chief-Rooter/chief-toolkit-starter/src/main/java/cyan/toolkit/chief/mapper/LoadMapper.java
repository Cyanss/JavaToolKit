package cyan.toolkit.chief.mapper;

import cyan.toolkit.rice.entity.IdEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * <p>IdLoadMapper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:36 2021/6/30
 */
public interface LoadMapper<E extends IdEntity<I>,I> {
    /**
     * 通过id查询实体
     * @param id 实体id
     * @param loadParams 查询加载参数
     * @return T 查询的数据
     */
    E findById(@Param("id") I id, @Param("loadParams") Boolean... loadParams);

    /**
     * 实体批量查询
     * @param idList 实体集合
     * @param loadParams 查询加载参数
     * @return List<T> 查询的数据集合
     */
    List<E> findAll(@Param("idList") Collection<I> idList, @Param("loadParams") Boolean... loadParams);

    /**
     * 通过filter查询条件查询
     * @param whereSql 过滤条件
     * @param loadParams 查询加载参数
     * @return List<T>
     */
    List<E> findAllByWhere(@Param("whereSql") String whereSql, @Param("loadParams") Boolean... loadParams);
}
