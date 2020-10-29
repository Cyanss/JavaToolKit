package cyan.toolkit.chief.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import cyan.toolkit.rest.util.common.DateUtils;

import java.io.IOException;
import java.util.Date;

/**
 * <p>DataSerializer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:56 2020/9/24
 */
public class DateSerializer<D> extends JsonSerializer<D> {

    //TODO TEST

    @Override
    public void serialize(D date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (date instanceof Long) {
            Long datetime = (Long) date;
            String formatTime = DateUtils.formatTime(datetime);
            jsonGenerator.writeString(formatTime);
        } else if (date instanceof Date) {
            Date datetime = (Date) date;
            String formatTime = DateUtils.formatTime(datetime);
            jsonGenerator.writeString(formatTime);
        } else if (date instanceof String) {
            String datetime = (String) date;
            jsonGenerator.writeString(datetime);
        } else {
            jsonGenerator.writeObject(date);
        }
    }
}
