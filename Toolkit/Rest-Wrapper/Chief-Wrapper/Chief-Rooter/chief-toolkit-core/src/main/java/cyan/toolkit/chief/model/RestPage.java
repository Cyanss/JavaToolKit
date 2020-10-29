package cyan.toolkit.chief.model;

import cyan.toolkit.rest.util.common.GeneralUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <p>Page</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:44 2020/9/17
 */
public class RestPage<T> implements Serializable {
    /** 总数据量 */
    protected Long totals;
    /** 总页数 */
    protected Long pages;
    /** 当前页码 */
    protected Long pageNum;
    /** 页码大小 */
    protected Long pageSize;
    /** 当前页码大小 */
    protected Long itemSize;
    /** 数据 */
    protected List<T> items = Collections.emptyList();

    public RestPage() {
    }

    public RestPage(Collection<T> items) {
        this.items = new ArrayList<>(items);
    }

    public RestPage(Long totals, Long pageNum, Long pageSize, Collection<T> items) {
        this.totals = totals;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.items = new ArrayList<>(items);
        if (pageSize != null && pageSize > 0L) {
            this.pages = totals / pageSize;
            if (totals % pageSize != 0L) {
                this.pages = this.pages + 1L;
            }
            this.itemSize = GeneralUtils.isEmpty(this.items) ? 0L : (long) items.size();
        } else {
            this.pageNum = 0L;
            this.pages = 0L;
            this.itemSize = 0L;
        }
    }

    public RestPage(RestPage.Builder<T> builder) {
        this.totals = builder.totals;
        this.pages = builder.pages;
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        this.itemSize = builder.itemSize;
        this.items = builder.items;
    }

    public Long getTotals() {
        return totals;
    }

    public void setTotals(Long totals) {
        this.totals = totals;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getItemSize() {
        return itemSize;
    }

    public void setItemSize(Long itemSize) {
        this.itemSize = itemSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(Collection<T> items) {
        this.items = new ArrayList<>(items);
    }

    public static class Builder<T> {
        protected Long totals;
        protected Long pages;
        protected Long pageNum;
        protected Long pageSize;
        protected Long itemSize;
        protected List<T> items = Collections.emptyList();

        public Builder() {
        }

        public RestPage.Builder<T> totals(Long totals) {
            this.totals = totals;
            return this;
        }

        public RestPage.Builder<T> pages(Long pages) {
            this.pages = pages;
            return this;
        }

        public RestPage.Builder<T> pageNum(Long pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public RestPage.Builder<T> size(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public RestPage.Builder<T> itemSize(Long itemSize) {
            this.itemSize = itemSize;
            return this;
        }

        public RestPage.Builder<T> items(Collection<T> items) {
            this.items = new ArrayList<>(items);
            return this;
        }

        public RestPage<T> build() {
            return new RestPage<>(this);
        }
    }
}