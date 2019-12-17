package cyan.tool.kit.chip.core.rice.defaults;

import cyan.tool.kit.chip.core.rice.rest.RestResult;
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
    @ExceptionHandler(value = DefaultError.class)
    public ResponseEntity defaultErrorHandler(DefaultError error) {
        return ResponseEntity.ok(new DefaultException(error).buildResult());
    }

    @ResponseBody
    @ExceptionHandler(value = Error.class)
    public ResponseEntity errorHandler(Error error) {
        if (error instanceof DefaultError) {
            DefaultError defaultError = (DefaultError) error;
            return ResponseEntity.ok(new DefaultException(defaultError).buildResult());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestResult.error(-1, error.getMessage()));
        }
    }

    @ResponseBody
    @ExceptionHandler(value = DefaultException.class)
    public ResponseEntity defaultExceptionHandler(DefaultException exception) {
        return ResponseEntity.ok(exception.buildResult());
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandler(Exception exception) {
        if (exception instanceof DefaultException) {
            DefaultException defaultException = (DefaultException) exception;
            return ResponseEntity.ok(defaultException.buildResult());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestResult.error(-1, exception.getMessage()));
        }
    }
}
