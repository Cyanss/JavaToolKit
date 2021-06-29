package cyan.toolkit.chief;

import cyan.toolkit.rice.RestModel;
import cyan.toolkit.rice.model.InfoModel;

/**
 * <p>ChiefModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:40 2020/11/3
 */
public abstract class ChiefInfoModel<M extends ChiefInfoModel<M,E>,E extends ChiefInfoEntity<E,M>> extends InfoModel<Long> implements RestModel<Long,E> {

    public ChiefInfoModel() {
    }

    public ChiefInfoModel(Long id) {
        super(id);
    }

    public ChiefInfoModel(ChiefInfoModel.Builder builder) {
        super(builder);
    }

    public static abstract class Builder extends InfoModel.Builder<Long> {

        public Builder() {
        }

        public ChiefInfoModel.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public ChiefInfoModel.Builder name(String name) {
            this.name = name;
            return this;
        }

        public ChiefInfoModel.Builder description(String description) {
            this.description = description;
            return this;
        }

        public abstract ChiefInfoModel<?,?> build();
    }
}
