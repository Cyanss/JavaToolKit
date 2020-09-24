package cyan.toolkit.chief.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cyan.toolkit.rest.util.common.JsonUtils;

import java.io.Serializable;

/**
 * <p>PageFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:20 2020/9/9
 */
public class PageFilter implements Serializable {
    @JsonIgnore
    public static final String PAGE_REGEX = "_";
    @JsonIgnore
    public static final String PAGE_LIMIT = "LIMIT";
    @JsonIgnore
    public static final String PAGE_OFFSET = "OFFSET";
    protected Integer pageNum = 1;
    protected Integer pageSize;

    public PageFilter() {
    }

    public PageFilter(PageFilter.Builder builder) {
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum > 0) {
            this.pageNum = pageNum;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return JsonUtils.parseJson(this);
    }

    public String toPage() {
        return PAGE_LIMIT + " " + this.pageSize +
                PAGE_OFFSET + " " + (this.pageNum - 1);
    }

    public String toName() {
        return this.pageNum + PAGE_REGEX + this.pageSize;
    }

    public static class Builder {
        protected Integer pageNum;
        protected Integer pageSize;
        public Builder() {
        }

        public PageFilter.Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public PageFilter.Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public PageFilter build() {
            return new PageFilter(this);
        }
    }

}
