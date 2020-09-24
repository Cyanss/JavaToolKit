package cyan.toolkit.chief.filter;

import cyan.toolkit.chief.model.RestSort;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * <p>TimeFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:25 2020/9/10
 */
public class TimeFilter<D,I> extends IdFilter<I> {
    protected D startTime;
    protected D endTime;

    public TimeFilter() {
    }

    public TimeFilter(TimeFilter.Builder<D,I> builder) {
        super(builder);
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public D getStartTime() {
        return startTime;
    }

    public void setStartTime(D startTime) {
        this.startTime = startTime;
    }

    public D getEndTime() {
        return endTime;
    }

    public void setEndTime(D endTime) {
        this.endTime = endTime;
    }

    public static class Builder<D,I> extends IdFilter.Builder<I> {
        protected D startTime;
        protected D endTime;

        public Builder() {
        }

        public TimeFilter.Builder<D,I> startTime(D startTime) {
            this.startTime = startTime;
            return this;
        }

        public TimeFilter.Builder<D,I> endTime(D endTime) {
            this.endTime = endTime;
            return this;
        }

        public TimeFilter.Builder<D,I> ids(Collection<I> ids) {
            this.ids = new HashSet<>(ids);
            return this;
        }

        @SuppressWarnings(value = "unchecked")
        public TimeFilter.Builder<D,I> ids(I... ids) {
            this.ids = new HashSet<>(Arrays.asList(ids));
            return this;
        }

        public TimeFilter.Builder<D,I> sorts(Collection<RestSort> sorts) {
            this.sorts = new HashSet<>(sorts);
            return this;
        }

        public TimeFilter.Builder<D,I> sorts(RestSort... sorts) {
            this.sorts = new HashSet<>(Arrays.asList(sorts));
            return this;
        }

        public TimeFilter.Builder<D,I> pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public TimeFilter.Builder<D,I> pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public TimeFilter<D,I> build() {
            return new TimeFilter<>(this);
        }
    }
}
