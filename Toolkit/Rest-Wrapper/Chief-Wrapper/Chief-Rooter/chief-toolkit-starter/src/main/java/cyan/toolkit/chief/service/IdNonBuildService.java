package cyan.toolkit.chief.service;

import com.github.pagehelper.Page;
import cyan.toolkit.chief.RestService;
import cyan.toolkit.chief.builder.SqlBuilder;
import cyan.toolkit.chief.builder.SqlBuilders;
import cyan.toolkit.chief.entity.IdEntity;
import cyan.toolkit.chief.error.ServiceRealizationException;
import cyan.toolkit.chief.error.ServiceUnknownException;
import cyan.toolkit.chief.filter.IdFilter;
import cyan.toolkit.chief.mapper.IdMapper;
import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.chief.util.MEConvertUtils;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.actuator.BiFunctionActuator;
import cyan.toolkit.rest.actuator.ConsumerActuator;
import cyan.toolkit.rest.actuator.FunctionActuator;
import cyan.toolkit.rest.actuator.MapFunctionActuator;
import cyan.toolkit.rest.error.data.DataQueryException;
import cyan.toolkit.rest.util.common.CheckUtils;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.rice.clazz.RestClazzHelper;
import cyan.toolkit.rice.model.IdModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

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
public abstract class IdNonBuildService<I, D, M extends IdModel<I, M>, E extends IdEntity<I, D, E>, F extends IdFilter<I, F>> implements InitializingBean, ApplicationContextAware, IdCheckService<I, M> {

    private IdNonBuildService<I, D, M, E, F> actuatorService;

    private IdFilterService<I, M, F> consumerService;

    IdMapper<E, I, D, ? extends IdMapper<E, I, D, ?>> consumerMapper;

    private String beanName;

    ConsumerActuator<M> createActuator;

    ConsumerActuator<M> updateActuator;

    protected BiFunctionActuator<M, Boolean, E> entityBiActuator;

    protected MapFunctionActuator<M, Boolean, I, E> entityMapActuator;

