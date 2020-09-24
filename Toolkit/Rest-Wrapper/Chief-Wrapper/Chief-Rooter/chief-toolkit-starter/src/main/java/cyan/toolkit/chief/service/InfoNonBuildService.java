package cyan.toolkit.chief.service;

import cyan.toolkit.chief.entity.InfoEntity;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.CheckUtils;
import cyan.toolkit.rice.model.InfoModel;
import org.springframework.beans.factory.InitializingBean;

/**
 * <p>InfoNonBuildServer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:35 2020/9/23
 */
public abstract class InfoNonBuildService<I,D,M extends InfoModel<I>, E extends InfoEntity<I,D>> extends IdNonBuildService<I,D,InfoModel<I>,InfoEntity<I,D>> implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws RestException {
        this.APPLY_CREATE_ACTUATOR = (InfoModel<I> model) -> {
            CheckUtils.checkNullObject(model.getName(), "name为空！");
            Boolean existByName = existByName(model.getName());
            CheckUtils.checkNameRepeat(existByName, model.getName());
        };
        this.APPLY_UPDATE_ACTUATOR = (InfoModel<I> model) -> {
            Boolean existByName = existByNameAndNotId(model.getName(),model.getId());
            CheckUtils.checkNameRepeat(existByName,model.getName());
        };
    }

    abstract protected Boolean existByName(String name) throws RestException;

    abstract protected Boolean existByNameAndNotId(String name, I id) throws RestException;
}
