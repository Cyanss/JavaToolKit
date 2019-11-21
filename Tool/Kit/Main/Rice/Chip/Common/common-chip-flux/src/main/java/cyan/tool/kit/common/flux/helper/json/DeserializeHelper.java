package cyan.tool.kit.common.flux.helper.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.*;

/**
 * <p>DeserializeHelper</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:59 2019/11/21
 */
public class DeserializeHelper {

    /**
     * JsonParser 反序列化Map方法
     * @param parser JsonParser对象
     * @return Map<String, Object>
     * @throws IOException
     */
    public static Map<String, Object> deserializerBean(JsonParser parser) throws IOException {
        JsonNode jsonNode = parser.getCodec().readTree(parser);
        Map<String, Object> beanMap = new HashMap<>();
        if (!jsonNode.isArray()) {
            buildBeanMap(jsonNode, beanMap);
        }
        return beanMap;
    }

    /**
     * JsonParser 反序列化List方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     * @throws IOException
     */
    public static List<Object> deserializerList(JsonParser parser) throws IOException {
        List<Object> resultList = new ArrayList<>();
        JsonNode jsonNode = parser.getCodec().readTree(parser);
        if (jsonNode.isArray()) {
            for (JsonNode objectNode : jsonNode) {
                resultList.add(objectNode);
            }
        }
        return resultList;
    }

    /**
     * JsonParser 反序列化BeanList方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     * @throws IOException
     */
    public static List<Map<String, Object>> deserializerBeanList(JsonParser parser) throws IOException {
        List<Map<String, Object>> resultList = new ArrayList<>();
        JsonNode jsonNode = parser.getCodec().readTree(parser);
        if (jsonNode.isArray()) {
            for (JsonNode objectNode : jsonNode) {
                Map<String, Object> beanMap = new HashMap<>();
                buildBeanMap(objectNode, beanMap);
                resultList.add(beanMap);
            }
        }
        return resultList;
    }


    /**
     * JsonParser 反序列化Map方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     * @throws IOException
     */
    public static Map<String, Object> deserializerMap(JsonParser parser) throws IOException {
        JsonNode jsonNode = parser.getCodec().readTree(parser);
        Map<String, Object> resultMap = new HashMap<>();
        if (!jsonNode.isArray()) {
            for (Iterator<Map.Entry<String, JsonNode>> iter = jsonNode.fields(); iter.hasNext(); ) {
                Map.Entry<String, JsonNode> entry = iter.next();
                JsonNode valueNode = entry.getValue();
                resultMap.put(entry.getKey(),valueNode);
            }
        }
        return resultMap;
    }


    /**
     * JsonParser 反序列化BeanMap方法
     * @param parser JsonParser对象
     * @return List<Map<String, Object>>
     * @throws IOException
     */
    public static Map<String,Map<String, Object>> deserializerBeanMap(JsonParser parser) throws IOException {
        JsonNode jsonNode = parser.getCodec().readTree(parser);
        Map<String, Map<String, Object>> dataMap = new HashMap<>();
        if (!jsonNode.isArray()) {
            for (Iterator<Map.Entry<String, JsonNode>> iter = jsonNode.fields(); iter.hasNext(); ) {
                Map.Entry<String, JsonNode> entry = iter.next();
                Map<String, Object> beanMap = new HashMap<>();
                JsonNode valueNode = entry.getValue();
                buildBeanMap(valueNode,beanMap);
                dataMap.put(entry.getKey(),beanMap);
            }
        }
        return dataMap;
    }

    /**
     * 递归重组JSON对象
     * @param jsonNode JsonNode数据
     * @param beanMap 数据map集合
     */
    public static void buildBeanMap(JsonNode jsonNode, Map<String, Object> beanMap) {

        for (Iterator<Map.Entry<String, JsonNode>> iter = jsonNode.fields(); iter.hasNext(); ) {
            Map.Entry<String, JsonNode> entry = iter.next();
            JsonNode valueNode = entry.getValue();
            if (valueNode.isTextual()) {
                beanMap.put(entry.getKey(), valueNode.asText());
            } else if (valueNode.isFloat() || valueNode.isDouble()) {
                beanMap.put(entry.getKey(), valueNode.asDouble());
            } else if (valueNode.isInt()) {
                beanMap.put(entry.getKey(), valueNode.asInt());
            } else if (valueNode.isLong()) {
                beanMap.put(entry.getKey(), valueNode.asLong());
            } else if (valueNode.isBoolean()) {
                beanMap.put(entry.getKey(), valueNode.asBoolean());
            }else {
                beanMap.put(entry.getKey(),valueNode);
            }
        }
    }
}
