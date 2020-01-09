package cyan.tool.kit.rest.core.rice.error.natives;

import cyan.tool.kit.rest.core.rice.defaults.RestError;
import cyan.tool.kit.rest.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rest.core.rice.rest.RestResultStatus;
import cyan.tool.kit.rest.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>FileErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:51 2019/12/19
 */
public class FileErrorException extends RestErrorException {

    public FileErrorException() {
        super(RestResultStatus.FILE_ERROR);
    }

    public FileErrorException(RestResultStatus status) {
        super(status);
    }

    public FileErrorException(String error) {
        super(RestResultStatus.FILE_ERROR, RestError.error(RestResultStatus.FILE_ERROR,error));
    }

    public FileErrorException(RestStatus status) {
        super(RestResultStatus.FILE_ERROR, RestError.error(status));
    }

    public FileErrorException(RestStatus status, String error) {
        super(RestResultStatus.FILE_ERROR,RestError.error(status, error));
    }

    public FileErrorException(String file, Object value) {
        super(RestResultStatus.FILE_ERROR, RestError.error(file, value, RestResultStatus.FILE_ERROR));
    }

    public FileErrorException(String file, String error) {
        super(RestResultStatus.FILE_ERROR, RestError.error(file, RestResultStatus.FILE_ERROR, error));
    }

    public FileErrorException(String file, Object value, String error) {
        super(RestResultStatus.FILE_ERROR, RestError.error(file, value, RestResultStatus.FILE_ERROR, error));
    }

    public FileErrorException(String file, RestStatus status) {
        super(RestResultStatus.FILE_ERROR, RestError.error(file, status));
    }

    public FileErrorException(String file, Object value, RestStatus status) {
        super(RestResultStatus.FILE_ERROR, RestError.error(file, value, status));
    }

    public FileErrorException(String file, RestStatus status, String error) {
        super(RestResultStatus.FILE_ERROR, RestError.error(file, status, error));
    }

    public FileErrorException(String file, Object value, RestStatus status, String error) {
        super(RestResultStatus.FILE_ERROR, RestError.error(file, value, status, error));
    }


    @Override
    public FileErrorException get() {
        return new FileErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestResultStatus.FILE_ERROR).getName();
    }
}
