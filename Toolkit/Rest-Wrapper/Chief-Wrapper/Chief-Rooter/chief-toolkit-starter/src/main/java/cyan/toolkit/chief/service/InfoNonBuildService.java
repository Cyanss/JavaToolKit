package cyan.toolkit.chief.service;

import cyan.toolkit.chief.entity.InfoEntity;
import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.chief.mapper.InfoMapper;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.CheckUtils;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rice.model.InfoModel;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * <p>InfoNonBuildServer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:35 2020/9/23
 */
public abstract class InfoNonBuildService<I,D,M extends InfoModel<I,M>, E extends InfoEntity<I,D,E>, F extends IdFilter<I,F>> extends IdNonBuildService<I,D,M,E,F> implements ActuatorService {

    protected InfoMapper<E,I,D,? extends InfoMapper<E,I,D,?>> infoMapper;

    @SuppressWarnings(value = "unchecked")
    @Override
    public void applyActuator() {
        this.createActuator = (@NonNull M model) -> {
            CheckUtils.checkNullObject(model.getName(), "name is null！");
            Boolean existByName = existByName(model.getName());
            CheckUtils.checkNameRepeat(existByName, model.getName());
        };
        this.updateActuator = (@NonNull M model) -> {
            Boolean existByName = existByNameAndNotId(model.getName(),model.getId());
            CheckUtils.checkNameRepeat(existByName,model.getName());
        };
        if (super.consumerMapper instanceof InfoMapper) {
            this.infoMapper = (InfoMapper) super.consumerMapper;
        }
    }

    protected Boolean existByName(String name) throws RestException {
        if (GeneralUtils.isEmpty(name)) {
            return false;
        }
        List<E> entityList = infoMapper.findByName(name);
        return GeneralUtils.isNotEmpty(entityList);
    }


    protected Boolean existByNameAndNotId(String name, I id) throws RestException {
        if (GeneralUtils.isEmpty(name)) {
            return false;
        }
        if (GeneralUtils.isEmpty(id)) {
            return existByName(name);
        }
        List<E> entityList = infoMapper.findByNameAndNotId(name, id);
        return GeneralUtils.isNotEmpty(entityList);
    }
}
