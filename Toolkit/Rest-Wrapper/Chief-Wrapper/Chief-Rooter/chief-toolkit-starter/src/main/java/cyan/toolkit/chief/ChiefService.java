package cyan.toolkit.chief;

import cyan.toolkit.chief.service.BuilderAdvice;
import cyan.toolkit.chief.service.InfoService;

import java.util.Date;

/**
 * <p>RestService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:00 2020/11/3
 */
public abstract class ChiefService<M extends ChiefModel,E extends ChiefEntity,F extends ChiefFilter> extends InfoService<Long, Date, M, E, F> implements BuilderAdvice<Long,Date,M, E> {

    @Override
    protected E createEntity(M model, Boolean isInsert) {
        return model.toEntity(isInsert);
    }

    @Override
    protected M createModel(E entity) {
        return entity.toModel();
    }
}
