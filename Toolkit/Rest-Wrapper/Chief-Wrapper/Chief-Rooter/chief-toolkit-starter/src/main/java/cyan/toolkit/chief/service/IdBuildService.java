package cyan.toolkit.chief.service;

import cyan.toolkit.chief.entity.IdEntity;
import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.IdModel;

/**
 * <p>IdBuildService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:45 2020/9/23
 */
public abstract class IdBuildService<I,D,M extends IdModel<I,M>, E extends IdEntity<I,D,E>,F extends IdFilter<I,F>> extends IdNonBuildService<I,D,M,E,F> {

    abstract protected void buildModel(M model, E entity, boolean... isLoadArray) throws RestException;

}
