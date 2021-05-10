package cyan.toolkit.chief.filter;

import com.fasterxml.jackson.annotation.JsonSetter;

import cyan.toolkit.chief.builder.SqlBuilder;
import cyan.toolkit.chief.builder.SqlBuilders;
import cyan.toolkit.chief.jsonb.*;
import cyan.toolkit.chief.model.RestSort;
import cyan.toolkit.rest.util.common.GeneralUtils;
import org.springframework.lang.NonNull;

import java.util.*;

/**
 * <p>JsonbFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:34 2021/5/7
 */
public class JsonbFilter<D,I> extends TimeFilter<D,I> {
    /**
     * 数值型对比运算集合
     */
    protected Set<ContrastRule> contrasts;
    /**
     * 数值型范围对比运算集合
     */
    protected Set<RangeRule> ranges;
    /**
     * 字符串型比较模糊运算集合
     */
    protected Set<EqualRule> equals;
    /**
     * 包含运算in
     */
    protected Set<ContainRule> contains;

    public JsonbFilter() {
    }

    @SuppressWarnings(value = "unchecked")
    public JsonbFilter(I... ids) {
        super(ids);
    }

    public JsonbFilter(JsonbFilter.Builder<D,I> builder) {
        super(builder);
        this.contrasts = builder.contrasts;
        this.ranges = builder.ranges;
        this.equals = builder.equals;
        this.contains = builder.contains;
    }

    public void addContains(ContainRule... contains) {
        if (GeneralUtils.isEmpty(this.contains)) {
            this.contains = Optional.ofNullable(contains).map(containList -> new HashSet<>(Arrays.asList(containList))).orElse(null);
        } else {
            Optional.ofNullable(contains).ifPresent(containList -> this.contains.addAll(Arrays.asList(containList)));
        }
    }

    public void addContains(Collection<ContainRule> contains) {
        if (GeneralUtils.isEmpty(this.contains)) {
            this.contains = Optional.ofNullable(contains).map(HashSet::new).orElse(null);
        } else {
            Optional.ofNullable(contains).ifPresent(this.contains::addAll);
        }
    }

    public List<ContainRule> getContains() {
        if (GeneralUtils.isNotEmpty(this.contains)) {
            return new ArrayList<>(contains);
        }
        return null;
    }

    public void setContains(ContainRule... contains) {
        this.contains = Optional.ofNullable(contains).map(containList -> new HashSet<>(Arrays.asList(containList))).orElse(null);
    }

    @JsonSetter
    public void setContains(Collection<ContainRule> contains) {
        this.contains = Optional.ofNullable(contains).map(HashSet::new).orElse(null);
    }

    public void addContrasts(ContrastRule... contrasts) {
        if (GeneralUtils.isEmpty(this.contrasts)) {
            this.contrasts = Optional.ofNullable(contrasts).map(contrastList -> new HashSet<>(Arrays.asList(contrastList))).orElse(null);
        } else {
            Optional.ofNullable(contrasts).ifPresent(contrastList -> this.contrasts.addAll(Arrays.asList(contrastList)));
        }
    }

    public void addContrasts(Collection<ContrastRule> contrasts) {
        if (GeneralUtils.isEmpty(this.contrasts)) {
            this.contrasts = Optional.ofNullable(contrasts).map(HashSet::new).orElse(null);
        } else {
            Optional.ofNullable(contrasts).ifPresent(this.contrasts::addAll);
        }
    }

    public List<ContrastRule> getContrasts() {
        if (GeneralUtils.isNotEmpty(this.contrasts)) {
            return new ArrayList<>(contrasts);
        }
        return null;
    }

    public void setContrasts(ContrastRule... contrasts) {
        this.contrasts = Optional.ofNullable(contrasts).map(contrastsList -> new HashSet<>(Arrays.asList(contrastsList))).orElse(null);
    }

    @JsonSetter
    public void setContrasts(Collection<ContrastRule> contrasts) {
        this.contrasts = Optional.ofNullable(contrasts).map(HashSet::new).orElse(null);
    }

    public void addRanges(RangeRule... ranges) {
        if (GeneralUtils.isEmpty(this.ranges)) {
            this.ranges = Optional.ofNullable(ranges).map(rangeList -> new HashSet<>(Arrays.asList(rangeList))).orElse(null);
        } else {
            Optional.ofNullable(ranges).ifPresent(rangeList -> this.ranges.addAll(Arrays.asList(rangeList)));
        }
    }

    public void addRanges(Collection<RangeRule> ranges) {
        if (GeneralUtils.isEmpty(this.ranges)) {
            this.ranges = Optional.ofNullable(ranges).map(HashSet::new).orElse(null);
        } else {
            Optional.ofNullable(ranges).ifPresent(this.ranges::addAll);
        }
    }

    public List<RangeRule> getRanges() {
        if (GeneralUtils.isNotEmpty(this.ranges)) {
            return new ArrayList<>(ranges);
        }
        return null;
    }

    public void setRanges(RangeRule... ranges) {
        this.ranges = Optional.ofNullable(ranges).map(rangeList -> new HashSet<>(Arrays.asList(rangeList))).orElse(null);
    }

    @JsonSetter
    public void setRanges(Collection<RangeRule> ranges) {
        this.ranges = Optional.ofNullable(ranges).map(HashSet::new).orElse(null);
    }

    public void addEquals(EqualRule... equals) {
        if (GeneralUtils.isEmpty(this.equals)) {
            this.equals = Optional.ofNullable(equals).map(equalList -> new HashSet<>(Arrays.asList(equalList))).orElse(null);
        } else {
            Optional.ofNullable(equals).ifPresent(equalList -> this.equals.addAll(Arrays.asList(equalList)));
        }
    }

