package cyan.toolkit.rice;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.error.natives.UnsupportedErrorException;
import cyan.toolkit.rice.entity.IdEntity;

/**
 * <p>RestModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:15 2021/6/28
 */
public interface RestModel<I,E extends IdEntity<I>> {

    default E toEntity() throws RestException {
        throw new UnsupportedErrorException("the method has not implemented, 'toEntity()' ");
    }

    default E toEntity(Long... idArray) throws RestException {
        throw new UnsupportedErrorException("the method has not implemented, 'toEntity(Long...)' ");
    }

}
