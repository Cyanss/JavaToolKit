package cyan.toolkit.chief;

import cyan.toolkit.rice.RestEntity;
import cyan.toolkit.rice.RestModel;
import cyan.toolkit.rice.model.InfoModel;

/**
 * <p>ChiefModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:40 2020/11/3
 */
public abstract class ChiefModel<M extends ChiefModel<M,E>,E extends ChiefEntity<E,M>> extends InfoModel<Long> implements RestModel<Long,E> {

    public ChiefModel() {
    }

    public ChiefModel(Long id) {
        super(id);
    }

    public ChiefModel(ChiefModel.Builder builder) {
        super(builder);
    }

    public static abstract class Builder extends InfoModel.Builder<Long> {

        public Builder() {
        }

        public ChiefModel.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public ChiefModel.Builder name(String name) {
            this.name = name;
            return this;
        }

        public ChiefModel.Builder description(String description) {
            this.description = description;
            return this;
        }

        public abstract ChiefModel<?,?> build();
    }
}
