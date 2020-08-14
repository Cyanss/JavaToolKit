package cyan.toolkit.rest.error.often;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

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
        super(RestErrorStatus.FILE_CREATE_ERROR);
    }

    public FileCreateException(String message) {
        super(RestErrorStatus.FILE_CREATE_ERROR, RestError.error(RestErrorStatus.FILE_CREATE_ERROR, message));
    }

    public FileCreateException(String resource, String message) {
        super(RestErrorStatus.FILE_CREATE_ERROR, RestError.error(resource, RestErrorStatus.FILE_CREATE_ERROR, message));
    }

    @Override
    public FileCreateException get() {
        return new FileCreateException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.FILE_CREATE_ERROR.getName();
    }
}
