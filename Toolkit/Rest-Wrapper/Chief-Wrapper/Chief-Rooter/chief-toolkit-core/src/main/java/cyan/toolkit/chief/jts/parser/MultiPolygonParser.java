package cyan.toolkit.chief.jts.parser;

import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.chief.jts.JtsParser;
import cyan.toolkit.chief.jts.error.JtsParseException;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;

import static cyan.toolkit.chief.jts.JtsGeojson.COORDINATES;

/**
 * <p>MultiPolygonParser</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:43 2020/9/22
 */
public class MultiPolygonParser extends JtsParser<MultiPolygon> {

    private PolygonParser polygonParser;

    public MultiPolygonParser(GeometryFactory geometryFactory) {
        super(geometryFactory);
        polygonParser = new PolygonParser(geometryFactory);
    }

    public MultiPolygon parseMultiPolygon(JsonNode root) {
        JsonNode arrayOfPolygons = root.get(COORDINATES);
        return geometryFactory.createMultiPolygon(parsePolygons(arrayOfPolygons));
    }

    private Polygon[] parsePolygons(JsonNode arrayOfPolygons) {
        Polygon[] polygons = new Polygon[arrayOfPolygons.size()];
        for (int i = 0; i != arrayOfPolygons.size(); ++i) {
            polygons[i] = polygonParser.parsePolygon(arrayOfPolygons.get(i));
        }
        return polygons;
    }

    @Override
    public MultiPolygon parse(JsonNode node) throws JtsParseException {
        return parseMultiPolygon(node);
    }
}
