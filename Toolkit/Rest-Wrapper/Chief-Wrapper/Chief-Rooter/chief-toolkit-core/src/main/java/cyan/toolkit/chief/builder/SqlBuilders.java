package cyan.toolkit.chief.builder;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cyan.toolkit.chief.enums.SortType;
import cyan.toolkit.chief.filter.PageFilter;
import cyan.toolkit.chief.filter.SortFilter;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.chief.model.RestSort;
import cyan.toolkit.rest.util.common.GeneralUtils;

import java.util.Collection;

/**
 * <p>SqlBuilders</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:55 2020/9/24
 */
public class SqlBuilders {

    public static SqlBuilder newSqlBuilder() {
        return new SqlBuilder();
    }

    public static SqlBuilder newSqlBuilder(StringBuilder sqlBuilder) {
        return new SqlBuilder(sqlBuilder);
    }

    public static SqlBuilder newSqlBuilder(int capacity) {
        return new SqlBuilder(capacity);
    }

    public static SqlBuilder newSqlBuilder(String str) {
        return new SqlBuilder(str);
    }

    public static SqlBuilder newSqlBuilder(CharSequence seq) {
        return new SqlBuilder(seq);
    }

    public static SqlBuilder in(StringBuilder sqlBuilder, String target, Collection<?> values) {
        return newSqlBuilder(sqlBuilder).in(target, values, true);
    }

    public static void in(SqlBuilder sqlBuilder, String target, Collection<?> values) {
        sqlBuilder.in(target, values, true);
    }

    public static SqlBuilder range(StringBuilder sqlBuilder, String target, Object beginValue, Object endValue) {
        return newSqlBuilder(sqlBuilder).re(target, beginValue, endValue, true);
    }

    public static void range(SqlBuilder sqlBuilder, String target, Object beginValue, Object endValue) {
        sqlBuilder.re(target, beginValue, endValue, true);
    }

    public static SqlBuilder both(StringBuilder sqlBuilder, String target, Object beginValue, Object endValue) {
        return newSqlBuilder(sqlBuilder).reb(target, beginValue, endValue);
    }

    public static void both(SqlBuilder sqlBuilder, String target, Object beginValue, Object endValue) {
        sqlBuilder.reb(target, beginValue, endValue);
    }

    public static SqlBuilder like(StringBuilder sqlBuilder, String target, String value) {
        return newSqlBuilder(sqlBuilder).lk(target, value, true);
    }

    public static void like(SqlBuilder sqlBuilder, String target, String value) {
        sqlBuilder.lk(target, value, true);
    }

    public static SqlBuilder like(StringBuilder sqlBuilder, Collection<String> targets, String value) {
        return newSqlBuilder(sqlBuilder).lk(targets, value, true);
    }

    public static void like(SqlBuilder sqlBuilder, Collection<String> targets, String value) {
        sqlBuilder.lk(targets, value, true);
    }

    public static SqlBuilder equal(StringBuilder sqlBuilder, String target, Object value) {
        return newSqlBuilder(sqlBuilder).eq(target, value, true);
    }

    public static void equal(SqlBuilder sqlBuilder, String target, Object value) {
        sqlBuilder.eq(target, value, true);
    }

    public static SqlBuilder unequal(StringBuilder sqlBuilder, String target, Object value) {
        return newSqlBuilder(sqlBuilder).neq(target, value, true);
    }

    public static void unequal(SqlBuilder sqlBuilder, String target, Object value) {
        sqlBuilder.neq(target, value, true);
    }

    public static SqlBuilder append(StringBuilder sqlBuilder, String sql) {
        return newSqlBuilder(sqlBuilder).append(sql);
    }

    public static void append(SqlBuilder sqlBuilder, String sql) {
        sqlBuilder.append(sql);
    }

    public static SqlBuilder sort(StringBuilder sqlBuilder, String name, SortType type) {
        return newSqlBuilder(sqlBuilder).append(new SortFilter(new RestSort(name,type)).toSort());
    }

    public static void sort(SqlBuilder sqlBuilder, String name, SortType type) {
        sqlBuilder.append(new SortFilter(new RestSort(name,type)).toSort());
    }

    public static SqlBuilder sort(StringBuilder sqlBuilder, RestSort... sorts) {
        return newSqlBuilder(sqlBuilder).append(new SortFilter(sorts).toSort());
    }

    public static void sort(SqlBuilder sqlBuilder, RestSort... sorts) {
        sqlBuilder.append(new SortFilter(sorts).toSort());
    }

    public static SqlBuilder sort(StringBuilder sqlBuilder, SortFilter filter) {
        return newSqlBuilder(sqlBuilder).append(filter.toSort());
    }

    public static void sort(SqlBuilder sqlBuilder, SortFilter filter) {
        sqlBuilder.append(filter.toSort());
    }

    public static <T> Page<T> page(Integer page, Integer size) {
        if (GeneralUtils.isNotEmpty(size)) {
            return PageHelper.startPage(page, size);
        }
        return null;
    }

    public static <T> Page<T> page(PageFilter filter) {
        if (GeneralUtils.isNotEmpty(filter.getPageSize())) {
            return PageHelper.startPage(filter.getPageNum(), filter.getPageSize());
        }
        return null;
    }

    public static <T, K> RestPage<T> result(Collection<T> items, Page<K> page) {
        if (GeneralUtils.isEmpty(page)) {
            return new RestPage<>(items);
        } else {
            RestPage<T> restPage = new RestPage<>();
            if (GeneralUtils.isNotEmpty(items)) {
                restPage.setItems(items);
            }
            restPage.setItemSize((long) page.getResult().size());
            restPage.setPageNum((long) page.getPageNum());
            restPage.setPageSize((long) page.getPageSize());
            restPage.setPages((long) page.getPages());
            restPage.setTotals(page.getTotal());
            return restPage;
        }
    }
}
