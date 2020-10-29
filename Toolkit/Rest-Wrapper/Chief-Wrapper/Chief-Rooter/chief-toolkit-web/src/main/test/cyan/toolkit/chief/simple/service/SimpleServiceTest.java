package cyan.toolkit.chief.simple.service;

import cyan.toolkit.chief.model.RestPage;
import cyan.toolkit.chief.simple.SimpleFilter;
import cyan.toolkit.chief.simple.SimpleModel;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Date;
import java.util.List;


@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SimpleServiceTest {

    @Autowired
    private SimpleService simpleService;

    private static Long id = 0L;

    @Test
    @Order(1)
    public void createTest() throws RestException {
        SimpleModel simpleModel = new SimpleModel();
        simpleModel.setName("name1");
        simpleModel.setDescription("desc1");
        simpleModel.setTime(new Date());
        SimpleModel model = simpleService.create(simpleModel);
        Assertions.assertNotNull(model);
        id = model.getId();
        log.info("model: {}", JsonUtils.parseJson(model));
    }

    @Test
    @Order(2)
    public void saveAllTest() throws RestException {
        SimpleModel simpleModel = new SimpleModel();
        simpleModel.setName("name2");
        simpleModel.setDescription("desc2");
        simpleModel.setTime(new Date());
        List<SimpleModel> simpleModels = simpleService.saveAll(Collections.singletonList(simpleModel));
        Assertions.assertNotNull(simpleModels);
        log.info("model: {}", JsonUtils.parseJson(simpleModels));
    }

    @Test
    @Order(3)
    public void queryTest() throws RestException {
        SimpleModel model = simpleService.queryById(id);
        Assertions.assertNotNull(model);
        log.info("model: {}", JsonUtils.parseJson(model));
    }

    @Test
    @Order(4)
    public void updateTest() throws RestException {
        SimpleModel simpleModel = new SimpleModel(id);
        simpleModel.setName("name1_update");
        simpleService.update(simpleModel);
        SimpleModel query = simpleService.queryById(id);
        Assertions.assertNotNull(query);
        log.info("model: {}", JsonUtils.parseJson(query));
    }

    @Test
    @Order(5)
    public void queryAllTest() throws RestException {
        List<SimpleModel> modelList = simpleService.queryAll(Collections.singletonList(id));
        Assertions.assertNotNull(modelList);
        log.info("models: {}", JsonUtils.parseJson(modelList));
    }


    @Test
    @Order(6)
    public void queryAllFilterTest() throws RestException {
        RestPage<SimpleModel> restPage = simpleService.queryAllWithFilter(new SimpleFilter());
        Assertions.assertNotNull(restPage);
        List<SimpleModel> modelList = restPage.getItems();
        Assertions.assertNotNull(modelList);
        log.info("models: {}", JsonUtils.parseJson(modelList));
    }

    @Test
    @Order(7)
    public void deleteTest() throws RestException {
        simpleService.deleteAllWithFilter(new SimpleFilter());
        RestPage<SimpleModel> restPage = simpleService.queryAllWithFilter(new SimpleFilter());
        List<SimpleModel> modelList = restPage.getItems();
        Assertions.assertTrue(GeneralUtils.isEmpty(modelList));
        log.info("models: {}", JsonUtils.parseJson(modelList));
    }

}