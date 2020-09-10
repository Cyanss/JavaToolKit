package cyan.toolkit.chief.filter;

/**
 * <p>PageFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:20 2020/9/9
 */
public class PageFilter {
    public static final String PAGE_REGEX = "_";
    public static final String PAGE_LIMIT = "LIMIT";
    public static final String PAGE_OFFSET = "OFFSET";
    protected Integer page = 1;
    protected Integer size;

    public PageFilter() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page > 0) {
            this.page = page;
        }
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return toPageSql();
    }

    public String toPageSql() {
        return PAGE_LIMIT + " " + this.size +
                PAGE_OFFSET + " " + (this.page - 1);
    }

    public String toName() {
        return this.page + PAGE_REGEX + this.size;
    }
}
