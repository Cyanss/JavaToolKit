package cyan.toolkit.chief.entity;

/**
 * <p>InfoEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:11 2020/8/20
 */
public class InfoEntity<I,D,S extends InfoEntity<I,D,S>> extends IdEntity<I,D,S> {
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

    public InfoEntity(InfoEntity.Builder<I,D,S> builder) {
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

    public static class Builder<I,D,S extends InfoEntity<I,D,S>> extends IdEntity.Builder<I,D,S> {
        protected String name;
        protected String description;
        public Builder() {
        }

        public InfoEntity.Builder<I,D,S> id(I id) {
            this.id = id;
            return this;
        }

        public InfoEntity.Builder<I,D,S> createTime(D createTime) {
            this.createTime = createTime;
            return this;
        }

        public InfoEntity.Builder<I,D,S> updateTime(D updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public InfoEntity.Builder<I,D,S> name(String name) {
            this.name = name;
            return this;
        }

        public InfoEntity.Builder<I,D,S> description(String description) {
            this.description = description;
            return this;
        }

        public InfoEntity<I,D,S> build() {
            return new InfoEntity<>(this);
        }
    }
}
