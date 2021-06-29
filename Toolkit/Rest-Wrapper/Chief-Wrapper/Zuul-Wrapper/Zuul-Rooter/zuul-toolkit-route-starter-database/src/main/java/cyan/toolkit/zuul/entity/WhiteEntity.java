package cyan.toolkit.token.entity;

import cyan.toolkit.chief.entity.TimeEntity;
import cyan.toolkit.token.route.ZuulStatus;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * <p>WhiteEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 18:03 2021/6/7
 */
@Table(name = "zuul_white_list")
public class WhiteEntity extends TimeEntity<Date> {
    @Id
    private String path;

    private Integer status = ZuulStatus.UPDATE.getKey();

    public WhiteEntity() {
    }

    public WhiteEntity(String path) {
        this.path = path;
    }

    public WhiteEntity(WhiteEntity.Builder builder) {
        super(builder);
        this.path = builder.path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhiteEntity that = (WhiteEntity) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    public static class Builder extends TimeEntity.Builder<Date> {
        protected String path;

        public Builder() {
        }

        public WhiteEntity.Builder path(String path) {
            this.path = path;
            return this;
        }

        public WhiteEntity.Builder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public WhiteEntity.Builder updateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public WhiteEntity build() {
            return new WhiteEntity(this);
        }
    }
}
