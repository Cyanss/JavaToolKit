package cyan.toolkit.chief;

import cyan.toolkit.chief.builder.SqlBuilder;
import cyan.toolkit.chief.builder.SqlBuilders;
import cyan.toolkit.chief.filter.JsonbFilter;
import cyan.toolkit.chief.jsonb.ContainRule;
import cyan.toolkit.chief.jsonb.ContrastRule;
import cyan.toolkit.chief.jsonb.EqualRule;
import cyan.toolkit.chief.jsonb.RangeRule;
import cyan.toolkit.chief.model.RestSort;
import org.springframework.lang.NonNull;

import java.util.*;

/**
 * <p>RestFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:47 2020/11/3
 */
public abstract class ChiefFilter extends JsonbFilter<Date,Long> {
    public ChiefFilter() {
    }

    public ChiefFilter(Long... ids) {
        super(ids);
    }

    public ChiefFilter(ChiefFilter.Builder builder) {
        super(builder);
    }

    @Override
    public ChiefFilter toJsonbSql(@NonNull String alias) {
        super.toJsonbSql(alias);
        return this;
    }

    @Override
    public ChiefFilter toJsonbSql(@NonNull String alias, String variable) {
        super.toJsonbSql(alias,variable);
        return this;
    }

    @Override
    public ChiefFilter toTimeSql(@NonNull String alias) {
        super.toTimeSql(alias);
        return this;
    }

    @Override
    public ChiefFilter toIdSql(@NonNull String alias) {
        super.toIdSql(alias);
        return this;
    }

    public static abstract class Builder extends JsonbFilter.Builder<Date,Long> {

        public Builder() {
        }

        public ChiefFilter.Builder contrasts(Collection<ContrastRule> contrasts) {
            this.contrasts = Optional.ofNullable(contrasts).map(HashSet::new).orElse(null);
            return this;
        }

        public ChiefFilter.Builder contrasts(ContrastRule... contrasts) {
            this.contrasts = Optional.ofNullable(contrasts).map(contrastList -> new HashSet<>(Arrays.asList(contrastList))).orElse(null);
            return this;
        }

        public ChiefFilter.Builder ranges(Collection<RangeRule> ranges) {
            this.ranges = Optional.ofNullable(ranges).map(HashSet::new).orElse(null);
            return this;
        }

        public ChiefFilter.Builder ranges(RangeRule... ranges) {
            this.ranges = Optional.ofNullable(ranges).map(rangeList -> new HashSet<>(Arrays.asList(rangeList))).orElse(null);
            return this;
        }

        public ChiefFilter.Builder equals(Collection<EqualRule> equals) {
            this.equals = Optional.ofNullable(equals).map(HashSet::new).orElse(null);
            return this;
        }

        public ChiefFilter.Builder equals(EqualRule... equals) {
            this.equals = Optional.ofNullable(equals).map(equalList -> new HashSet<>(Arrays.asList(equalList))).orElse(null);
            return this;
        }

        public ChiefFilter.Builder contains(Collection<ContainRule> contains) {
            this.contains = Optional.ofNullable(contains).map(HashSet::new).orElse(null);
            return this;
        }

        public ChiefFilter.Builder contains(ContainRule... contains) {
            this.contains = Optional.ofNullable(contains).map(containList -> new HashSet<>(Arrays.asList(containList))).orElse(null);
            return this;
        }

        public ChiefFilter.Builder startTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public ChiefFilter.Builder endTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public ChiefFilter.Builder ids(@NonNull Collection<Long> ids) {
            this.ids = new HashSet<>(ids);
            return this;
        }

        public ChiefFilter.Builder ids(@NonNull Long... ids) {
            this.ids = new HashSet<>(Arrays.asList(ids));
            return this;
        }

        public ChiefFilter.Builder sorts(@NonNull Collection<RestSort> sorts) {
            this.sorts = new HashSet<>(sorts);
            return this;
        }

        public ChiefFilter.Builder sorts(@NonNull RestSort... sorts) {
            this.sorts = new HashSet<>(Arrays.asList(sorts));
            return this;
        }

        public ChiefFilter.Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public ChiefFilter.Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public abstract ChiefFilter build();
    }
}
