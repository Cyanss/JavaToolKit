package cyan.toolkit.chief.entity;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * <p>TimeEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:12 2020/8/20
 */
public class TimeEntity<D> implements Serializable {
    /** 数据创建时间 */
    @Column(name = "create_time")
    protected D createTime;
    /** 数据更新时间 */
    @Column(name = "update_time")
    protected D updateTime;

    public TimeEntity() {
    }

    public TimeEntity(TimeEntity.Builder<D> builder) {
        this.createTime = builder.createTime;
        this.updateTime = builder.updateTime;
    }

    public D getCreateTime() {
        return createTime;
    }

    public void setCreateTime(D createTime) {
        this.createTime = createTime;
    }

    public D getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(D updateTime) {
        this.updateTime = updateTime;
    }

    public static class Builder<D> {
        protected D createTime;
        protected D updateTime;

        public Builder() {
        }

        public TimeEntity.Builder<D> createTime(D createTime) {
            this.createTime = createTime;
            return this;
        }

        public TimeEntity.Builder<D> updateTime(D updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public TimeEntity<D> build() {
            return new TimeEntity<>(this);
        }
    }
}
