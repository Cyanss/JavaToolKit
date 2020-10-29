package cyan.toolkit.chief.service;

import cyan.toolkit.chief.entity.IdEntity;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.actuator.ConsumerActuator;
import cyan.toolkit.rest.error.data.DataQueryException;
import cyan.toolkit.rest.util.common.CheckUtils;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rice.clazz.RestClazzHelper;
import cyan.toolkit.rice.model.IdModel;
import org.springframework.lang.NonNull;

/**
 * <p>NoIdBuildService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:47 2020/9/23
 */
public abstract class IdNonBuildService<I,D,M extends IdModel<I,M>, E extends IdEntity<I,D,E>> implements IdCheckService<I,M> {

    protected ConsumerActuator<M> APPLY_CREATE_ACTUATOR;

    protected ConsumerActuator<M> APPLY_UPDATE_ACTUATOR;

    private final ConsumerActuator<M> DEFAULT_CREATE_ACTUATOR = (@NonNull M model) -> {
        model.setId(RestClazzHelper.generate(model));
        if (APPLY_CREATE_ACTUATOR != null) {
            APPLY_CREATE_ACTUATOR.actuate(model);
        }
        afterCheck(model);
    };

    private final ConsumerActuator<M> DEFAULT_UPDATE_ACTUATOR = (@NonNull M model) -> {
        boolean exist = existById(model.getId());
        String message = "查询数据不存在，id: " + model.getId();
        CheckUtils.checkNonExistResource(exist, message, "id", DataQueryException::new);
        if (APPLY_UPDATE_ACTUATOR != null) {
            APPLY_CREATE_ACTUATOR.actuate(model);
        }
        afterCheck(model);
    };


    protected boolean beforeCreate(@NonNull M model) throws RestException {
        if (GeneralUtils.isEmpty(model.getId())) {
            DEFAULT_CREATE_ACTUATOR.actuate(model);
            return true;
        }
        return false;
    }

    protected boolean beforeUpdate(@NonNull M model) throws RestException {
        CheckUtils.checkNullId(model.getId());
        DEFAULT_UPDATE_ACTUATOR.actuate(model);
        return false;
    }

    protected boolean beforeSave(@NonNull M model) throws RestException {
        if (GeneralUtils.isEmpty(model.getId())) {
            DEFAULT_CREATE_ACTUATOR.actuate(model);
            return true;
        } else {
            DEFAULT_UPDATE_ACTUATOR.actuate(model);
            return false;
        }
    }

}
