package cyan.toolkit.rice.model;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.rice.RestId;
import cyan.toolkit.rice.entity.IdEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>IdModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:00 2020/8/14
 */
public class IdModel<I> implements RestId<I>, Serializable {
    protected I id;

    public IdModel() {
    }

    public IdModel(I id) {
        this.id = id;
    }

    public IdModel(IdModel.Builder<I> builder) {
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
        IdModel<?> idModel = (IdModel<?>) o;
        return Objects.equals(id, idModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return JsonUtils.parseJson(this);
    }

    public static class Builder<I> {
        protected I id;

        public Builder() {
        }

        public IdModel.Builder<I> id(I id) {
            this.id = id;
            return this;
        }

        public IdModel<I> build() {
            return new IdModel<>(this);
        }
    }
}
