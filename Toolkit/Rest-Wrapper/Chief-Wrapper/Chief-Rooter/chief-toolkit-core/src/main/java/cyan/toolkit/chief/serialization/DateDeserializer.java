package cyan.toolkit.chief.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.rest.error.natives.ParseErrorException;
import cyan.toolkit.rest.error.natives.UnsupportedErrorException;
import cyan.toolkit.rest.util.common.DateUtils;
import cyan.toolkit.rice.clazz.RestClazzUtils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Optional;

/**
 * <p>DateDeserializer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:55 2020/9/24
 */
public class DateDeserializer<D> extends JsonDeserializer<D> {

    @Override
    @SuppressWarnings(value = "unchecked")
    public D deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        Class<?> clazz = RestClazzUtils.clazz(this);
        String text = root.asText();
        if (String.class.equals(clazz)) {
            return (D) text;
        } else if (Date.class.equals(clazz)) {
            try {
                return (D) DateUtils.parse(text,DateUtils.DATE_FORMAT_23);
            } catch (ParseErrorException e) {
                throw new IOException(e.getMessage(),e);
            }
        } else if (Long.class.equals(clazz)) {
            try {
                Date parse = DateUtils.parse(text, DateUtils.DATE_FORMAT_23);
                return (D) ((Long) parse.getTime());
            } catch (ParseErrorException e) {
                throw new IOException(e.getMessage(),e);
            }
        } else {
            String pattern = "It is Unsupported for {} to transform to {} type";
            String message = MessageFormat.format(pattern, text, clazz);
            throw new IOException(message,new UnsupportedErrorException(message));
        }
    }
}
