package cyan.toolkit.zuul.entity;

import cyan.toolkit.chief.entity.TimeEntity;
import cyan.toolkit.zuul.model.DynamicRoute;
import cyan.toolkit.zuul.route.ZuulStatus;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * <p>RouteEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:43 2021/6/8
 */
@Table(name = "zuul_route_list")
public class RouteEntity extends TimeEntity<Date> {
    @Id
    private String path;

    private String location;

    private String name;

    private Integer status = ZuulStatus.UPDATE.getKey();

    public RouteEntity() {
    }

    public RouteEntity(String path, String location) {
        this.path = path;
        this.location = location;
    }

    public RouteEntity(RouteEntity.Builder builder) {
        super(builder);
        this.name = builder.name;
        this.path = builder.path;
        this.location = builder.location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DynamicRoute toModel() {
        return new DynamicRoute.Builder().name(this.name).path(this.path).location(this.location).build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteEntity that = (RouteEntity) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    public static class Builder extends TimeEntity.Builder<Date> {
        private String path;
        private String location;
        private String name;

        public Builder() {
        }

        public RouteEntity.Builder path(String path) {
            this.path = path;
            return this;
        }

        public RouteEntity.Builder location(String location) {
            this.location = location;
            return this;
        }

        public RouteEntity.Builder name(String name) {
            this.name = name;
            return this;
        }

        public RouteEntity.Builder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public RouteEntity.Builder updateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public RouteEntity build() {
            return new RouteEntity(this);
        }
    }
}
