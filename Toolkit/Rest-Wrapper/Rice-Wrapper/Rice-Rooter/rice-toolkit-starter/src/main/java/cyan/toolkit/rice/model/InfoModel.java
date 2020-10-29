package cyan.toolkit.rice.model;

import cyan.toolkit.rest.util.common.JsonUtils;

/**
 * <p>InfoModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:04 2020/8/14
 */
public class InfoModel<I,S extends InfoModel<I,S>> extends IdModel<I,S> {
    /** 名称 */
    private String name;
    /** 描述信息 */
    private String description;

    public InfoModel() {
    }

    public InfoModel(I id) {
        super(id);
    }

    public InfoModel(InfoModel.Builder<I,S> builder) {
        super(builder);
        this.name = builder.name;
        this.description = builder.description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return JsonUtils.parseJson(this);
    }

    public static class Builder<I,S extends InfoModel<I,S>> extends IdModel.Builder<I,S> {
        protected String name;
        protected String description;

        public Builder() {
        }

        public InfoModel.Builder<I,S> id(I id) {
            this.id = id;
            return this;
        }

        public InfoModel.Builder<I,S> name(String name) {
            this.name = name;
            return this;
        }

        public InfoModel.Builder<I,S> description(String description) {
            this.description = description;
            return this;
        }

        public InfoModel<I,S> build() {
            return new InfoModel<>(this);
        }
    }
}
