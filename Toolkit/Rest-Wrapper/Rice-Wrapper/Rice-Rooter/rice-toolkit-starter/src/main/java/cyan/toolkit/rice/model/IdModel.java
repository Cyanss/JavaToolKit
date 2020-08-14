package cyan.toolkit.rice.model;

import cyan.toolkit.rest.util.JsonUtils;
import lombok.Data;

import java.util.Objects;

/**
 * <p>IdModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:00 2020/8/14
 */
public class IdModel <T extends IdModel<T>>{
    private Long id;

    public IdModel() {
    }

    public IdModel(Long id) {
        this.id = id;
    }

    public IdModel(IdModel.Builder builder) {
        this.id = builder.id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return JsonUtils.parserJson(this);
    }

    public static class Builder {
        protected Long id;

        public Builder() {
        }

        public IdModel.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public IdModel build() {
            return new IdModel(this);
        }
    }
}
