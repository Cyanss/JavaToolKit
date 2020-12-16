package cyan.toolkit.chief.service;

import com.github.pagehelper.Page;
import cyan.toolkit.chief.entity.IdEntity;
import cyan.toolkit.chief.error.ServiceUnknownException;
import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.chief.helper.MEBuilderHelper;
import cyan.toolkit.chief.mapper.IdMapper;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.chief.service.stereotype.RestService;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.actuator.ConsumerActuator;
import cyan.toolkit.rest.actuator.FunctionActuator;
import cyan.toolkit.rest.error.data.DataQueryException;
import cyan.toolkit.rest.helper.OptionalHelper;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.rice.clazz.RestClazzHelper;
import cyan.toolkit.rice.model.IdModel;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <p>NoIdBuildService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:47 2020/9/23
 */
@Slf4j
@Builder
public abstract class SupperService<I, D, M extends IdModel<I>, E extends IdEntity<I, D>, F extends IdFilter<I>> 
        implements InitializingBean, ApplicationContextAware, OptionalService<I, M>, ServiceAdvice<I, F> {

    private static ApplicationContext applicationContext;

    protected ConsumerActuator<M> createActuator;

    protected ConsumerActuator<M> updateActuator;

    protected IdMapper<E, I, D> supperMapper;

    private String simpleName;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        SupperService.applicationContext = applicationContext;
    }

    @SuppressWarnings(value = "unchecked")
    @Override
    public void afterPropertiesSet() throws Exception {
        String commonBeanName;
        simpleName = this.getClass().getSimpleName();
        if (simpleName.contains("ServiceImpl")) {
            commonBeanName = simpleName.replace("ServiceImpl", "");
        } else if (simpleName.contains("Service")) {
            commonBeanName = simpleName.replace("Service", "");
        } else {
            commonBeanName = simpleName;
        }
        String lowerBeanName = commonBeanName.toLowerCase();
        RestService service = this.getClass().getAnnotation(RestService.class);
        if (GeneralUtils.isNotEmpty(service)) {
            Class<? extends IdMapper> mapper = service.mapper();
            if (IdMapper.class.isAssignableFrom(mapper)) {
                this.supperMapper = applicationContext.getBean(mapper);
            }
        } else {
            try {
                String mapperName = commonBeanName.concat("Mapper");
                this.supperMapper = applicationContext.getBean(mapperName, IdMapper.class);
            } catch (BeansException exception) {
                log.warn(exception.getMessage());
                try {
                    String lowerMapperName = lowerBeanName.concat("Mapper");
                    this.supperMapper = applicationContext.getBean(lowerMapperName, IdMapper.class);
                } catch (BeansException exception1) {
                    String message = "the service and mapper name must be like 'xxxService'/'xxxServiceImpl' and 'xxxMapper'";
                    log.error(message);
                    throw new ServiceUnknownException(IdMapper.class.getName(), this.getClass().getName(),message,exception1);
                }
            }
        }
        this.doServiceHandle();
    }
    @SuppressWarnings(value = "unchecked")
    private E entityActuator(M model, Boolean isInsert, I... idArray) throws RestException {
        E entity = this.createEntity(model, isInsert);
        if (this instanceof BuilderAdvice) {
            BuilderAdvice builderAdvice = (BuilderAdvice) this;
            builderAdvice.buildEntity(model,entity,idArray);
        }
        return entity;
    }

    @SuppressWarnings(value = "unchecked")
    private List<E> entityActuator(Collection<M> modelList, FunctionActuator<M, Boolean> function, I... idArray) throws RestException {
        List<E> entityList;
        if (this instanceof BuilderAdvice) {
            BuilderAdvice builderAdvice = (BuilderAdvice) this;
            try {
                Method buildMethod = builderAdvice.getClass().getMethod("buildEntity");
                Method buildListMethod = builderAdvice.getClass().getMethod("buildEntityList");
                /** 当buildEntity和buildEntityList都被复写的时候 优先调用buildEntityList */
                entityList = MEBuilderHelper.entityList(modelList, function, (M model, Boolean isInsert) -> {
                    E entity = createEntity(model, isInsert);
                    if (buildListMethod.isDefault() && !buildMethod.isDefault()) {
                        builderAdvice.buildEntity(model,entity, idArray);
                    }
                    return entity;
                });
                if (!buildListMethod.isDefault()) {
                    builderAdvice.buildEntityList(modelList, entityList, idArray);
                }
            } catch (NoSuchMethodException ignored) {
                entityList = MEBuilderHelper.entityList(modelList, function, this::createEntity);
            }
        } else {
            entityList = MEBuilderHelper.entityList(modelList, function, this::createEntity);
        }
        return entityList;
    }

    @SuppressWarnings(value = "unchecked")
    private M modelActuator(E entity, Boolean... isLoadArray) throws RestException {
        M model = this.createModel(entity);
        if (this instanceof BuilderAdvice) {
            BuilderAdvice builderAdvice = (BuilderAdvice) this;
            builderAdvice.buildModel(entity,model, isLoadArray);
        }
        return model;
    }

    @SuppressWarnings(value = "unchecked")
    private List<M> modelActuator(Collection<E> entityList, Boolean... isLoadArray) throws RestException {
        List<M> modelList;
        if (this instanceof BuilderAdvice) {
            BuilderAdvice builderAdvice = (BuilderAdvice) this;
            try {
                Method buildMethod = builderAdvice.getClass().getMethod("buildModel");
                Method buildListMethod = builderAdvice.getClass().getMethod("buildModelList");
                /** 当buildModel和buildModelList都被复写的时候 优先调用buildModelList */
                modelList = MEBuilderHelper.modelList(entityList, (E entity) -> {
                    M model = this.createModel(entity);
                    if (buildListMethod.isDefault() && !buildMethod.isDefault()) {
                        builderAdvice.buildModel(entity, model, isLoadArray);
                    }
                    return model;
                });
                if (!buildListMethod.isDefault()) {
                    builderAdvice.buildModelList(entityList, modelList, isLoadArray);
                }
            } catch (NoSuchMethodException ignored) {
                modelList = MEBuilderHelper.modelList(entityList, this::createModel);
            }
        } else {
            modelList = MEBuilderHelper.modelList(entityList, this::createModel);
        }
        return modelList;
    }

    protected abstract E createEntity(M model, Boolean isInsert);

    protected abstract M createModel(E entity);

    public M create(M model) throws RestException {
        return create(model, (I[]) null);
    }

    @SuppressWarnings(value = "unchecked")
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public M create(M model, I... idArray) throws RestException {
        if (GeneralUtils.isEmpty(model)) {
            return null;
        }
        boolean isInsert = OptionalCreate(model);
        E entity = entityActuator(model, isInsert, idArray);
        Integer result = supperMapper.save(entity);
        String message = "creating method has error with " + simpleName + ": " + JsonUtils.parseJson(model);
        OptionalHelper.create(result, message, simpleName);
        return model;
    }

    public M update(M model) throws RestException {
        return update(model, (I[]) null);
    }

    @SuppressWarnings(value = "unchecked")
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public M update(M model, I... idArray) throws RestException {
        if (GeneralUtils.isEmpty(model)) {
            return null;
        }
        boolean isInsert = OptionalUpdate(model);
        E entity = entityActuator(model, isInsert, idArray);
        Integer result = supperMapper.save(entity);
        String message = "updating method has error with " + simpleName + ": " + JsonUtils.parseJson(model);
        OptionalHelper.update(result, message, simpleName);
        return model;
    }

    public M save(M model) throws RestException {
        return save(model, (I[]) null);
    }

    @SuppressWarnings(value = "unchecked")
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public M save(M model, I... idArray) throws RestException {
        if (GeneralUtils.isEmpty(model)) {
            return null;
        }
        boolean isInsert = OptionalSave(model);
        E entity = entityActuator(model, isInsert, idArray);
        Integer result = supperMapper.save(entity);
        String message = "saving method has error with " + simpleName + ": " + JsonUtils.parseJson(model);
        OptionalHelper.save(result, message, simpleName);
        return model;
    }

    public List<M> saveAll(Collection<M> modelList) throws RestException {
        return saveAll(modelList, (I[]) null);
    }

    @SuppressWarnings(value = "unchecked")
    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public List<M> saveAll(Collection<M> modelList, I... idArray) throws RestException {
        if (GeneralUtils.isEmpty(modelList)) {
            return Collections.emptyList();
        }
        List<E> entityList = entityActuator(modelList, this::OptionalSave, idArray);
        Boolean comparer = modelList.size() == supperMapper.saveAll(entityList);
        String message = "saveAll method has error with " + simpleName + ": " + JsonUtils.parseJson(modelList);
        OptionalHelper.saveAll(comparer, message, simpleName);
        return new ArrayList<>(modelList);
    }

    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public void deleteById(I id) throws RestException {
        if (GeneralUtils.isEmpty(id)) {
            return;
        }
        supperMapper.deleteById(id);
    }

    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public void deleteAll(Collection<I> idList) throws RestException {
        if (GeneralUtils.isEmpty(idList)) {
            return;
        }
        supperMapper.deleteAll(idList);
    }

    public M queryById(I id, Boolean... isLoadArray) throws RestException {
        if (GeneralUtils.isEmpty(id)) {
            return null;
        }
        E entity = supperMapper.findById(id);
        if (GeneralUtils.isEmpty(entity)) {
            return null;
        }
        return modelActuator(entity, isLoadArray);
    }

    public List<M> queryAll(Collection<I> idList, Boolean... isLoadArray) throws RestException {
        if (GeneralUtils.isEmpty(idList)) {
            return Collections.emptyList();
        }
        List<E> entityList = supperMapper.findAll(idList);
        return modelActuator(entityList, isLoadArray);
    }

    public RestPage<M> queryAllWithFilter(F filter) throws RestException {
        String whereSql = queryWhereSql(filter);
        Boolean[] isLoadArray = loadArray(filter);
        Page<E> page = filter.toPage();
        List<E> entityList = supperMapper.findAllByWhere(whereSql);
        List<M> modelList = modelActuator(entityList, isLoadArray);
        return RestPage.result(modelList, page);
    }

    @Transactional(rollbackFor = {RestException.class, SQLException.class})
    public void deleteAllWithFilter(F filter) throws RestException {
        String whereSql = deleteWhereSql(filter);
        supperMapper.deleteAllByWhere(whereSql);
    }

    private final ConsumerActuator<M> DEFAULT_CREATE_ACTUATOR = (@NonNull M model) -> {
        model.setId(RestClazzHelper.generate(model));
        if (createActuator != null) {
            createActuator.actuate(model);
        }
        optional(model);
    };

    private final ConsumerActuator<M> DEFAULT_UPDATE_ACTUATOR = (@NonNull M model) -> {
        boolean exist = existById(model.getId());
        String message = "the data no found，id: " + model.getId();
        OptionalHelper.falseable(exist, message, "id", DataQueryException::new);
        if (updateActuator != null) {
            updateActuator.actuate(model);
        }
        optional(model);
    };

    protected boolean OptionalCreate(@NonNull M model) throws RestException {
        if (GeneralUtils.isEmpty(model.getId())) {
            DEFAULT_CREATE_ACTUATOR.actuate(model);
            return true;
        }
        return false;
    }

    protected boolean OptionalUpdate(@NonNull M model) throws RestException {
        OptionalHelper.idable(model.getId());
        DEFAULT_UPDATE_ACTUATOR.actuate(model);
        return false;
    }

    protected boolean OptionalSave(@NonNull M model) throws RestException {
        if (GeneralUtils.isEmpty(model.getId())) {
            DEFAULT_CREATE_ACTUATOR.actuate(model);
            return true;
        } else {
            DEFAULT_UPDATE_ACTUATOR.actuate(model);
            return false;
        }
    }
}
