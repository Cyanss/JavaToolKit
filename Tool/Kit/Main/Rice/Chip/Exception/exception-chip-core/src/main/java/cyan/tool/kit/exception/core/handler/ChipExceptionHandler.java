package cyan.tool.kit.exception.core.handler;

import cyan.tool.kit.exception.core.exception.ChipException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>ChipExceptionHandler</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:26 2019/12/13
 */
@ControllerAdvice
public class ChipExceptionHandler {
    @ExceptionHandler(value = ChipException.class)
    @ResponseBody
    public CyResponseResult handlerChipException(ChipException exception) {
        return CyResponseResultUtils.error(exception.getStatus(),exception.getMessage());
    }
}
