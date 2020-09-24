package cyan.toolkit.chief.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cyan.toolkit.chief.model.RestSort;
import cyan.toolkit.rest.util.common.GeneralUtils;

import java.util.*;
import java.util.stream.Stream;

/**
 * <p>SortFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:21 2020/9/9
 */
public class SortFilter extends PageFilter {
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

    public SortFilter(SortFilter.Builder builder) {
        super(builder);
        this.sorts = builder.sorts;
    }

    public List<RestSort> getSorts() {
        return new ArrayList<>(sorts);
    }

    public void setSorts(RestSort... sorts) {
        this.sorts = new HashSet<>(Arrays.asList(sorts));
    }

    public void setSorts(Collection<RestSort> sorts) {
        this.sorts = new HashSet<>(sorts);
    }

    public String toSort() {
        StringBuilder sortBuilder = new StringBuilder();
        if (GeneralUtils.isNotEmpty(this.sorts)) {
            sortBuilder.append(SORT_ORDER);
            Stream.of(this.sorts).forEach(sort -> sortBuilder.append(sort.toString()).append(SORT_REGEX));
            sortBuilder.deleteCharAt(sortBuilder.length() - 1);
        }
        return sortBuilder.toString();
    }

    public static class Builder extends PageFilter.Builder {
        protected Set<RestSort> sorts;

        public Builder() {
        }

        public SortFilter.Builder sorts(Collection<RestSort> sorts) {
            this.sorts = new HashSet<>(sorts);
            return this;
        }

        public SortFilter.Builder sorts(RestSort... sorts) {
            this.sorts = new HashSet<>(Arrays.asList(sorts));
            return this;
        }

        public SortFilter.Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public SortFilter.Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public SortFilter build() {
            return new SortFilter(this);
        }
    }
}
