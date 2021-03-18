package cyan.toolkit.chief.jts.parser;

import com.fasterxml.jackson.databind.JsonNode;
import cyan.toolkit.chief.jts.JtsParser;
import cyan.toolkit.chief.jts.error.JtsParseException;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.GeometryFactory;

import static cyan.toolkit.chief.jts.JtsGeojson.GEOMETRIES;

/**
 * <p>GeometryCollectionParser</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:21 2020/9/22
 */
public class GeometryCollectionParser extends JtsParser<GeometryCollection> {

    private GeometryParser geometryParser;

    public GeometryCollectionParser(GeometryFactory geometryFactory, GeometryParser geometryParser) {
        super(geometryFactory);
        this.geometryParser = geometryParser;
    }

    private Geometry[] parseGeometries(JsonNode geometryArray) throws JtsParseException {
        Geometry[] items = new Geometry[geometryArray.size()];
        for(int i=0;i!=geometryArray.size();++i) {
            items[i] = geometryParser.parse(geometryArray.get(i));
        }
        return items;
    }

    @Override
    public GeometryCollection parse(JsonNode node) throws JtsParseException {
        Geometry[] geometries = parseGeometries(node.get(GEOMETRIES));
        return geometryFactory.createGeometryCollection(geometries);
    }
}
