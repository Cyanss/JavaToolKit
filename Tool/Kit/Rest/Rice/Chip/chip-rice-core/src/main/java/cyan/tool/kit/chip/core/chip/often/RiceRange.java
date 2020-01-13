package cyan.tool.kit.chip.core.chip.often;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import cyan.tool.kit.rice.flux.rice.util.supply.RiceJsonUtils;
import lombok.Getter;
import lombok.NonNull;

import java.util.*;

/**
 * <p>RiceRange</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:07 2020/1/9
 */
@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RiceRange<T extends Number> {
    @NonNull
    private T min;
    @NonNull
    private T max;
    @JsonIgnore
    private Class clazz;

    public RiceRange() {
    }

    public RiceRange(T min, T max) {
        this.min = min;
        this.max = max;
        this.clazz = max.getClass();
    }

    public Number range() {
        if (this.getClazz() == Integer.class) {
            return this.max.intValue() - this.min.intValue();
        } else if (this.getClazz() == Long.class) {
            return this.max.longValue() - this.min.longValue();
        } else if (this.getClazz() == Float.class) {
            return this.max.floatValue() - this.min.floatValue();
        } else if (this.getClazz() == Double.class) {
            return this.max.doubleValue() - this.min.doubleValue();
        } else if (this.getClazz() == Byte.class) {
            return this.max.byteValue() - this.min.byteValue();
        } else {
            return this.max.shortValue() - this.min.shortValue();
        }
    }

    public void setMin(T min) {
        this.min = min;
        if (this.clazz == null) {
            this.clazz = min.getClass();
        }
    }

    public void setMax(T max) {
        this.max = max;
        if (this.clazz == null) {
            this.clazz = max.getClass();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiceRange<?> riceRange = (RiceRange<?>) o;
        return min.equals(riceRange.min) &&
                max.equals(riceRange.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }


    public static <T extends Number> int compare(RiceRange<T> src, RiceRange<T> target) throws RuntimeException {
        if (src.getClazz() == Integer.class) {
            return Integer.compare(src.range().intValue(),target.range().intValue());
        } else if (src.getClazz() == Long.class) {
            return Long.compare(src.range().longValue(),target.range().longValue());
        } else if (src.getClazz() == Float.class) {
            return Float.compare(src.range().floatValue(),target.range().floatValue());
        } else if (src.getClazz() == Double.class) {
            return Double.compare(src.range().doubleValue(),target.range().doubleValue());
        } else if (src.getClazz() == Byte.class) {
            return Byte.compare(src.range().byteValue(),target.range().byteValue());
        } else {
            return Short.compare(src.range().shortValue(),target.range().shortValue());
        }
    }


    public static void main(String[] args) {
        List<RiceRange<Double>> rangeList = Arrays.asList(new RiceRange<>(0.7,0.8),new RiceRange<>(0.1,0.3));
        System.out.println(RiceJsonUtils.parserJson(rangeList));
        rangeList.sort(RiceRange::compare);
        System.out.println(RiceJsonUtils.parserJson(rangeList));
        Collections.reverse(rangeList);
        System.out.println(RiceJsonUtils.parserJson(rangeList));
    }
}
