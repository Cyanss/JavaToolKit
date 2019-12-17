package cyan.tool.kit.chip.parent.exception;

import cyan.tool.kit.chip.parent.core.DefaultException;
import cyan.tool.kit.chip.parent.core.DefaultResultStatus;
import cyan.tool.kit.chip.parent.core.DefaultStatus;
import cyan.tool.kit.chip.parent.core.DefaultError;

/**
 * <p>ForbiddenException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:58 2019/12/16
 */
public class ForbiddenException extends DefaultException {
    public static final String NAME = "UNAUTHORIZED";
    public static final String MESSAGE = "权限不足";
    public static final DefaultResultStatus UNAUTHORIZED = DefaultStatus.build(DefaultResultStatus.class, NAME,
            DefaultResultStatus.ACCESS_FORBIDDEN.getStatus(), MESSAGE);

    public ForbiddenException(String resource, String user, String auth) {
        super(UNAUTHORIZED, DefaultError.accessAuthError(resource, user, auth));
    }
}
