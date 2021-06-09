package cyan.toolkit.widget.service.impl;

import com.github.pagehelper.Page;
import cyan.toolkit.chief.builder.SqlBuilders;
import cyan.toolkit.chief.filter.PageFilter;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.widget.entity.WhiteEntity;
import cyan.toolkit.widget.mapper.WhiteMapper;
import cyan.toolkit.widget.service.WhiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    public String save(String model) throws RestException {
        if (GeneralUtils.isNotEmpty(model)) {
            whiteMapper.save(new WhiteEntity(model));
        }
        return model;
    }

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public List<String> saveAll(Collection<String> modelList) throws RestException {
        if (GeneralUtils.isNotEmpty(modelList)) {
            Set<WhiteEntity> entitySet = modelList.stream().filter(GeneralUtils::isNotEmpty).map(WhiteEntity::new).collect(Collectors.toSet());
            whiteMapper.saveAll(entitySet);
            return entitySet.stream().map(WhiteEntity::getPath).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public void deleteAll(Collection<String> pathList) throws RestException {
        if (GeneralUtils.isNotEmpty(pathList)) {
            Set<String> pathSet = pathList.stream().filter(GeneralUtils::isNotEmpty).collect(Collectors.toSet());
            whiteMapper.deleteAll(pathSet);
        }
    }

    @Override
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public void deleteById(String path) throws RestException {
        if (GeneralUtils.isNotEmpty(path)) {
            whiteMapper.deleteById(path);
        }
    }

    @Override
    public List<String> queryAll(Collection<String> pathList) throws RestException {
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
    public String queryById(String path) throws RestException {
        if (GeneralUtils.isNotEmpty(path)) {
            WhiteEntity entity = whiteMapper.findById(path);
            return Optional.ofNullable(entity).map(WhiteEntity::getPath).orElse(null);
        }
        return null;
    }

    @Override
    public RestPage<String> queryAllWithFilter(PageFilter filter) throws RestException {
        Page<WhiteEntity> page = SqlBuilders.page(filter);
        List<WhiteEntity> entityList = whiteMapper.findAllByWhere(null);
        List<String> pathList = Optional.ofNullable(entityList).map(lists -> lists.stream().map(WhiteEntity::getPath).collect(Collectors.toList())).orElse(Collections.emptyList());
        return RestPage.result(pathList,page);
    }

    @Override
    public List<String> queryAllNew() throws RestException {
        List<WhiteEntity> entityList = whiteMapper.findAllByStatus();
        return Optional.ofNullable(entityList).map(lists -> lists.stream().map(WhiteEntity::getPath).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    @Override
    public Integer updateAllNew() throws RestException {
        return whiteMapper.alertAllByStatus();
    }
}
