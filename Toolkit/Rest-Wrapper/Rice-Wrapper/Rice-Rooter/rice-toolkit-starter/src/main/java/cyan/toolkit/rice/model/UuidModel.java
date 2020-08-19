package cyan.toolkit.rice.model;

import cyan.toolkit.rest.util.JsonUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>UuidModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:12 2020/8/18
 */
public class UuidModel <T extends UuidModel<T>> implements Serializable {
    private String uuid;

    public UuidModel() {
    }

    public UuidModel(String uuid) {
        this.uuid = uuid;
    }

    public UuidModel(UuidModel.Builder builder) {
        this.uuid = builder.uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UuidModel<?> uuidModel = (UuidModel<?>) o;
        return Objects.equals(uuid, uuidModel.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return JsonUtils.parserJson(this);
    }

    public static class Builder {
        protected String uuid;

        public Builder() {
        }

        public UuidModel.Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public UuidModel build() {
            return new UuidModel(this);
        }
    }
}
