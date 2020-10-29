package cyan.toolkit.chief.simple.service;

import com.github.pagehelper.Page;
import cyan.toolkit.chief.builder.SqlBuilder;
import cyan.toolkit.chief.builder.SqlBuilders;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.chief.service.InfoNonBuildService;
import cyan.toolkit.chief.simple.SimpleEntity;
import cyan.toolkit.chief.simple.SimpleFilter;
import cyan.toolkit.chief.simple.SimpleModel;
import cyan.toolkit.chief.simple.mapper.SimpleMapper;
import cyan.toolkit.chief.util.MEConvertUtils;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.CheckUtils;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>SimpleServiceImpl</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:50 2020/9/24
 */
@Service
public class SimpleServiceImpl extends InfoNonBuildService<Long, Date, SimpleModel, SimpleEntity> implements SimpleService {

    @Autowired
    private SimpleMapper simpleMapper;
    
    @Override
    public SimpleModel create(SimpleModel simple) throws RestException {
        if (GeneralUtils.isEmpty(simple)) {
            return null;
        }
        boolean isInsert = beforeCreate(simple);
        SimpleEntity entity = SimpleEntity.toEntity(simple,isInsert);
        Integer result = simpleMapper.save(entity);
        String message = "创建失败！simple: " + JsonUtils.parseJson(simple);
        CheckUtils.checkCreate(result, message,"simple");
        return simple;
    }

    @Override
    public SimpleModel update(SimpleModel simple) throws RestException {
        if (GeneralUtils.isEmpty(simple)) {
            return null;
        }
        boolean isInsert = beforeUpdate(simple);
        SimpleEntity entity = SimpleEntity.toEntity(simple,isInsert);
        Integer result = simpleMapper.save(entity);
        String message = "更新失败！simple: " + JsonUtils.parseJson(simple);
        CheckUtils.checkUpdate(result,  message,"simple");
        return simple;
    }

    @Override
    public List<SimpleModel> saveAll(Collection<SimpleModel> simpleList) throws RestException {
        if (GeneralUtils.isEmpty(simpleList)) {
            return Collections.emptyList();
        }
        List<SimpleEntity> entityList = MEConvertUtils.createEntityList(simpleList,this::beforeSave,SimpleEntity::toEntity);
        Boolean comparer = simpleList.size() == simpleMapper.saveAll(entityList);
        CheckUtils.checkBatchSave(comparer,"simple");
        return new ArrayList<>(simpleList);
    }

    @Override
    public void deleteAll(Collection<Long> idList) throws RestException {
        if (GeneralUtils.isEmpty(idList)) {
            return;
        }
        simpleMapper.deleteAll(idList);
    }

    @Override
    public void deleteById(Long id) throws RestException {
        if (GeneralUtils.isEmpty(id)) {
            return;
        }
        simpleMapper.deleteById(id);
    }

    @Override
    public List<SimpleModel> queryAll(Collection<Long> idList, boolean... isLoadArray) throws RestException {
        if (GeneralUtils.isEmpty(idList)) {
            return Collections.emptyList();
        }
        List<SimpleEntity> entityList = simpleMapper.findAll(idList);
        return MEConvertUtils.createModelList(entityList,SimpleEntity::toModel);
    }

    @Override
    public SimpleModel queryById(Long id, boolean... isLoadArray) throws RestException {
        if (GeneralUtils.isEmpty(id)) {
            return null;
        }
        SimpleEntity entity = simpleMapper.findById(id);
        if (GeneralUtils.isEmpty(entity)) {
            return null;
        }
        return SimpleEntity.toModel(entity);
    }

    @Override
    public RestPage<SimpleModel> queryAllWithFilter(SimpleFilter filter) throws RestException {
        Page<SimpleEntity> page = SqlBuilders.page(filter);
        SqlBuilder sqlBuilder = filter.toSql();
        SqlBuilders.sort(sqlBuilder,filter);
        List<SimpleEntity> entityList = simpleMapper.findAllByWhere(sqlBuilder.toString());
        List<SimpleModel> modelList = MEConvertUtils.createModelList(entityList, SimpleEntity::toModel);
        return SqlBuilders.result(modelList,page);
    }

    @Override
    public void deleteAllWithFilter(SimpleFilter filter) throws RestException {
        SqlBuilder sqlBuilder = filter.toSql();
        simpleMapper.deleteAllByWhere(sqlBuilder.toString());
    }

    @Override
    protected Boolean existByName(String name) throws RestException {
        if (GeneralUtils.isEmpty(name)) {
            return false;
        }
        List<SimpleEntity> entityList = simpleMapper.findByName(name);
        return GeneralUtils.isNotEmpty(entityList);
    }

    @Override
    protected Boolean existByNameAndNotId(String name, Long id) throws RestException {
        if (GeneralUtils.isEmpty(name)) {
            return false;
        }
        if (GeneralUtils.isEmpty(id)) {
            return existByName(name);
        }
        List<SimpleEntity> entityList = simpleMapper.findByNameAndNotId(name, id);
        return GeneralUtils.isNotEmpty(entityList);
    }
    
}
