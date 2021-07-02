package cyan.toolkit.rice.entity;

import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.rice.RestId;

import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * <p>IdEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:10 2020/8/20
 */
public class IdEntity<I> extends TimeEntity implements RestId<I> {
    @Id
    protected I id;

    public IdEntity() {
    }

    public IdEntity(I id) {
        this.id = id;
    }

    public IdEntity(IdEntity.Builder<I> builder) {
        super(builder);
        this.id = builder.id;
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdEntity<?> idEntity = (IdEntity<?>) o;
        return Objects.equals(id, idEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return JsonUtils.parseJson(this);
    }

    public static class Builder<I> extends TimeEntity.Builder {
        protected I id;

        public Builder() {
        }

        public IdEntity.Builder<I> id(I id) {
            this.id = id;
            return this;
        }

        public IdEntity.Builder<I> createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public IdEntity.Builder<I> updateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public IdEntity<I> build() {
            return new IdEntity<>(this);
        }
    }
}
