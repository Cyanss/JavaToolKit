package cyan.toolkit.chief.service;

import cyan.toolkit.chief.entity.InfoEntity;
import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.chief.mapper.IdMapper;
import cyan.toolkit.chief.mapper.InfoMapper;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.actuator.ConsumerActuator;
import cyan.toolkit.rest.helper.OptionalHelper;
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
public abstract class InfoService<I,D,M extends InfoModel<I>, E extends InfoEntity<I,D>, F extends IdFilter<I>> extends SupperService<I,D,M,E,F> {

    protected InfoMapper<E,I,D> consumerMapper;

    @SuppressWarnings(value = "unchecked")
    @Override
    public void doServiceHandle() {
        this.createActuator = (@NonNull M model) -> {
            OptionalHelper.fieldable(model.getName(), "name is null！");
            Boolean existByName = existByName(model.getName());
            OptionalHelper.nameRepeat(existByName, model.getName());
        };
        this.updateActuator = (@NonNull M model) -> {
            Boolean existByName = existByNameAndNotId(model.getName(),model.getId());
            OptionalHelper.nameRepeat(existByName,model.getName());
        };
        if (super.supperMapper instanceof InfoMapper) {
            this.consumerMapper = (InfoMapper) super.supperMapper;
        }
    }

    protected Boolean existByName(String name) throws RestException {
        if (GeneralUtils.isEmpty(name)) {
            return false;
        }
        List<E> entityList = consumerMapper.findByName(name);
        return GeneralUtils.isNotEmpty(entityList);
    }


    protected Boolean existByNameAndNotId(String name, I id) throws RestException {
        if (GeneralUtils.isEmpty(name)) {
            return false;
        }
        if (GeneralUtils.isEmpty(id)) {
            return existByName(name);
        }
        List<E> entityList = consumerMapper.findByNameAndNotId(name, id);
        return GeneralUtils.isNotEmpty(entityList);
    }
}
