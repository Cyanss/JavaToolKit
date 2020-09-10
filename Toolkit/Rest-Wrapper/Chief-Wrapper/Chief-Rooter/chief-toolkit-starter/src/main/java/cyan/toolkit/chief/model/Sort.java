package cyan.toolkit.chief.model;

import cyan.toolkit.chief.enums.SortTypeEnum;

import java.util.Objects;

/**
 * <p>Sort</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:43 2020/9/8
 */
public class Sort {
    protected String name;
    protected SortTypeEnum type = SortTypeEnum.DESC;

    public Sort() {
    }

    public Sort(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortTypeEnum getType() {
        return type;
    }

    public void setType(SortTypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sort sort = (Sort) o;
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


}
