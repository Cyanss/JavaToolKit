package cyan.toolkit.rest.controller;

import cyan.toolkit.rest.RestIntercept;
import cyan.toolkit.rest.identity.IdentityHelper;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.DefaultResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>IdentityController</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:28 2020/8/12
 */
@CrossOrigin
@RestController
@RequestMapping("/identity")
public class IdentityController {

    @RestIntercept
    @GetMapping("/generate")
    public ResponseEntity generate() throws RestException {
        Long generate = IdentityHelper.generate();
        return ResponseEntity.ok(DefaultResult.success(generate));
    }

    @GetMapping("/generate/{tag}")
    public ResponseEntity generate(@PathVariable Long tag) throws RestException {
        Long generate = IdentityHelper.generate(tag);
        return ResponseEntity.ok(DefaultResult.success(generate));
    }
}
