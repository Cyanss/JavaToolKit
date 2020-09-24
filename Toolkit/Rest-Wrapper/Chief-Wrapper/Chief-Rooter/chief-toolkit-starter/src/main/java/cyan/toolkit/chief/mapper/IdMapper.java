package cyan.toolkit.chief.mapper;

import cyan.toolkit.chief.entity.IdEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <p>IdMapper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:30 2020/9/8
 */
public interface IdMapper<I,D,E extends IdEntity<I,D>> extends Mapper<E> {
    /**
     * 实体保存（存在更新不存在插入）
     * @param entity 实体
     * @return Integer SQL影响行数
     */
    Integer save(@Param("entity") E entity);

    /**
     * 批量保存（存在更新不存在插入）
     * @param entityList 实体集合
     * @return Integer SQL影响行数
     */
    Integer saveAll(@Param("entityList") List<E> entityList);

    /**
     * 实体单个删除
     * @param id 实体id集合
     * @return Integer SQL影响行数（成功为1）
     */
    Integer deleteById(@Param("id") I id);

    /**
     * 实体批量删除
     * @param idList 实体id集合
     * @return Integer SQL影响行数
     */
    Integer deleteAll(@Param("idList") List<I> idList);

    /**
     * 通过id查询实体
     * @param id 实体id
     * @return T 查询的数据
     */
    E findById(@Param("id") I id);

    /**
     * 实体批量查询
     * @param idList 实体集合
     * @return List<T> 查询的数据集合
     */
    List<E> findAll(@Param("idList") List<I> idList);

    /**
     * 通过filter查询条件查询
     * @param whereSql 过滤条件
     * @return List<T>
     */
    List<E> findAllByWhere(@Param("whereSql") String whereSql);
}
