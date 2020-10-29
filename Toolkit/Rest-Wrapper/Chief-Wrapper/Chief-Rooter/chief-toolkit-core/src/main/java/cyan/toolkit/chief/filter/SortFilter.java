package cyan.toolkit.chief.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cyan.toolkit.chief.model.RestSort;
import cyan.toolkit.rest.util.common.GeneralUtils;
import org.springframework.lang.NonNull;

import java.util.*;

/**
 * <p>SortFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:21 2020/9/9
 */
public class SortFilter<S extends SortFilter<S>> extends PageFilter<S> {
    @JsonIgnore
    public static final String SORT_REGEX = ",";
    @JsonIgnore
    public static final String SORT_ORDER = "ORDER BY ";

    protected Set<RestSort> sorts;

    public SortFilter() {
    }

    public SortFilter(RestSort... sorts) {
        this.sorts = new HashSet<>(Arrays.asList(sorts));
    }

    public SortFilter(String... sorts) {
        this.sorts = new HashSet<>(RestSort.build(sorts));
    }

    public SortFilter(SortFilter.Builder<S> builder) {
        super(builder);
        this.sorts = builder.sorts;
    }

    public List<RestSort> getSorts() {
        return new ArrayList<>(sorts);
    }

    public void setSorts(String... sorts) {
        this.setSorts(RestSort.build(sorts));
    }


    public void setSorts(RestSort... sorts) {
        this.sorts = new HashSet<>(Arrays.asList(sorts));
    }

    public void setSorts(Collection<RestSort> sorts) {
        this.sorts = new HashSet<>(sorts);
    }

    public void addSorts(@NonNull String... sorts) {
        if (GeneralUtils.isEmpty(this.sorts)) {
            this.sorts = new HashSet<>(RestSort.build(sorts));
        } else {
            this.sorts.addAll(RestSort.build(sorts));
        }
    }

    public void addSorts(@NonNull RestSort... sorts) {
        if (GeneralUtils.isEmpty(this.sorts)) {
            this.sorts = new HashSet<>(Arrays.asList(sorts));
        } else {
            this.sorts.addAll(Arrays.asList(sorts));
        }
    }

    public void addSorts(@NonNull Collection<RestSort> sorts) {
        if (GeneralUtils.isEmpty(this.sorts)) {
            this.sorts = new HashSet<>(sorts);
        } else {
            this.sorts.addAll(sorts);
        }
    }

    public String toSort() {
        StringBuilder sortBuilder = new StringBuilder();
        if (GeneralUtils.isNotEmpty(this.sorts)) {
            sortBuilder.append(SORT_ORDER);
            this.sorts.forEach(sort -> sortBuilder.append(sort.toString()).append(SORT_REGEX));
            sortBuilder.deleteCharAt(sortBuilder.length() - 1);
        }
        return sortBuilder.toString();
    }

    public static class Builder<S extends SortFilter<S>> extends PageFilter.Builder<S> {
        protected Set<RestSort> sorts;

        public Builder() {
        }

        public SortFilter.Builder<S> sorts(Collection<RestSort> sorts) {
            this.sorts = new HashSet<>(sorts);
            return this;
        }

        public SortFilter.Builder<S> sorts(RestSort... sorts) {
            this.sorts = new HashSet<>(Arrays.asList(sorts));
            return this;
        }

        public SortFilter.Builder<S> pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public SortFilter.Builder<S> pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public SortFilter<S> build() {
            return new SortFilter<>(this);
        }
    }
}
