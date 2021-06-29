package cyan.toolkit.token.service.impl;

import com.github.pagehelper.Page;
import cyan.toolkit.chief.builder.SqlBuilders;
import cyan.toolkit.chief.filter.PageFilter;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.token.DynamicRoute;
import cyan.toolkit.token.entity.RouteEntity;
import cyan.toolkit.token.entity.WhiteEntity;
import cyan.toolkit.token.mapper.RouteMapper;
import cyan.toolkit.token.route.ZuulStatus;
import cyan.toolkit.token.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>RouteServiceImpl</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:50 2021/6/8
 */
@Slf4j
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteMapper routeMapper;

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public DynamicRoute save(DynamicRoute model) {
        if (GeneralUtils.isNotEmpty(model) && model.isNotEmpty()) {
            routeMapper.save(RouteEntity.toEntity(model));
        }
        return model;
    }

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public List<DynamicRoute> saveAll(Collection<DynamicRoute> modelList) {
        if (GeneralUtils.isNotEmpty(modelList)) {
            Set<RouteEntity> entitySet = modelList.stream().filter(GeneralUtils::isNotEmpty)
                    .filter(DynamicRoute::isNotEmpty).map(RouteEntity::toEntity).collect(Collectors.toSet());
            routeMapper.saveAll(entitySet);
            return entitySet.stream().map(RouteEntity::toModel).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public void deleteAll(Collection<String> pathList) {
        if (GeneralUtils.isNotEmpty(pathList)) {
            Set<String> pathSet = pathList.stream().filter(GeneralUtils::isNotEmpty).collect(Collectors.toSet());
            routeMapper.deleteAll(pathSet);
        }
    }

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public void deleteById(String path) {
        if (GeneralUtils.isNotEmpty(path)) {
            routeMapper.deleteById(path);
        }
    }

    @Override
    public List<DynamicRoute> queryAll(Collection<String> pathList) {
        List<RouteEntity> entityList;
        if (GeneralUtils.isEmpty(pathList)) {
            entityList = routeMapper.findAllByWhere(null);
        } else {
            Set<String> pathSet = pathList.stream().filter(GeneralUtils::isNotEmpty).collect(Collectors.toSet());
            entityList = routeMapper.findAll(pathSet);
        }
        return Optional.ofNullable(entityList).map(lists -> lists.stream().map(RouteEntity::toModel).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    @Override
    public DynamicRoute queryById(String path) {
        if (GeneralUtils.isNotEmpty(path)) {
            RouteEntity entity = routeMapper.findById(path);
            return Optional.ofNullable(entity).map(RouteEntity::toModel).orElse(null);
        }
        return null;
    }

    @Override
    public RestPage<DynamicRoute> queryAllWithFilter(PageFilter filter) {
        Page<WhiteEntity> page = SqlBuilders.page(filter);
        List<RouteEntity> entityList = routeMapper.findAllByWhere(null);
        List<DynamicRoute> pathList = Optional.ofNullable(entityList).map(lists -> lists.stream().map(RouteEntity::toModel).collect(Collectors.toList())).orElse(Collections.emptyList());
        return RestPage.result(pathList,page);
    }

    @Override
    public Boolean isNeedRefresh() {
        return GeneralUtils.isNotEmpty(routeMapper.findAllByNotStatus());
    }

    @Override
    public List<DynamicRoute> queryAllWithStatus(ZuulStatus status) {
        List<RouteEntity> entityList = routeMapper.findAllByStatus(status.getKey());
        return Optional.ofNullable(entityList).map(lists -> lists.stream().map(RouteEntity::toModel).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    @Override
    public Integer updateAll() {
        return routeMapper.alertAllByStatus();
    }

    @Override
    public Integer removeAll() {
        return routeMapper.deleteAllByStatus();
    }
}
