package cyan.toolkit.chief.service;

import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.IdModel;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * <p>NoIdArrayService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:42 2020/9/23
 */
public interface IdNonArrayService<I,M extends IdModel<I,M>, F extends IdFilter<I,F>> extends IdFilterService<I,M,F>{
    /**
     * 单个创建
     * @param model 对象信息
     * @return M 创建的对象
     * @throws RestException 模块异常
     */
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    M create(M model) throws RestException;

    /**
     * 单个更新
     * @param model 对象信息
     * @return M 创建的对象
     * @throws RestException 模块异常
     */
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    M update(M model) throws RestException;

    /**
     * 批量保存（存在更新,不存在新增）
     * @param modelList 对象信息集合
     * @return List<M> 更新的对象
     * @throws RestException 模块异常
     */
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    List<M> saveAll(Collection<M> modelList) throws RestException;

}