    protected FunctionActuator<E, M> modelActuator;

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        IdNonBuildService.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.actuatorService = this;
        applyConsumerService();
        applyConsumerMapper();
        applyServiceActuator();
        if (this.consumerService instanceof ActuatorService) {
            ActuatorService actuatorService = (ActuatorService) this.consumerService;
            actuatorService.applyActuator();
        }
    }

    protected abstract void applyServiceActuator();

    public M create(M model) throws RestException {
        return create(model, (I[]) null);
    }

    @SuppressWarnings(value = "unchecked")
    private E applyEntityActuator(M model,Boolean isInsert,I... idArray) throws RestException {
        E entity;
        if (GeneralUtils.isNotEmpty(entityMapActuator) && this.actuatorService instanceof IdArrayService) {
            entity = entityMapActuator.actuate(model, isInsert, idArray);
        } else if (GeneralUtils.isNotEmpty(entityBiActuator) && this.actuatorService instanceof IdNonArrayService) {
            entity = entityBiActuator.actuate(model, isInsert);
        } else {
            String message = "the service must be realized with 'APPLY_ENTITY_MAP_ACTUATOR' or 'APPLY_ENTITY_BI_ACTUATOR' ";
            throw new ServiceRealizationException(this.actuatorService.getClass().getName(),message);
        }
        return entity;
    }

    @SuppressWarnings(value = "unchecked")
    private List<E> applyEntityActuator(Collection<M> modelList, FunctionActuator<M,Boolean> function, I... idArray) throws RestException {
        List<E> entityList;
        if (GeneralUtils.isNotEmpty(entityMapActuator) && this.actuatorService instanceof IdArrayService) {
            entityList = MEConvertUtils.createEntityList(modelList, function, entityMapActuator,idArray);
        } else if (GeneralUtils.isNotEmpty(entityBiActuator) && this.actuatorService instanceof IdNonArrayService) {
            entityList = MEConvertUtils.createEntityList(modelList, function, entityBiActuator);
        } else {
            String message = "the service must be realized with 'APPLY_ENTITY_MAP_ACTUATOR' or 'APPLY_ENTITY_BI_ACTUATOR' ";
            throw new ServiceRealizationException(this.actuatorService.getClass().getName(),message);
        }
        return entityList;
    }


    @SuppressWarnings(value = "unchecked")
    public M create(M model,I... idArray) throws RestException {
        if (GeneralUtils.isEmpty(model)) {
            return null;
        }
        boolean isInsert = beforeCreate(model);
        E entity = applyEntityActuator(model,isInsert,idArray);
        Integer result = consumerMapper.save(entity);
        String message = "create has error with " + beanName + ": " + JsonUtils.parseJson(model);
        CheckUtils.checkCreate(result, message, beanName);
        return model;
    }

    public M update(M model) throws RestException {
        return update(model, (I[]) null);
    }

    @SuppressWarnings(value = "unchecked")
    public M update(M model,I... idArray) throws RestException {
        if (GeneralUtils.isEmpty(model)) {
            return null;
        }
        boolean isInsert = beforeUpdate(model);
        E entity = applyEntityActuator(model,isInsert,idArray);
        Integer result = consumerMapper.save(entity);
        String message = "update has error with " + beanName + ": " + JsonUtils.parseJson(model);
        CheckUtils.checkUpdate(result, message, beanName);
        return model;
    }

    public List<M> saveAll(Collection<M> modelList) throws RestException {
        return saveAll(modelList, (I[]) null);
    }

    @SuppressWarnings(value = "unchecked")
    public List<M> saveAll(Collection<M> modelList,I... idArray) throws RestException {
        if (GeneralUtils.isEmpty(modelList)) {
            return Collections.emptyList();
        }
        List<E> entityList = applyEntityActuator(modelList,this::beforeSave,idArray);
        Boolean comparer = modelList.size() == consumerMapper.saveAll(entityList);
        CheckUtils.checkBatchSave(comparer, beanName);
        return new ArrayList<>(modelList);
    }

    public void deleteAll(Collection<I> idList) throws RestException {
        if (GeneralUtils.isEmpty(idList)) {
            return;
        }
        consumerMapper.deleteAll(idList);
    }

    public void deleteById(I id) throws RestException {
        if (GeneralUtils.isEmpty(id)) {
            return;
        }
        consumerMapper.deleteById(id);
    }

    public List<M> queryAll(Collection<I> idList, boolean... isLoadArray) throws RestException {
        if (GeneralUtils.isEmpty(idList)) {
            return Collections.emptyList();
        }
        List<E> entityList = consumerMapper.findAll(idList);
        return MEConvertUtils.createModelList(entityList, modelActuator);
    }


    public M queryById(I id, boolean... isLoadArray) throws RestException {
        if (GeneralUtils.isEmpty(id)) {
            return null;
        }
        E entity = consumerMapper.findById(id);
        if (GeneralUtils.isEmpty(entity)) {
            return null;
        }
        return modelActuator.actuate(entity);
    }

    public RestPage<M> queryAllWithFilter(F filter) throws RestException {
        Page<E> page = SqlBuilders.page(filter);
        SqlBuilder sqlBuilder = filter.toSql();
        SqlBuilders.sort(sqlBuilder, filter);
        List<E> entityList = consumerMapper.findAllByWhere(sqlBuilder.toString());
        List<M> modelList = MEConvertUtils.createModelList(entityList, modelActuator);
        return SqlBuilders.result(modelList, page);
    }

    public void deleteAllWithFilter(F filter) throws RestException {
        SqlBuilder sqlBuilder = filter.toSql();
        consumerMapper.deleteAllByWhere(sqlBuilder.toString());
    }

    @SuppressWarnings(value = "unchecked")
    private void applyConsumerMapper() throws ServiceUnknownException {
        String name = this.actuatorService.getClass().getSimpleName();
        if (name.contains("ServiceImpl")) {
            beanName = name.replace("ServiceImpl", "").toLowerCase();
        } else if (name.contains("Service")) {
            beanName = name.replace("Service", "").toLowerCase();
        } else {
            beanName = name.toLowerCase();
        }
        RestService restService = this.actuatorService.getClass().getAnnotation(RestService.class);
        if (GeneralUtils.isNotEmpty(restService)) {
            Class<? extends IdMapper> mapper = restService.mapper();
            if (IdMapper.class.isAssignableFrom(mapper)) {
                this.consumerMapper = applicationContext.getBean(mapper);
            }
        } else {
            this.consumerMapper = applicationContext.getBean("simpleMapper",IdMapper.class);
        }
        if (this.consumerMapper == null) {
            log.error("the service must be realize 'IdFilterService' itself or its children ");
            throw new ServiceUnknownException(IdMapper.class.getName(), this.actuatorService.getClass().getName());
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void applyConsumerService() throws ServiceRealizationException {
        if (this.actuatorService instanceof IdFilterService) {
            this.consumerService = (IdFilterService) this.actuatorService;
        } else {
            log.error("the service must be realize 'IdFilterService' itself or its children ");
            throw new ServiceRealizationException(this.actuatorService.getClass().getName());
        }
    }


    private final ConsumerActuator<M> DEFAULT_CREATE_ACTUATOR = (@NonNull M model) -> {
        model.setId(RestClazzHelper.generate(model));
        if (createActuator != null) {
            createActuator.actuate(model);
        }
        afterCheck(model);
    };

    private final ConsumerActuator<M> DEFAULT_UPDATE_ACTUATOR = (@NonNull M model) -> {
        boolean exist = existById(model.getId());
        String message = "the data no found，id: " + model.getId();
        CheckUtils.checkNonExistResource(exist, message, "id", DataQueryException::new);
        if (updateActuator != null) {
            updateActuator.actuate(model);
        }
        afterCheck(model);
    };


    protected boolean beforeCreate(@NonNull M model) throws RestException {
        if (GeneralUtils.isEmpty(model.getId())) {
            DEFAULT_CREATE_ACTUATOR.actuate(model);
            return true;
        }
        return false;
    }

    protected boolean beforeUpdate(@NonNull M model) throws RestException {
        CheckUtils.checkNullId(model.getId());
        DEFAULT_UPDATE_ACTUATOR.actuate(model);
        return false;
    }

    protected boolean beforeSave(@NonNull M model) throws RestException {
        if (GeneralUtils.isEmpty(model.getId())) {
            DEFAULT_CREATE_ACTUATOR.actuate(model);
            return true;
        } else {
            DEFAULT_UPDATE_ACTUATOR.actuate(model);
            return false;
        }
    }

}
