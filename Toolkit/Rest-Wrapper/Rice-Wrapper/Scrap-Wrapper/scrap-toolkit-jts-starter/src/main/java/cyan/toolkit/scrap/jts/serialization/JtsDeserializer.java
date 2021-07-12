package cyan.toolkit.scrap.jts.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.scrap.jts.JtsParser;
import org.locationtech.jts.geom.Geometry;

import java.io.IOException;

/**
 * <p>JtsDeserializer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:47 2021/7/12
 */
public class JtsDeserializer<S extends Geometry> extends JsonDeserializer<S> {

    private JtsParser<S> jtsParser;

    public JtsDeserializer(JtsParser<S> jtsParser) {
        this.jtsParser = jtsParser;
    }

    @Override
    public S deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        return jtsParser.parse(root);
    }
}
