package cyan.toolkit.cloud.service;

import cyan.toolkit.rest.DefaultResult;
import cyan.toolkit.rest.RestResult;
import cyan.toolkit.rice.model.InfoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>DefaultService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:12 2020/8/14
 */
@FeignClient(value = "cloud-web")
@RequestMapping("/default")
public interface DefaultService {
    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RestResult<InfoModel>> post(@RequestBody InfoModel infoModel);

    @GetMapping(value = "/get/{id}")
    ResponseEntity<RestResult<InfoModel>> get(@PathVariable(value = "id")  Long id);

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<RestResult<String>> delete(@PathVariable(value = "id") Long id);

    @GetMapping(value = "test")
    ResponseEntity<RestResult> test();
}
