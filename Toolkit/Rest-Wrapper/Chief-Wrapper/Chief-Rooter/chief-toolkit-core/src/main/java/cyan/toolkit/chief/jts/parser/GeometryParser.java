package cyan.toolkit.chief.jts.parser;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.chief.jts.JtsParser;
import cyan.toolkit.chief.jts.error.JtsParseException;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import java.util.HashMap;
import java.util.Map;

import static cyan.toolkit.chief.jts.JtsGeojson.*;


/**
 * <p>GeometryParser</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:30 2020/9/22
 */
public class GeometryParser extends JtsParser<Geometry> {

    private Map<String, JtsParser> parsers;

    public GeometryParser(GeometryFactory geometryFactory) {
        super(geometryFactory);
        parsers = new HashMap<>();
        parsers.put(POINT, new PointParser(geometryFactory));
        parsers.put(MULTI_POINT, new MultiPointParser(geometryFactory));
        parsers.put(LINE_STRING, new LineStringParser(geometryFactory));
        parsers.put(MULTI_LINE_STRING, new MultiLineStringParser(geometryFactory));
        parsers.put(POLYGON, new PolygonParser(geometryFactory));
        parsers.put(MULTI_POLYGON, new MultiPolygonParser(geometryFactory));
        parsers.put(GEOMETRY_COLLECTION, new GeometryCollectionParser(geometryFactory, this));
    }

    @Override
    public Geometry parse(JsonNode node) throws JtsParseException {
        String typeName = node.get(TYPE).asText();
        JtsParser parser = parsers.get(typeName);
        if (parser != null) {
            return parser.parse(node);
        } else {
            throw new JtsParseException("Invalid geometry type: " + typeName);
        }
    }
}
