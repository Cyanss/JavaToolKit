package cyan.toolkit.scrap.jts.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.scrap.jts.JtsParser;
import cyan.toolkit.scrap.jts.parser.GeometryParser;
import org.locationtech.jts.geom.Geometry;

import java.io.IOException;

import static cyan.toolkit.scrap.jts.JtsGeojson.GEOMETRY_FACTORY;

/**
 * <p>GeometryDeserializer</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:52 2020/9/22
 */
public class GeometryDeserializer extends JsonDeserializer<Geometry> {

    private JtsParser jtsParser;

    public GeometryDeserializer() {
        this.jtsParser = new GeometryParser(GEOMETRY_FACTORY);
    }

    @Override
    public Geometry deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        return jtsParser.parse(root);
    }
}
