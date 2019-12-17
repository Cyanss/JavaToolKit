package cyan.tool.kit.chip.flux.util.json;

import com.fasterxml.jackson.core.JsonParser;
import cyan.tool.kit.chip.flux.helper.json.DeserializeHelper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>DeserializeUtils</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:59 2019/11/21
 */
@Slf4j
public class DeserializeUtils {

    /**
     * JsonParser 反序列化Map方法
     * @param parser JsonParser对象
     * @return Map<String, Object>
     */
    public static Map<String, Object> deserializerBean(JsonParser parser) {
        try {
            return DeserializeHelper.deserializerBean(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as map of bean fields!",exception);
            exception.printStackTrace();
        }
        return Collections.emptyMap();
    }

    /**
     * JsonParser 反序列化List方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     */
    public static List<Object> deserializerList(JsonParser parser) {
        try {
            return DeserializeHelper.deserializerList(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as list of bean!",exception);
            exception.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * JsonParser 反序列化BeanList方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     */
    public static List<Map<String, Object>> deserializerBeanList(JsonParser parser) {
        try {
            return DeserializeHelper.deserializerBeanList(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as list map of bean fields!",exception);
            exception.printStackTrace();
        }
        return Collections.emptyList();

    }


    /**
     * JsonParser 反序列化Map方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     */
    public static Map<String, Object> deserializerMap(JsonParser parser) {
        try {
            return DeserializeHelper.deserializerMap(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as map of bean!",exception);
            exception.printStackTrace();
        }
        return Collections.emptyMap();
    }


    /**
     * JsonParser 反序列化BeanMap方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     */
    public static Map<String,Map<String, Object>> deserializerBeanMap(JsonParser parser){
        try {
            return DeserializeHelper.deserializerBeanMap(parser);
        } catch (IOException exception) {
            log.error("It is failed during json to deserialize as map map of bean fields!",exception);
            exception.printStackTrace();
        }
        return Collections.emptyMap();
    }
}
