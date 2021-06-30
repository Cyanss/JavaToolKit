package cyan.toolkit.chief;

import cyan.toolkit.rice.RestModel;
import cyan.toolkit.rice.model.IdModel;

/**
 * <p>ChiefModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:40 2020/11/3
 */
public abstract class ChiefIdModel<M extends ChiefIdModel<M,E>,E extends ChiefIdEntity<E,M>> extends IdModel<Long> implements RestModel<Long,E> {

    public ChiefIdModel() {
    }

    public ChiefIdModel(Long id) {
        super(id);
    }

    public ChiefIdModel(ChiefIdModel.Builder builder) {
        super(builder);
    }

    public static abstract class Builder extends IdModel.Builder<Long> {

        public Builder() {
        }

        public ChiefIdModel.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public abstract ChiefIdModel<?,?> build();
    }
}
