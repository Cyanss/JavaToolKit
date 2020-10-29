package cyan.toolkit.chief.entity;

import javax.persistence.Id;

/**
 * <p>IdEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:10 2020/8/20
 */
public class IdEntity<I,D,S extends IdEntity<I,D,S>> extends TimeEntity<D,S>{
    @Id
    protected I id;

    public IdEntity() {
    }

    public IdEntity(I id) {
        this.id = id;
    }

    public IdEntity(IdEntity.Builder<I,D,S> builder) {
        super(builder);
        this.id = builder.id;
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public static class Builder<I,D,S extends IdEntity<I,D,S>> extends TimeEntity.Builder<D,S> {
        protected I id;

        public Builder() {
        }

        public IdEntity.Builder<I,D,S> id(I id) {
            this.id = id;
            return this;
        }

        public IdEntity.Builder<I,D,S> createTime(D createTime) {
            this.createTime = createTime;
            return this;
        }

        public IdEntity.Builder<I,D,S> updateTime(D updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public IdEntity<I,D,S> build() {
            return new IdEntity<>(this);
        }
    }
}
