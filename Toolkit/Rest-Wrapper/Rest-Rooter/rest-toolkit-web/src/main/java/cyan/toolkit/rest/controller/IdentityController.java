package cyan.toolkit.rest.controller;

import cyan.toolkit.rest.RestIntercept;
import cyan.toolkit.rest.RestResult;
import cyan.toolkit.rest.identity.IdentityUtils;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.util.common.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>IdentityController</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:28 2020/8/12
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/identity")
public class IdentityController {

    @RestIntercept
    @GetMapping("/generate")
    public ResponseEntity generate() {
        Long generate = IdentityUtils.generate();
        return RestResult.ok(generate);
    }

    @RestIntercept
    @PostMapping("/generate")
    public ResponseEntity postTest(@RequestBody RestResult result) {
        Long generate = IdentityUtils.generate();
        log.info("RequestBody: {}", JsonUtils.parseJson(result));
        return RestResult.ok(generate);
    }

    @RestIntercept
    @PostMapping("/upload")
    public ResponseEntity uploadShape(@RequestPart("file") MultipartFile file) {
        return RestResult.ok(file.getOriginalFilename());
    }
}
