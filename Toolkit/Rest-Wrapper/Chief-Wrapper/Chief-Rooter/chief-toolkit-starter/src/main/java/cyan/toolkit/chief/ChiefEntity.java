package cyan.toolkit.chief;


import cyan.toolkit.rice.RestEntity;
import cyan.toolkit.rice.entity.InfoEntity;

/**
 * <p>RestEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:33 2020/11/3
 */
public abstract class ChiefEntity<E extends ChiefEntity<E,M>,M extends ChiefModel<M,E>> extends InfoEntity<Long> implements RestEntity<Long,M> {

    public ChiefEntity() {
    }

    public ChiefEntity(Long id) {
        super(id);
    }

    public ChiefEntity(Long id, String name) {
        super(id, name);
    }

    public ChiefEntity(Builder builder) {
        super(builder);
    }

    public static abstract class Builder extends InfoEntity.Builder<Long> {

        public Builder() {
        }

        public ChiefEntity.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public ChiefEntity.Builder name(String name) {
            this.name = name;
            return this;
        }

        public ChiefEntity.Builder description(String description) {
            this.description = description;
            return this;
        }

        public abstract ChiefEntity<?,?> build();
    }
}
