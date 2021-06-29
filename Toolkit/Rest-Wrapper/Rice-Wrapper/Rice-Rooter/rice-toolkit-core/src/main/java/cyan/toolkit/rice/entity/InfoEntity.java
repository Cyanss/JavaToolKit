package cyan.toolkit.rice.entity;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rice.RestEntity;
import cyan.toolkit.rice.RestInfo;
import cyan.toolkit.rice.RestModel;
import cyan.toolkit.rice.model.InfoModel;

import java.util.Date;

/**
 * <p>InfoEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:11 2020/8/20
 */
public class InfoEntity<I> extends IdEntity<I> implements RestInfo<I> {
    /** 事物名称 */
    protected String name;
    /** 事物描述 */
    protected String description;

    public InfoEntity() {
    }

    public InfoEntity(I id) {
        super(id);
    }

    public InfoEntity(I id, String name) {
        super(id);
        this.name = name;
    }

    public InfoEntity(InfoEntity.Builder<I> builder) {
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

    public static class Builder<I> extends IdEntity.Builder<I> {
        protected String name;
        protected String description;
        public Builder() {
        }

        public InfoEntity.Builder<I> id(I id) {
            this.id = id;
            return this;
        }

        public InfoEntity.Builder<I> createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public InfoEntity.Builder<I> updateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public InfoEntity.Builder<I> name(String name) {
            this.name = name;
            return this;
        }

        public InfoEntity.Builder<I> description(String description) {
            this.description = description;
            return this;
        }

        public InfoEntity<I> build() {
            return new InfoEntity<>(this);
        }
    }
}
