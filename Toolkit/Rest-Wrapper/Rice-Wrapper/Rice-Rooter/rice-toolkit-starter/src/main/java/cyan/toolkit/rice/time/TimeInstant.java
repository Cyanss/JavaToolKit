package cyan.toolkit.rice.time;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

/**
 * <p>TimeInstant</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:13 2020/8/20
 */
public class TimeInstant implements TimeValue {
    
    private Instant instant;

    public TimeInstant() {
        this.instant = Instant.now();
    }

    public TimeInstant(Instant instant) {
        this.instant = instant;
    }

    public TimeInstant(Long value) {
        this.instant = new Date(value).toInstant();
    }

    public TimeInstant(Date value) {
        this.instant = value.toInstant();
    }

    public static TimeInstant now() {
        return new TimeInstant(Instant.now());
    }

    public static TimeInstant parse(String value) {
        return new TimeInstant(Instant.parse(value));
    }

    public static TimeInstant create(Long value) {
        return new TimeInstant(new Date(value).toInstant());
    }

    public static TimeInstant create(Date value) {
        return new TimeInstant(value.toInstant());
    }

    public Instant getInstant() {
        return instant;
    }

    public Date getDate() {
        return Date.from(this.instant);
    }

    public Long getTime() {
        return this.getDate().getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeInstant that = (TimeInstant) o;
        return Objects.equals(instant, that.instant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instant);
    }

    @Override
    public String toString() {
        return this.instant.toString();
    }

    @Override
    public String format() {
        return this.toString();
    }

    @Override
    public Long id() {
        return this.instant.getEpochSecond();
    }
}
