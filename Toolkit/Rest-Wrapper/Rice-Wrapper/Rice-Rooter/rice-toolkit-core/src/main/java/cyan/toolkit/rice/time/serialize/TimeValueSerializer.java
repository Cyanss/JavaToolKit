package cyan.toolkit.rice.time.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import cyan.toolkit.rice.time.TimeValue;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>TimeValueSerializer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:57 2020/8/20
 */
@Component
public class TimeValueSerializer extends JsonSerializer<TimeValue> {
    @Override
    public void serialize(TimeValue timeValue, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(timeValue.format());
    }
}
