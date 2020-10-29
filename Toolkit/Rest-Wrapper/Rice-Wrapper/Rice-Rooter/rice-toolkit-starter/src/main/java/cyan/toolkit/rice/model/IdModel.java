package cyan.toolkit.rice.model;

import cyan.toolkit.rest.util.common.JsonUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>IdModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:00 2020/8/14
 */
public class IdModel<I,S extends IdModel<I,S>> implements Serializable {
    private I id;

    public IdModel() {
    }

    public IdModel(I id) {
        this.id = id;
    }

    public IdModel(IdModel.Builder<I,S> builder) {
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
        IdModel<?,?> idModel = (IdModel<?,?>) o;
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

    public static class Builder<I,S extends IdModel<I,S>> {
        protected I id;

        public Builder() {
        }

        public IdModel.Builder<I,S> id(I id) {
            this.id = id;
            return this;
        }

        public IdModel<I,S> build() {
            return new IdModel<>(this);
        }
    }
}
