package cyan.toolkit.chief.filter;

import cyan.toolkit.chief.model.Sort;
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
public class SortFilter {
    public static final String SORT_REGEX = ",";
    public static final String SORT_ORDER = "ORDER BY ";
    protected Set<Sort> sorts;

    public SortFilter() {
    }

    public SortFilter(Sort... sorts) {
        this.sorts = new HashSet<>(Arrays.asList(sorts));
    }

    public List<Sort> getSorts() {
        return new ArrayList<>(sorts);
    }

    public void setSorts(Sort... sorts) {
        this.sorts = new HashSet<>(Arrays.asList(sorts));
    }

    public void setSorts(Collection<Sort> sorts) {
        this.sorts = new HashSet<>(sorts);
    }

    @Override
    public String toString() {
        return toSortSql();
    }

    public String toSortSql() {
        StringBuilder sortBuilder = new StringBuilder();
        if (GeneralUtils.isNotEmpty(this.sorts)) {
            sortBuilder.append(SORT_ORDER);
            Stream.of(this.sorts).forEach(sort -> sortBuilder.append(sort.toString()).append(SORT_REGEX));
            sortBuilder.deleteCharAt(sortBuilder.length() - 1);
        }
        return sortBuilder.toString();
    }
}
