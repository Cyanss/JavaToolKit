package cyan.tool.kit.chip.flux;

import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.defaults.RestException;
import cyan.tool.kit.chip.core.rice.rest.RestStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class ChipRiceFluxApplication {

    public static void main(String[] args) throws RestException {
        try {
            throw new RestErrorException();
        } catch (RestErrorException e) {
            throw new RestException(e);
        }
//        SpringApplication.run(ChipRiceFluxApplication.class, args);
    }

}
