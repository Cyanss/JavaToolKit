package cyan.tool.kit.rice.parent;


import cyan.tool.kit.rice.core.rice.defaults.RestException;

/**
 * <p>JsonParseErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:32 2019/12/17
 */
public class JsonParseErrorException extends RestException {
    public JsonParseErrorException(String resource, String json, String message) {
//        super(DefaultResultStatus.JSON_PARSING_ERROR.getStatus(), DefaultResultStatus.JSON_PARSING_ERROR.getMessage(), DefaultError.jsonParseError(resource, json, message));
    }
}
