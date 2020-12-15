package cyan.toolkit.chief.service;

import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.IdModel;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * <p>SaveService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:42 2020/9/23
 */
public interface SaveService<I,M extends IdModel<I>> extends QueryService<I,M> {

    /**
     * 单个保存
     * @param model 对象信息
     * @return M 创建的对象
     * @throws RestException 模块异常
     */
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    @SuppressWarnings(value = "unchecked")
    M save(M model, I... idArray) throws RestException;

    /**
     * 批量保存（存在更新,不存在新增）
     * @param modelList 对象信息集合
     * @return List<M> 更新的对象
     * @throws RestException 模块异常
     */
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    @SuppressWarnings(value = "unchecked")
    List<M> saveAll(Collection<M> modelList, I... idArray) throws RestException;

}
