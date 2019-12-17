package cyan.tool.kit.chip.parent.core.advice;

import cyan.tool.kit.chip.parent.core.DefaultException;
import cyan.tool.kit.chip.parent.core.DefaultResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>RiceExceptionAdvice</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:26 2019/12/16
 */
@CrossOrigin
@ControllerAdvice
@RestControllerAdvice
public class DefaultExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = DefaultException.class)
    public ResponseEntity chipExceptionHandler(DefaultException exception) {
        return ResponseEntity.ok(exception.buildResult());
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandler(Exception exception) {
        if (exception instanceof DefaultException) {
            DefaultException gxException = (DefaultException)exception;
            return ResponseEntity.ok(gxException.buildResult());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(DefaultResult.fail(-1, exception.getMessage()));
        }
    }
}
