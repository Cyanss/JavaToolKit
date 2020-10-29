package cyan.toolkit.chief.filter;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import cyan.toolkit.chief.model.RestSort;
import cyan.toolkit.chief.serialization.DateSerializer;
import cyan.toolkit.chief.serialization.DateDeserializer;

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
public class TimeFilter<D,I,S extends TimeFilter<D,I,S>> extends IdFilter<I,S> {

    /** default like '2020-01-01 00:00:00' */
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    protected D startTime;
    /** default like '2020-01-02 00:00:00' */
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    protected D endTime;

    public TimeFilter() {
    }

    public TimeFilter(TimeFilter.Builder<D,I,S> builder) {
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

    public static class Builder<D,I,S extends TimeFilter<D,I,S>> extends IdFilter.Builder<I,S> {
        protected D startTime;
        protected D endTime;

        public Builder() {
        }

        public TimeFilter.Builder<D,I,S> startTime(D startTime) {
            this.startTime = startTime;
            return this;
        }

        public TimeFilter.Builder<D,I,S> endTime(D endTime) {
            this.endTime = endTime;
            return this;
        }

        public TimeFilter.Builder<D,I,S> ids(Collection<I> ids) {
            this.ids = new HashSet<>(ids);
            return this;
        }

        @SuppressWarnings(value = "unchecked")
        public TimeFilter.Builder<D,I,S> ids(I... ids) {
            this.ids = new HashSet<>(Arrays.asList(ids));
            return this;
        }

        public TimeFilter.Builder<D,I,S> sorts(Collection<RestSort> sorts) {
            this.sorts = new HashSet<>(sorts);
            return this;
        }

        public TimeFilter.Builder<D,I,S> sorts(RestSort... sorts) {
            this.sorts = new HashSet<>(Arrays.asList(sorts));
            return this;
        }

        public TimeFilter.Builder<D,I,S> pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public TimeFilter.Builder<D,I,S> pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public TimeFilter<D,I,S> build() {
            return new TimeFilter<>(this);
        }
    }
}
