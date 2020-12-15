package cyan.toolkit.rest.controller;

import cyan.toolkit.rest.RestIntercept;
import cyan.toolkit.rest.RestResult;
import cyan.toolkit.rest.identity.IdentityHelper;
import cyan.toolkit.rest.RestException;
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
        return RestResult.ok(generate);
    }

    @GetMapping("/offset/{offset}")
    public ResponseEntity generate(@PathVariable Long offset) throws RestException {
        Long generate = IdentityHelper.offset(offset);
        return RestResult.ok(generate);
    }

    @GetMapping("/sequence/{sequence}")
    public ResponseEntity sequence(@PathVariable Long sequence) throws RestException {
        Long generate = IdentityHelper.sequence(sequence);
        return RestResult.ok(generate);
    }
}
