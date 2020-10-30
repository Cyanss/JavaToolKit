package cyan.toolkit.chief.simple.service;

import cyan.toolkit.chief.RestService;
import cyan.toolkit.chief.service.InfoNonBuildService;
import cyan.toolkit.chief.simple.SimpleEntity;
import cyan.toolkit.chief.simple.SimpleFilter;
import cyan.toolkit.chief.simple.SimpleModel;
import cyan.toolkit.chief.simple.mapper.SimpleMapper;

import java.util.Date;

/**
 * <p>SimpleServiceImpl</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:50 2020/9/24
 */
//@Service
@RestService(mapper = SimpleMapper.class)
public class SimpleServiceImpl extends InfoNonBuildService<Long, Date, SimpleModel, SimpleEntity,SimpleFilter> implements SimpleService {
    @Override
    protected void applyServiceActuator() {
        super.entityBiActuator = SimpleEntity::toEntity;
        super.modelActuator = SimpleEntity::toModel;
    }
    
}
