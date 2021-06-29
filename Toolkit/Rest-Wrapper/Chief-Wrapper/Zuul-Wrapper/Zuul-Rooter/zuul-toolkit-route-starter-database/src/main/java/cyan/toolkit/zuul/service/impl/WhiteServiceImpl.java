package cyan.toolkit.token.service.impl;

import com.github.pagehelper.Page;
import cyan.toolkit.chief.builder.SqlBuilders;
import cyan.toolkit.chief.filter.PageFilter;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.token.entity.WhiteEntity;
import cyan.toolkit.token.mapper.WhiteMapper;
import cyan.toolkit.token.route.ZuulStatus;
import cyan.toolkit.token.service.WhiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>WhiteServiceImpl</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:51 2021/6/8
 */
@Slf4j
@Service
public class WhiteServiceImpl implements WhiteService {

    @Autowired
    private WhiteMapper whiteMapper;

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public String save(String model) {
        if (GeneralUtils.isNotEmpty(model)) {
            whiteMapper.save(new WhiteEntity(model));
        }
        return model;
    }

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public List<String> saveAll(Collection<String> modelList) {
        if (GeneralUtils.isNotEmpty(modelList)) {
            Set<WhiteEntity> entitySet = modelList.stream().filter(GeneralUtils::isNotEmpty).map(WhiteEntity::new).collect(Collectors.toSet());
            whiteMapper.saveAll(entitySet);
            return entitySet.stream().map(WhiteEntity::getPath).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public void deleteAll(Collection<String> pathList) {
        if (GeneralUtils.isNotEmpty(pathList)) {
            Set<String> pathSet = pathList.stream().filter(GeneralUtils::isNotEmpty).collect(Collectors.toSet());
            whiteMapper.deleteAll(pathSet);
        }
    }

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public void deleteById(String path) {
        if (GeneralUtils.isNotEmpty(path)) {
            whiteMapper.deleteById(path);
        }
    }

    @Override
    public List<String> queryAll(Collection<String> pathList) {
        List<WhiteEntity> entityList;
        if (GeneralUtils.isNotEmpty(pathList)) {
            Set<String> pathSet = pathList.stream().filter(GeneralUtils::isNotEmpty).collect(Collectors.toSet());
            entityList = whiteMapper.findAll(pathSet);
        } else {
            entityList = whiteMapper.findAllByWhere(null);
        }
        return Optional.ofNullable(entityList).map(lists -> lists.stream().map(WhiteEntity::getPath).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    @Override
    public String queryById(String path) {
        if (GeneralUtils.isNotEmpty(path)) {
            WhiteEntity entity = whiteMapper.findById(path);
            return Optional.ofNullable(entity).map(WhiteEntity::getPath).orElse(null);
        }
        return null;
    }

    @Override
    public RestPage<String> queryAllWithFilter(PageFilter filter) {
        Page<WhiteEntity> page = SqlBuilders.page(filter);
        List<WhiteEntity> entityList = whiteMapper.findAllByWhere(null);
        List<String> pathList = Optional.ofNullable(entityList).map(lists -> lists.stream().map(WhiteEntity::getPath).collect(Collectors.toList())).orElse(Collections.emptyList());
        return RestPage.result(pathList,page);
    }

    @Override
    public Boolean isNeedRefresh() {
        return GeneralUtils.isNotEmpty(whiteMapper.findAllByNotStatus());
    }

    @Override
    public List<String> queryAllWithStatus(ZuulStatus status) {
        List<WhiteEntity> entityList = whiteMapper.findAllByStatus(status.getKey());
        return Optional.ofNullable(entityList).map(lists -> lists.stream().map(WhiteEntity::getPath).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    @Override
    public Integer updateAll(){
        return whiteMapper.alertAllByStatus();
    }

    @Override
    public Integer removeAll() {
        return whiteMapper.deleteAllByStatus();
    }
}
