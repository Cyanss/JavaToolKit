package cyan.toolkit.chief.jts.parser;

import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.chief.jts.JtsParser;
import cyan.toolkit.chief.jts.error.JtsParseException;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

import static cyan.toolkit.chief.jts.JtsGeojson.*;

/**
 * <p>LineStringParser</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:25 2020/9/22
 */
public class LineStringParser extends JtsParser<LineString> {

    public LineStringParser(GeometryFactory geometryFactory) {
        super(geometryFactory);
    }

    public LineString parseLineString(JsonNode root) {
        Coordinate[] coordinates = PointParser.parseCoordinates(root.get(COORDINATES));
        return geometryFactory.createLineString(coordinates);
    }

    @Override
    public LineString parse(JsonNode node) throws JtsParseException {
        return parseLineString(node);
    }
}
