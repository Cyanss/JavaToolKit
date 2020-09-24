package cyan.toolkit.chief.service;

import cyan.toolkit.chief.entity.IdEntity;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.actuator.ConsumerActuator;
import cyan.toolkit.rest.error.data.DataQueryException;
import cyan.toolkit.rest.util.common.CheckUtils;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rice.helper.RestClazzUtils;
import cyan.toolkit.rice.model.IdModel;
import cyan.toolkit.rice.model.InfoModel;

/**
 * <p>NoIdBuildService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:47 2020/9/23
 */
public abstract class IdNonBuildService<I,D,M extends IdModel<I>, E extends IdEntity<I,D>> {

    protected ConsumerActuator<InfoModel<I>> APPLY_CREATE_ACTUATOR;

    protected ConsumerActuator<InfoModel<I>> APPLY_UPDATE_ACTUATOR;

    private final ConsumerActuator<IdModel<I>> DEFAULT_CREATE_ACTUATOR = (IdModel<I> model) -> {
        model.setId(RestClazzUtils.generate(model));
        if (APPLY_CREATE_ACTUATOR != null && model instanceof InfoModel) {
            InfoModel<I> infoModel = (InfoModel<I>) model;
            APPLY_CREATE_ACTUATOR.actuate(infoModel);
        }
        afterCheck(model);
    };

    private final ConsumerActuator<IdModel<I>> DEFAULT_UPDATE_ACTUATOR = (IdModel<I> model) -> {
        boolean exist = existById(model.getId());
        String message = "查询数据不存在，id: " + model.getId();
        CheckUtils.checkNonExistResource(exist, message, "id", DataQueryException::new);
        if (APPLY_UPDATE_ACTUATOR != null&& model instanceof InfoModel) {
            InfoModel<I> infoModel = (InfoModel<I>) model;
            APPLY_CREATE_ACTUATOR.actuate(infoModel);
        }
        afterCheck(model);
    };


    protected boolean beforeCreate(IdModel<I> model) throws RestException {
        if (GeneralUtils.isEmpty(model.getId())) {
            DEFAULT_CREATE_ACTUATOR.actuate(model);
            return true;
        }
        return false;
    }

    protected boolean beforeUpdate(IdModel<I> model) throws RestException {
        CheckUtils.checkNullId(model.getId());
        DEFAULT_UPDATE_ACTUATOR.actuate(model);
        return false;
    }

    protected boolean beforeSave(IdModel<I> model) throws RestException {
        if (GeneralUtils.isEmpty(model.getId())) {
            DEFAULT_CREATE_ACTUATOR.actuate(model);
            return true;
        } else {
            DEFAULT_UPDATE_ACTUATOR.actuate(model);
            return false;
        }
    }

    abstract protected void afterCheck(IdModel<I> model) throws RestException;

    abstract protected boolean existById(I id) throws RestException;
}
