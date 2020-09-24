package cyan.toolkit.chief.model;

import cyan.toolkit.chief.enums.SortType;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Sort</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:43 2020/9/8
 */
public class RestSort implements Serializable {
    protected String name;
    protected SortType type = SortType.DESC;

    public RestSort() {
    }

    public RestSort(String name) {
        this.name = name;
    }

    public RestSort(String name, SortType type) {
        this.name = name;
        this.type = type;
    }

    public RestSort(RestSort.Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortType getType() {
        return type;
    }

    public void setType(SortType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestSort sort = (RestSort) o;
        return Objects.equals(name, sort.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.concat(" ").concat(type.getValue());
    }

    public static class Builder {
        protected String name;
        protected SortType type = SortType.DESC;
        public Builder() {
        }

        public RestSort.Builder name(String name) {
            this.name = name;
            return this;
        }

        public RestSort.Builder type(SortType type) {
            this.type = type;
            return this;
        }

        public RestSort.Builder type(Integer type) {
            this.type = SortType.parserKey(type);
            return this;
        }

        public RestSort.Builder type(String type) {
            this.type = SortType.parserValue(type);
            return this;
        }
        
        public RestSort build() {
            return new RestSort(this);
        }
    }

}
