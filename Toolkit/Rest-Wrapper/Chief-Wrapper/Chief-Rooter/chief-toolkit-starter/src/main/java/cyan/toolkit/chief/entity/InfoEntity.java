package cyan.toolkit.chief.entity;

/**
 * <p>InfoEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:11 2020/8/20
 */
public class InfoEntity<I,D> extends IdEntity<I,D> {
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

    public InfoEntity(InfoEntity.Builder<I,D> builder) {
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

    public static class Builder<I,D> extends IdEntity.Builder<I,D> {
        protected String name;
        protected String description;
        public Builder() {
        }

        public InfoEntity.Builder<I,D> id(I id) {
            this.id = id;
            return this;
        }

        public InfoEntity.Builder<I,D> createTime(D createTime) {
            this.createTime = createTime;
            return this;
        }

        public InfoEntity.Builder<I,D> updateTime(D updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public InfoEntity.Builder<I,D> name(String name) {
            this.name = name;
            return this;
        }

        public InfoEntity.Builder<I,D> description(String description) {
            this.description = description;
            return this;
        }

        public InfoEntity<I,D> build() {
            return new InfoEntity<>(this);
        }
    }
}
