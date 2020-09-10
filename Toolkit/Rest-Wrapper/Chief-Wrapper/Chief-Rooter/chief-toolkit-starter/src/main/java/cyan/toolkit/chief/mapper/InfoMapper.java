package cyan.toolkit.chief.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>InfoMapper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:36 2020/9/8
 */
public interface InfoMapper<T> extends IdMapper<T> {
    /**
     * 根据名称判断是否存在
     * @param name 对象名称
     * @return List<T> 查询的数据集合
     */
    List<T> findByName(@Param("name") String name);

    /**
     * 根据id和名称判断是否存在
     * @param name 对象名称
     * @param id 对象id
     * @return List<T> 查询的数据集合
     */
    List<T> findByNameAndNotId(@Param("name") String name, @Param("id") Long id);
}
