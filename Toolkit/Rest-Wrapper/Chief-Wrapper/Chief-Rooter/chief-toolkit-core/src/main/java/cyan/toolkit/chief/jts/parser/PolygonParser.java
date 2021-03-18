package cyan.toolkit.chief.jts.parser;

import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.chief.jts.JtsParser;
import cyan.toolkit.chief.jts.error.JtsParseException;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

import static cyan.toolkit.chief.jts.JtsGeojson.*;

/**
 * <p>PolygonParser</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:44 2020/9/22
 */
public class PolygonParser extends JtsParser<Polygon> {

    public PolygonParser(GeometryFactory geometryFactory) {
        super(geometryFactory);
    }


    public Polygon parsePolygon(JsonNode arrayOfRings) {
        LinearRing shell = parseLinearRing(arrayOfRings.get(0));
        int size = arrayOfRings.size();
        LinearRing[] holes = new LinearRing[size - 1];
        for (int i = 1; i < size; i++) {
            holes[i - 1] = parseLinearRing(arrayOfRings.get(i));
        }
        return geometryFactory.createPolygon(shell, holes);
    }

    private LinearRing parseLinearRing(JsonNode coordinatesNode) {
        assert coordinatesNode.isArray() : "expected coordinates array";
        Coordinate[] coordinates = PointParser.parseCoordinates(coordinatesNode);
        return geometryFactory.createLinearRing(coordinates);
    }


    @Override
    public Polygon parse(JsonNode jsonNode) throws JtsParseException {
        JsonNode arrayOfRings = jsonNode.get(COORDINATES);
        return parsePolygon(arrayOfRings);
    }
}
