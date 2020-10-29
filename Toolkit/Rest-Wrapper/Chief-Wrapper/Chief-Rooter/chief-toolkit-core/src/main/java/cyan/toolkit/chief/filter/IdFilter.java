package cyan.toolkit.chief.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cyan.toolkit.chief.builder.*;
import cyan.toolkit.chief.model.RestSort;
import cyan.toolkit.rest.util.common.GeneralUtils;

import java.util.*;

/**
 * <p>IdFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:39 2020/9/8
 */
public class IdFilter<I,S extends IdFilter<I,S>> extends SortFilter<S>{
    @JsonIgnore
    protected final SqlBuilder SQL_BUILDER = new SqlBuilder();

    protected I id;

    protected Set<I> ids;

    public IdFilter() {
    }

    /**
     * the generic paradigm of T is not Like List<T>、Set<T>
     * It should be String、Long、Integer ...
     * @param ids
     */
    @SuppressWarnings(value = "unchecked")
    public IdFilter(I... ids) {
        this.ids = new HashSet<>(Arrays.asList(ids));
    }

    public IdFilter(IdFilter.Builder<I,S> builder) {
        super(builder);
        this.id = builder.id;
        this.ids = builder.ids;
    }


    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public List<I> getIds() {
        return new ArrayList<>(ids);
    }

    public void setIds(Collection<I> ids) {
        this.ids = new HashSet<>(ids);
    }

    @SuppressWarnings(value = "unchecked")
    public void setIds(I... ids) {
        this.ids = new HashSet<>(Arrays.asList(ids));
    }

    @Override
    public String toSort() {
        this.sorts = Collections.singleton(new RestSort("id"));
        return super.toSort();
    }

    public SqlBuilder toSql() {
        if (GeneralUtils.isNotEmpty(this.id)) {
            SqlBuilders.equal(SQL_BUILDER,"id",this.id);
        } else if (GeneralUtils.isNotEmpty(this.ids)) {
            SqlBuilders.in(SQL_BUILDER,"id",this.ids);
        }
        return SQL_BUILDER;
    }

    @Override
    public String toName() {
        String pageName = super.toName();
        StringBuilder nameBuilder = new StringBuilder();
        if (GeneralUtils.isNotEmpty(id)) {
            nameBuilder.append(id).append(PAGE_REGEX);
        }
        if (GeneralUtils.isNotEmpty(ids)) {
            this.ids.forEach(index -> nameBuilder.append(index).append(PAGE_REGEX));
        }
        nameBuilder.append(pageName);
        return nameBuilder.toString();
    }

    public static class Builder<I,S extends IdFilter<I,S>> extends SortFilter.Builder<S> {
        protected I id;
        protected Set<I> ids;

        public Builder() {
        }

        public IdFilter.Builder<I,S> id(I id) {
            this.id = id;
            return this;
        }

        public IdFilter.Builder<I,S> ids(Collection<I> ids) {
            this.ids = new HashSet<>(ids);
            return this;
        }

        @SuppressWarnings(value = "unchecked")
        public IdFilter.Builder<I,S> ids(I... ids) {
            this.ids = new HashSet<>(Arrays.asList(ids));
            return this;
        }

        public IdFilter.Builder<I,S> sorts(Collection<RestSort> sorts) {
            this.sorts = new HashSet<>(sorts);
            return this;
        }

        public IdFilter.Builder<I,S> sorts(RestSort... sorts) {
            this.sorts = new HashSet<>(Arrays.asList(sorts));
            return this;
        }

        public IdFilter.Builder<I,S> pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public IdFilter.Builder<I,S> pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public IdFilter<I,S> build() {
            return new IdFilter<>(this);
        }
    }
}
