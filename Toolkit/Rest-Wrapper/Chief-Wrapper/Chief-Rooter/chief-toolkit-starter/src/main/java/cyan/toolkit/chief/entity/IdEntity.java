package cyan.toolkit.chief.entity;

import javax.persistence.Id;

/**
 * <p>IdEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:10 2020/8/20
 */
public class IdEntity<I,D> extends TimeEntity<D>{
    @Id
    protected I id;

    public IdEntity() {
    }

    public IdEntity(I id) {
        this.id = id;
    }

    public IdEntity(IdEntity.Builder<I,D> builder) {
        super(builder);
        this.id = builder.id;
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public static class Builder<I,D> extends TimeEntity.Builder<D> {
        protected I id;

        public Builder() {
        }

        public IdEntity.Builder<I,D> id(I id) {
            this.id = id;
            return this;
        }

        public IdEntity.Builder<I,D> createTime(D createTime) {
            this.createTime = createTime;
            return this;
        }

        public IdEntity.Builder<I,D> updateTime(D updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public IdEntity<I,D> build() {
            return new IdEntity<>(this);
        }
    }
}
