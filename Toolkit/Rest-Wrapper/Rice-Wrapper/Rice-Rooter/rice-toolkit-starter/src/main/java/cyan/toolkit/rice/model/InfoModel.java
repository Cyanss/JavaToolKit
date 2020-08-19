package cyan.toolkit.rice.model;

import cyan.toolkit.rest.util.JsonUtils;

import java.util.Objects;

/**
 * <p>InfoModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:04 2020/8/14
 */
public class InfoModel<T extends InfoModel<T>> extends IdModel<T> {
    /** 名称 */
    private String name;
    /** 描述信息 */
    private String description;

    public InfoModel() {
    }

    public InfoModel(Long id) {
        super(id);
    }

    public InfoModel(InfoModel.Builder builder) {
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
        return JsonUtils.parserJson(this);
    }

    public static class Builder extends IdModel.Builder {
        protected String name;
        protected String description;

        public Builder() {
        }

        public InfoModel.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public InfoModel.Builder name(String name) {
            this.name = name;
            return this;
        }

        public InfoModel.Builder description(String description) {
            this.description = description;
            return this;
        }

        public InfoModel build() {
            return new InfoModel(this);
        }
    }
}
