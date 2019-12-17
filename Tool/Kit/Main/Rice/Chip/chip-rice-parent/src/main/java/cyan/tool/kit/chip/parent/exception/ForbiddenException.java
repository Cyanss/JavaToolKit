package cyan.tool.kit.chip.parent.exception;


import cyan.tool.kit.chip.core.defaults.*;

/**
 * <p>ForbiddenException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:58 2019/12/16
 */
public class ForbiddenException extends DefaultException {

    public ForbiddenException(String resource, String user, String auth) {
        super(DefaultResultStatus.AUTH_FORBIDDEN, DefaultError.authError(resource, user, auth));
    }
}
