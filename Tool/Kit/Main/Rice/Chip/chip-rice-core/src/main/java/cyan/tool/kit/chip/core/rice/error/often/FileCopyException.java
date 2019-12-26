package cyan.tool.kit.chip.core.rice.error.often;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>FileCopyException</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:31 2019/12/26
 */
public class FileCopyException extends RestErrorException {
    public FileCopyException() {
        super(RestResultStatus.FILE_COPY_ERROR);
    }

    public FileCopyException(String message) {
        super(RestResultStatus.FILE_COPY_ERROR, RestError.error(RestResultStatus.FILE_COPY_ERROR, message));
    }

    public FileCopyException(String resource, String message) {
        super(RestResultStatus.FILE_COPY_ERROR, RestError.error(resource, RestResultStatus.FILE_COPY_ERROR, message));
    }

    @Override
    public FileCopyException get() {
        return new FileCopyException();
    }

    @Override
    public String getName() {
        return RestResultStatus.FILE_COPY_ERROR.getName();
    }
}
