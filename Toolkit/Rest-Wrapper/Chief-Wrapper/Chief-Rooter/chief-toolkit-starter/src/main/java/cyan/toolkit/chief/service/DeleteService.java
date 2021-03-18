package cyan.toolkit.chief.service;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.IdModel;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * <p>DeleteService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:58 2020/10/13
 */
public interface DeleteService<I> {
    /**
     * 通过id集合批量删除
     * @param idList 对象的id集合
     * @throws RestException 模块异常
     */
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    void deleteAll(Collection<I> idList) throws RestException;

    /**
     * 通过id单个删除
     * @param id 对象的id
     * @throws RestException 模块异常
     */
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    void deleteById(I id) throws RestException;
}
