package cyan.tool.kit.chip.core.rice.error;

import cyan.tool.kit.chip.core.rice.defaults.DefaultError;
import cyan.tool.kit.chip.core.rice.defaults.DefaultException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>TimeoutException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:34 2019/12/17
 */
public class TimeoutError extends DefaultException {
    public TimeoutError(String resource) {
        super(RestResultStatus.TIME_OUT, DefaultError.timeoutError(resource));
    }
}
