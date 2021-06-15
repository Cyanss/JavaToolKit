package cyan.toolkit.zuul.model;

import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.zuul.entity.RouteEntity;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>RouteModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:37 2021/6/8
 */
public class DynamicRoute extends ZuulProperties.ZuulRoute implements Serializable {
    private String name;

    public DynamicRoute() {
    }

    public DynamicRoute(String name) {
        this.name = name;
    }

    public DynamicRoute(String path, String location) {
        super(path,location);
    }

    public DynamicRoute(DynamicRoute.Builder builder) {
        super(builder.path, builder.location);
        this.name = builder.name;
    }

    public boolean isNotEmpty() {
        return GeneralUtils.isNotEmpty(super.getPath()) && GeneralUtils.isNotEmpty(super.getLocation());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RouteEntity toEntity() {
        return new RouteEntity.Builder().name(this.name)
                   .path(super.getPath()).location(super.getLocation()).build();
    }

    public static Map<String,ZuulProperties.ZuulRoute> toZuulRouteMap(Collection<DynamicRoute> routeModels) {
        if (GeneralUtils.isNotEmpty(routeModels)) {
            return routeModels.stream().collect(Collectors.toMap(DynamicRoute::getName, routeModel -> new ZuulProperties.ZuulRoute(routeModel.getPath(),routeModel.getLocation())));
        } else {
            return Collections.emptyMap();
        }
    }

    @Override
    public String toString() {
        return JsonUtils.parseJson(this);
    }

    public static class Builder {
        private String name;
        private String path;
        private String location;

        public Builder() {
        }

        public DynamicRoute.Builder name(String name) {
            this.name = name;
            return this;
        }

        public DynamicRoute.Builder path(String path) {
            this.path = path;
            return this;
        }

        public DynamicRoute.Builder location(String location) {
            this.location = location;
            return this;
        }

        public DynamicRoute build() {
            return new DynamicRoute(this);
        }
    }
}
