package cyan.toolkit.chief;

import cyan.toolkit.chief.entity.InfoEntity;

import java.util.Date;

/**
 * <p>RestEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:33 2020/11/3
 */
public abstract class ChiefEntity<M extends ChiefModel<?>> extends InfoEntity<Long, Date> {

    public ChiefEntity() {
    }

    public ChiefEntity(Long id) {
        super(id);
    }

    public ChiefEntity(Long id, String name) {
        super(id, name);
    }

    public ChiefEntity(Builder<Long, Date> builder) {
        super(builder);
    }

    abstract public M toModel();

}
