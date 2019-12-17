package cyan.tool.kit.chip.parent.exception;

import cyan.tool.kit.chip.parent.core.DefaultException;
import cyan.tool.kit.chip.parent.core.DefaultResultStatus;
import cyan.tool.kit.chip.parent.core.DefaultError;

/**
 * <p>JsonParseErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:32 2019/12/17
 */
public class JsonParseErrorException extends DefaultException {
    public JsonParseErrorException(String resource, String json, String message) {
        super(DefaultResultStatus.JSON_PARSING_ERROR.getStatus(), DefaultResultStatus.JSON_PARSING_ERROR.getMessage(), DefaultError.jsonParseError(resource, json, message));
    }
}
