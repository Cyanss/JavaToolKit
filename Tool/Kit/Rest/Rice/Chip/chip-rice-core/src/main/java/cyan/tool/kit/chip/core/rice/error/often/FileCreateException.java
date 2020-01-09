package cyan.tool.kit.chip.core.rice.error.often;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>FileCreateException</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:29 2019/12/26
 */
public class FileCreateException extends RestErrorException {
    public FileCreateException() {
        super(RestResultStatus.FILE_CREATE_ERROR);
    }

    public FileCreateException(String message) {
        super(RestResultStatus.FILE_CREATE_ERROR, RestError.error(RestResultStatus.FILE_CREATE_ERROR, message));
    }

    public FileCreateException(String resource, String message) {
        super(RestResultStatus.FILE_CREATE_ERROR, RestError.error(resource, RestResultStatus.FILE_CREATE_ERROR, message));
    }

    @Override
    public FileCreateException get() {
        return new FileCreateException();
    }

    @Override
    public String getName() {
        return RestResultStatus.FILE_CREATE_ERROR.getName();
    }
}
