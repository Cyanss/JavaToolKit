package cyan.toolkit.chief;


import cyan.toolkit.rice.RestEntity;
import cyan.toolkit.rice.entity.IdEntity;

/**
 * <p>RestEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:33 2020/11/3
 */
public abstract class ChiefIdEntity<E extends ChiefIdEntity<E,M>,M extends ChiefIdModel<M,E>> extends IdEntity<Long> implements RestEntity<Long,M> {

    public ChiefIdEntity() {
    }

    public ChiefIdEntity(Long id) {
        super(id);
    }

    public ChiefIdEntity(Builder builder) {
        super(builder);
    }

    public static abstract class Builder extends IdEntity.Builder<Long> {

        public Builder() {
        }

        public ChiefIdEntity.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public abstract ChiefIdEntity<?,?> build();
    }
}
