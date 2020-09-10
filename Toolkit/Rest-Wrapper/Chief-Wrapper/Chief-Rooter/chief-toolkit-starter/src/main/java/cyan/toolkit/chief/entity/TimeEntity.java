package cyan.toolkit.chief.entity;

import javax.persistence.Column;

/**
 * <p>TimeEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:12 2020/8/20
 */
public class TimeEntity {
    /** 数据创建时间 */
    @Column(name = "create_time")
    protected Long createTime;
    /** 数据更新时间 */
    @Column(name = "update_time")
    protected Long updateTime;

    public TimeEntity() {
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
