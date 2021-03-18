package cyan.toolkit.chief;

import cyan.toolkit.chief.filter.TimeFilter;
import org.springframework.lang.NonNull;

import java.util.Date;

/**
 * <p>RestFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:47 2020/11/3
 */
public abstract class ChiefFilter extends TimeFilter<Date,Long> {
    public ChiefFilter() {
    }

    public ChiefFilter(Long... ids) {
        super(ids);
    }

    public ChiefFilter(Builder<Date, Long> builder) {
        super(builder);
    }

    @Override
    public ChiefFilter toTimeSql(@NonNull String alias) {
        super.toTimeSql(alias);
        return this;
    }

    @Override
    public ChiefFilter toIdSql(@NonNull String alias) {
        super.toIdSql(alias);
        return this;
    }
}
