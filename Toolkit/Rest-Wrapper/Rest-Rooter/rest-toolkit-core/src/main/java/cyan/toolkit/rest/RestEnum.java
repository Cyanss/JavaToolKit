package cyan.toolkit.rest;

import java.util.Objects;

/**
 * <p>RestEnum</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 18:00 2020/12/14
 */
public class RestEnum {
    private String name;
    private Object value;

    public RestEnum() {
    }

    public RestEnum(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public static RestEnum mapKey(RestValue entry) {
        return new RestEnum(entry.name(),entry.getKey());
    }

    public static RestEnum mapValue(RestValue entry) {
        return new RestEnum(entry.name(),entry.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestEnum ogsEnum = (RestEnum) o;
        return Objects.equals(name, ogsEnum.name) &&
                Objects.equals(value, ogsEnum.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