    public void addEquals(Collection<EqualRule> equals) {
        if (GeneralUtils.isEmpty(this.equals)) {
            this.equals = Optional.ofNullable(equals).map(HashSet::new).orElse(null);
        } else {
            Optional.ofNullable(equals).ifPresent(this.equals::addAll);
        }
    }

    public List<EqualRule> getEquals() {
        if (GeneralUtils.isNotEmpty(this.equals)) {
            return new ArrayList<>(equals);
        }
        return null;
    }

    public void setEquals(EqualRule... equals) {
        this.equals = Optional.ofNullable(equals).map(equalList -> new HashSet<>(Arrays.asList(equalList))).orElse(null);
    }

    @JsonSetter
    public void setEquals(Collection<EqualRule> equals) {
        this.equals = Optional.ofNullable(equals).map(HashSet::new).orElse(null);
    }

    public JsonbFilter<D,I> toJsonbSql(@NonNull String alias) {
        this.toJsonbSql(alias,"value");
        return this;
    }

    public JsonbFilter<D,I> toJsonbSql(@NonNull String alias, String variable) {
        SqlBuilder sqlBuilder = SqlBuilders.newSqlBuilder();
        this.appendSql(alias,variable,getContrasts(),sqlBuilder);
        this.appendSql(alias,variable,getRanges(),sqlBuilder);
        this.appendSql(alias,variable,getContains(),sqlBuilder);
        this.appendSql(alias,variable,getEquals(),sqlBuilder);
        return this;
    }

    public <R extends JsonbRule<R>> void appendSql(@NonNull String alias, String variable, List<R> rules, SqlBuilder sqlBuilder) {
        if (GeneralUtils.isNotEmpty(rules)) {
            rules.forEach(rule -> {
                String sql = rule.toSql(alias,variable);
                if (GeneralUtils.isNotEmpty(sql)) {
                    sqlBuilder.append(sql);
                }
            });
        }
    }

    public JsonbFilter<D,I> toTimeSql(@NonNull String alias) {
        super.toTimeSql(alias);
        return this;
    }

    @Override
    public JsonbFilter<D,I> toIdSql(@NonNull String alias) {
        super.toIdSql(alias);
        return this;
    }

    public static class Builder<D,I> extends TimeFilter.Builder<D,I> {
        protected Set<ContrastRule> contrasts;
        protected Set<RangeRule> ranges;
        protected Set<EqualRule> equals;
        protected Set<ContainRule> contains;

        public Builder() {
        }

        public JsonbFilter.Builder<D,I> contrasts(Collection<ContrastRule> contrasts) {
            this.contrasts = Optional.ofNullable(contrasts).map(HashSet::new).orElse(null);
            return this;
        }

        public JsonbFilter.Builder<D,I> contrasts(ContrastRule... contrasts) {
            this.contrasts = Optional.ofNullable(contrasts).map(contrastList -> new HashSet<>(Arrays.asList(contrastList))).orElse(null);
            return this;
        }

        public JsonbFilter.Builder<D,I> ranges(Collection<RangeRule> ranges) {
            this.ranges = Optional.ofNullable(ranges).map(HashSet::new).orElse(null);
            return this;
        }

        public JsonbFilter.Builder<D,I> ranges(RangeRule... ranges) {
            this.ranges = Optional.ofNullable(ranges).map(rangeList -> new HashSet<>(Arrays.asList(rangeList))).orElse(null);
            return this;
        }

        public JsonbFilter.Builder<D,I> equals(Collection<EqualRule> equals) {
            this.equals = Optional.ofNullable(equals).map(HashSet::new).orElse(null);
            return this;
        }

        public JsonbFilter.Builder<D,I> equals(EqualRule... equals) {
            this.equals = Optional.ofNullable(equals).map(equalList -> new HashSet<>(Arrays.asList(equalList))).orElse(null);
            return this;
        }

        public JsonbFilter.Builder<D,I> contains(Collection<ContainRule> contains) {
            this.contains = Optional.ofNullable(contains).map(HashSet::new).orElse(null);
            return this;
        }

        public JsonbFilter.Builder<D,I> contains(ContainRule... contains) {
            this.contains = Optional.ofNullable(contains).map(containList -> new HashSet<>(Arrays.asList(containList))).orElse(null);
            return this;
        }

        public JsonbFilter.Builder<D,I> startTime(D startTime) {
            this.startTime = startTime;
            return this;
        }

        public JsonbFilter.Builder<D,I> endTime(D endTime) {
            this.endTime = endTime;
            return this;
        }

        public JsonbFilter.Builder<D,I> ids(@NonNull Collection<I> ids) {
            this.ids = new HashSet<>(ids);
            return this;
        }

        @SuppressWarnings(value = "unchecked")
        public JsonbFilter.Builder<D,I> ids(@NonNull I... ids) {
            this.ids = new HashSet<>(Arrays.asList(ids));
            return this;
        }

        public JsonbFilter.Builder<D,I> sorts(@NonNull Collection<RestSort> sorts) {
            this.sorts = new HashSet<>(sorts);
            return this;
        }

        public JsonbFilter.Builder<D,I> sorts(@NonNull RestSort... sorts) {
            this.sorts = new HashSet<>(Arrays.asList(sorts));
            return this;
        }

        public JsonbFilter.Builder<D,I> pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public JsonbFilter.Builder<D,I> pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public JsonbFilter<D,I> build() {
            return new JsonbFilter<>(this);
        }
    }

}
