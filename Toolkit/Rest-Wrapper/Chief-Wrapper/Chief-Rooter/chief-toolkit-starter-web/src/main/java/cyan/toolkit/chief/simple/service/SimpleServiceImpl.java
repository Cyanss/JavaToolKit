package cyan.toolkit.chief.simple.service;

import cyan.toolkit.chief.ChiefInfoService;
import cyan.toolkit.chief.simple.SimpleEntity;
import cyan.toolkit.chief.simple.SimpleFilter;
import cyan.toolkit.chief.simple.SimpleModel;
import cyan.toolkit.rest.RestException;
import org.springframework.stereotype.Service;

/**
 * <p>SimpleServiceImpl</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:50 2020/9/24
 */
@Service
//@RestService(mapper = SimpleMapper.class)
public class SimpleServiceImpl extends ChiefInfoService<SimpleModel, SimpleEntity,SimpleFilter> implements SimpleService {

    @Override
    public String queryWhereSql(SimpleFilter filter) throws RestException {
        return filter.toTimeSql("time").addSorts("id").toSql();
    }
}
