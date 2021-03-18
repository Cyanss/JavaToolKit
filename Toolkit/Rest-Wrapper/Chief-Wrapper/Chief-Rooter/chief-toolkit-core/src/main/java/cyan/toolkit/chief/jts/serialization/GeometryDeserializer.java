package cyan.toolkit.chief.jts.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.chief.jts.JtsParser;
import org.locationtech.jts.geom.Geometry;

import java.io.IOException;

/**
 * <p>GeometryDeserializer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:52 2020/9/22
 */
public class GeometryDeserializer<S extends Geometry> extends JsonDeserializer<S> {

    private JtsParser<S> jtsParser;

    public GeometryDeserializer(JtsParser<S> jtsParser) {
        this.jtsParser = jtsParser;
    }

    @Override
    public S deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        return jtsParser.parse(root);
    }
}
