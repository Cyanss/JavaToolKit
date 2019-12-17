package cyan.tool.kit.chip.parent.exception;

import cyan.tool.kit.chip.parent.core.DefaultException;
import cyan.tool.kit.chip.parent.core.DefaultError;
import cyan.tool.kit.chip.parent.core.DefaultResultStatus;

/**
 * <p>TimeoutException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:34 2019/12/17
 */
public class TimeoutException extends DefaultException {
    public TimeoutException(String resource) {
        super(DefaultResultStatus.TIME_OUT.getStatus(), DefaultResultStatus.TIME_OUT.getMessage(), DefaultError.timeout(resource));
    }
}
