package cyan.toolkit.rice;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.error.natives.UnsupportedErrorException;
import cyan.toolkit.rice.model.IdModel;

/**
 * <p>RestEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:27 2021/6/28
 */
public interface RestEntity<I,M extends IdModel<I>> {

    default M toModel() throws RestException {
        throw new UnsupportedErrorException("the method has not implemented, 'toModel()' ");
    }

}
