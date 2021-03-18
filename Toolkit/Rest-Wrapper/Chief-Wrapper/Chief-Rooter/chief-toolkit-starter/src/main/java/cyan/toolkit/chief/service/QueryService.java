package cyan.toolkit.chief.service;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.IdModel;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * <p>QueryService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:58 2020/10/13
 */
public interface QueryService<I,M extends IdModel<I>>  extends DeleteService<I> {

    /**
     * 通过id集合查询所有
     * @param idList 对象id集合
     * @param isLoadArray 是否只加载基本信息
     * @return List<M> 查询的数据
     * @throws RestException 模块异常
     */
    List<M> queryAll(Collection<I> idList, Boolean... isLoadArray) throws RestException;

    /**
     * 通过id集合查询单个
     * @param id 对象id
     * @param isLoadArray 是否只加载基本信息
     * @return M 查询的对象
     * @throws RestException 模块异常
     */
    M queryById(I id, Boolean... isLoadArray) throws RestException;

}
