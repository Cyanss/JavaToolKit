package cyan.tool.kit.chip.flux.rice;

import com.fasterxml.jackson.core.JsonParser;
import cyan.tool.kit.chip.core.rice.error.supply.JsonDeserializeException;
import cyan.tool.kit.chip.flux.helper.json.RiceDeserializeHelper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>RiceDeserializeFlux</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:05 2019/12/25
 */
@Slf4j
public class RiceDeserializeFlux {
    /**
     * JsonParser 反序列化Map方法
     * @param parser JsonParser对象
     * @return Map<String, Object>
     */
    public static Map<String, Object> deserializerBean(JsonParser parser) throws JsonDeserializeException {
        try {
            return RiceDeserializeHelper.deserializerBean(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as map of bean fields!",exception);
            throw new JsonDeserializeException(exception.getMessage());
        }
    }

    /**
     * JsonParser 反序列化List方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     */
    public static List<Object> deserializerList(JsonParser parser) throws JsonDeserializeException {
        try {
            return RiceDeserializeHelper.deserializerList(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as list of bean!",exception);
            throw new JsonDeserializeException(exception.getMessage());
        }
    }

    /**
     * JsonParser 反序列化BeanList方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     */
    public static List<Map<String, Object>> deserializerBeanList(JsonParser parser) throws JsonDeserializeException {
        try {
            return RiceDeserializeHelper.deserializerBeanList(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as list map of bean fields!",exception);
            throw new JsonDeserializeException(exception.getMessage());
        }
    }


    /**
     * JsonParser 反序列化Map方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     */
    public static Map<String, Object> deserializerMap(JsonParser parser) throws JsonDeserializeException {
        try {
            return RiceDeserializeHelper.deserializerMap(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as map of bean!",exception);
            throw new JsonDeserializeException(exception.getMessage());
        }
    }


    /**
     * JsonParser 反序列化BeanMap方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     */
    public static Map<String,Map<String, Object>> deserializerBeanMap(JsonParser parser) throws JsonDeserializeException {
        try {
            return RiceDeserializeHelper.deserializerBeanMap(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as map map of bean fields!",exception);
            throw new JsonDeserializeException(exception.getMessage());
        }
    }
}
