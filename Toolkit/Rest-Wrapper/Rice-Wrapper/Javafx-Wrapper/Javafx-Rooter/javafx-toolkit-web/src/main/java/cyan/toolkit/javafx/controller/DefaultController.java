package cyan.toolkit.cloud.controller;

import cyan.toolkit.rest.DefaultResult;
import cyan.toolkit.rest.RestResult;
import cyan.toolkit.rice.model.InfoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>DefaultController</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 12:01 2020/8/14
 */
@CrossOrigin
@RestController
@RequestMapping("/default")
public class DefaultController {
    @PostMapping("/post")
    public ResponseEntity<RestResult<InfoModel>> post(@RequestBody InfoModel infoModel) {
        return RestResult.ok(infoModel);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RestResult<InfoModel>> get(@PathVariable Long id) {
        return RestResult.ok(new InfoModel<>(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResult<String>> delete(@PathVariable Long id) {
        return RestResult.ok("删除成功！id: ".concat(String.valueOf(id)));
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        return RestResult.ok();
    }
}
