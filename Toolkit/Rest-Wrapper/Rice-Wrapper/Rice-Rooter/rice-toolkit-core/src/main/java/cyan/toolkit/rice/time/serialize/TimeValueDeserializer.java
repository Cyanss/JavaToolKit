package cyan.toolkit.rice.time.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import cyan.toolkit.rice.time.TimeValue;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>TimeValueDeserializer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:56 2020/8/20
 */
@Component
public class TimeValueDeserializer extends JsonDeserializer<TimeValue> {
    @Override
    public TimeValue deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return TimeValue.parse(jsonParser.getText());
    }
}
