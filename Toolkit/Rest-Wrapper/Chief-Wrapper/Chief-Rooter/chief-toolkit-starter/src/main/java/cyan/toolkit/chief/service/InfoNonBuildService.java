package cyan.toolkit.chief.service;

import cyan.toolkit.chief.entity.InfoEntity;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.CheckUtils;
import cyan.toolkit.rice.model.InfoModel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.NonNull;

/**
 * <p>InfoNonBuildServer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:35 2020/9/23
 */
public abstract class InfoNonBuildService<I,D,M extends InfoModel<I,M>, E extends InfoEntity<I,D,E>> extends IdNonBuildService<I,D,M,E> implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws RestException {
        this.APPLY_CREATE_ACTUATOR = (@NonNull M model) -> {
            CheckUtils.checkNullObject(model.getName(), "name为空！");
            Boolean existByName = existByName(model.getName());
            CheckUtils.checkNameRepeat(existByName, model.getName());
        };
        this.APPLY_UPDATE_ACTUATOR = (@NonNull M model) -> {
            Boolean existByName = existByNameAndNotId(model.getName(),model.getId());
            CheckUtils.checkNameRepeat(existByName,model.getName());
        };
    }

    abstract protected Boolean existByName(String name) throws RestException;

    abstract protected Boolean existByNameAndNotId(String name, I id) throws RestException;
}
