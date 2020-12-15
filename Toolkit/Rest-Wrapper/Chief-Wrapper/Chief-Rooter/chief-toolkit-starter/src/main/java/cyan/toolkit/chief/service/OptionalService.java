package cyan.toolkit.chief.service;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.model.IdModel;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * <p>ModelCheckService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:04 2020/9/24
 */
public interface OptionalService<I,M extends IdModel<I>> extends QueryService<I,M> {

    default void optional(@NonNull IdModel<I> model) throws RestException {}

    default boolean existById(I id) throws RestException {
        return Optional.ofNullable(this.queryById(id)).isPresent();
    }
}
