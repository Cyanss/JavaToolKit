package cyan.toolkit.chief.jts;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import cyan.toolkit.chief.jts.parser.*;
import cyan.toolkit.chief.jts.serialization.GeometryDeserializer;
import cyan.toolkit.chief.jts.serialization.GeometrySerializer;
import org.locationtech.jts.geom.*;

public class JtsModule3D extends SimpleModule {

    public JtsModule3D() {
        this(new GeometryFactory());
    }
    
    public JtsModule3D(GeometryFactory geometryFactory) {
        super("JtsModule3D", JtsVersion.VERSION);

        addSerializer(Geometry.class, new GeometrySerializer());
        GeometryParser genericGeometryParser = new GeometryParser(geometryFactory);
        addDeserializer(Geometry.class, new GeometryDeserializer<>(genericGeometryParser));
        addDeserializer(Point.class, new GeometryDeserializer<>(new PointParser(geometryFactory)));
        addDeserializer(MultiPoint.class, new GeometryDeserializer<>(new MultiPointParser(geometryFactory)));
        addDeserializer(LineString.class, new GeometryDeserializer<>(new LineStringParser(geometryFactory)));
        addDeserializer(MultiLineString.class, new GeometryDeserializer<>(new MultiLineStringParser(geometryFactory)));
        addDeserializer(Polygon.class, new GeometryDeserializer<>(new PolygonParser(geometryFactory)));
        addDeserializer(MultiPolygon.class, new GeometryDeserializer<>(new MultiPolygonParser(geometryFactory)));
        addDeserializer(GeometryCollection.class, new GeometryDeserializer<>(new GeometryCollectionParser(geometryFactory, genericGeometryParser)));
    }

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
    }
}
