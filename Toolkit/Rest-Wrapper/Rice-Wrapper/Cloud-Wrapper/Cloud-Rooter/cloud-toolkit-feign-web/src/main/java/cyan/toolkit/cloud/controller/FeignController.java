package cyan.toolkit.cloud.controller;

import cyan.toolkit.cloud.service.DefaultService;
import cyan.toolkit.rest.DefaultResult;
import cyan.toolkit.rest.RestResult;
import cyan.toolkit.rest.util.JsonUtils;
import cyan.toolkit.rice.model.InfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * <p>FeignController</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:28 2020/8/14
 */
@CrossOrigin
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private DefaultService defaultService;

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/post")
    public ResponseEntity post(@RequestBody InfoModel infoModel) {
        return defaultService.post(infoModel);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable(value = "id")  Long id) {
        return  defaultService.get(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<RestResult<String>> delete(@PathVariable(value = "id")  Long id) {
        return defaultService.delete(id);
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        ResponseEntity<RestResult> forEntity = restTemplate.getForEntity("http://cloud-web/default/test", RestResult.class);
        return RestResult.ok(forEntity.getBody());
    }
}
