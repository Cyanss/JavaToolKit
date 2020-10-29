package cyan.toolkit.chief.service;

import cyan.toolkit.chief.entity.InfoEntity;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.InfoModel;

/**
 * <p>InfoBuildService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:34 2020/9/23
 */
public abstract class InfoBuildService<I,D,M extends InfoModel<I,M>,E extends InfoEntity<I,D,E>> extends InfoNonBuildService<I,D,M,E>  {

    abstract protected void buildModel(M model,E entity, boolean... isLoadArray) throws RestException;
}
