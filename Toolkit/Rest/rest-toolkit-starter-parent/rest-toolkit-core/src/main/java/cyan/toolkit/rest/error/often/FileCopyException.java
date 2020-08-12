package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

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
        super(RestErrorStatus.FILE_COPY_ERROR);
    }

    public FileCopyException(String message) {
        super(RestErrorStatus.FILE_COPY_ERROR, RestError.error(RestErrorStatus.FILE_COPY_ERROR, message));
    }

    public FileCopyException(String resource, String message) {
        super(RestErrorStatus.FILE_COPY_ERROR, RestError.error(resource, RestErrorStatus.FILE_COPY_ERROR, message));
    }

    @Override
    public FileCopyException get() {
        return new FileCopyException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.FILE_COPY_ERROR.getName();
    }
}
