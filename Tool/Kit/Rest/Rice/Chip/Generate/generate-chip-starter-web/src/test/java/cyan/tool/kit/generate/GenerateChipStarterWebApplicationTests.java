package cyan.tool.kit.generate;

import cyan.tool.kit.generate.core.error.IdentityWorkerException;
import cyan.tool.kit.generate.core.configure.GeneratePropertyConfigure;
import cyan.tool.kit.generate.core.identity.IdentityErrorStatus;
import cyan.tool.kit.generate.core.identity.IdentityGenerate;
import cyan.tool.kit.generate.core.identity.worker.IdentityWorker;
import cyan.tool.kit.generate.core.property.IdentityProperties;
import cyan.tool.kit.rice.core.rice.defaults.RestException;
import cyan.tool.kit.rice.flux.rice.util.supply.RiceJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class GenerateChipStarterWebApplicationTests {
    @Autowired
    IdentityProperties properties;

    @Test
    void test() throws IdentityWorkerException {
        log.info(RiceJsonUtils.parserJson(properties));
        long count = 1L;
        while (count < 100) {

            Long generate = IdentityGenerate.generate(count);
            log.info("【{}】 id: {}",count,generate);
            count++;
        }
    }

}
