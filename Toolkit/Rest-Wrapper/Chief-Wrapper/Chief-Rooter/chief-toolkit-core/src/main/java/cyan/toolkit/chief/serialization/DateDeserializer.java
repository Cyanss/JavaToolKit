package cyan.toolkit.chief.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.rest.util.common.DateUtils;
import cyan.toolkit.rice.clazz.RestClazzUtils;

import java.io.IOException;
import java.util.Date;

/**
 * <p>DateDeserializer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:55 2020/9/24
 */
public class DateDeserializer<D> extends JsonDeserializer<D> {

    //TODO TEST

    @Override
    @SuppressWarnings(value = "unchecked")
    public D deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        Class<?> clazz = RestClazzUtils.clazz(this);
        if (String.class.equals(clazz)) {
            return (D) root.asText();
        } else if (Date.class.equals(clazz)) {
            return (D) DateUtils.parseDateTime(root.asText());
        } else if (Long.class.equals(clazz)) {
            return (D) ((Long) DateUtils.parseDateTime(root.asText()).getTime());
        }
        return null;
    }
}
