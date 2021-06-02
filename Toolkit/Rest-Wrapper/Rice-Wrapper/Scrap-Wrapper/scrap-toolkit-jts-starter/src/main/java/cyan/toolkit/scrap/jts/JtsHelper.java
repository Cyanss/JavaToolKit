package cyan.toolkit.scrap.jts;

import cyan.toolkit.scrap.jts.error.JtsBoxInvalidException;
import cyan.toolkit.scrap.jts.error.JtsParseException;
import cyan.toolkit.rest.util.common.GeneralUtils;
import org.geotools.geojson.geom.GeometryJSON;
import org.geotools.geometry.jts.Geometries;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * <p>JtsHelper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:20 2020/9/22
 */
public class JtsHelper {

    public static String parseWkt(JtsBox box) throws JtsBoxInvalidException {
        if (GeneralUtils.isNotEmpty(box)) {
            box.verify();
            return "POLYGON ((" +
                    box.getMaxX() + " " + box.getMaxY() + ", " +
                    box.getMinX() + " " + box.getMaxY() + ", " +
                    box.getMinX() + " " + box.getMinY() + ", " +
                    box.getMaxX() + " " + box.getMinY() + ", " +
                    box.getMaxX() + " " + box.getMaxY() + "))";
        }
        return null;
    }

    public static String parseGeojson(JtsBox box) throws JtsParseException {
        String wkt = parseWkt(box);
        Geometry geometry = parseGeometry(wkt);
        return parseGeojson(geometry);
    }

    public static JtsBox parseBox(String WktString) throws JtsParseException {
        if (GeneralUtils.isNotEmpty(WktString)) {
            try {
                WKTReader reader = new WKTReader();
                Polygon polygon = (Polygon) reader.read(WktString);
                return parseBox(polygon);
            } catch (ParseException exception) {
                String message = "Wkt数据解析失败，Wkt = " + WktString;
                throw new JtsParseException(message,exception);
            }
        }
        return null;
    }

    public static JtsBox parseBox(Geometry geometry) throws JtsBoxInvalidException {
        if (GeneralUtils.isNotEmpty(geometry)) {
            Geometries geoType = Geometries.get(geometry);
            if (Geometries.POLYGON.equals(geoType)) {
                double minX = geometry.getEnvelopeInternal().getMinX();
                double minY = geometry.getEnvelopeInternal().getMinY();
                double maxX = geometry.getEnvelopeInternal().getMaxX();
                double maxY = geometry.getEnvelopeInternal().getMaxY();
                JtsBox box = new JtsBox(minX, minY, maxX, maxY);
                box.verify();
                return box;
            }
        }
        return null;
    }

    public static String parseGeojson(Geometry geometry) throws JtsParseException {
        if (GeneralUtils.isNotEmpty(geometry)) {
            try {
                StringWriter writer = new StringWriter();
                GeometryJSON geometryJSON = new GeometryJSON(10);
                geometryJSON.write(geometry, writer);
                return writer.toString();
            } catch (IOException exception) {
                String message = "Geometry数据解析失败，Geometry = " + geometry.toText();
                throw new JtsParseException(message,exception);
            }
        }
        return null;
    }

    public static Geometry parseGeometry(byte[] WkbBytes) throws JtsParseException {
        if (GeneralUtils.isNotEmpty(WkbBytes)) {
            try {
                WKBReader reader = new WKBReader();
                return reader.read(WkbBytes);
            } catch (ParseException exception) {
                String message = "Wkb数据读取失败，WkbBytes = " + new String(WkbBytes);
                throw new JtsParseException(message,exception);
            }
        }
        return null;
    }

    public static String parseWkt(byte[] WkbBytes) throws JtsParseException {
        if (GeneralUtils.isNotEmpty(WkbBytes)) {
            try {
                WKTWriter writer = new WKTWriter();
                WKBReader reader = new WKBReader();
                return writer.write(reader.read(WkbBytes));
            } catch (ParseException exception) {
                String message = "Wkb数据读取失败，Wkb = " + new String(WkbBytes);
                throw new JtsParseException(message,exception);
            }
        }
        return null;
    }

    public static byte[] parseWkb(Geometry geometry) throws JtsParseException {
        if (GeneralUtils.isNotEmpty(geometry)) {
            try {
                WKBWriter writer = new WKBWriter();
                return writer.write(geometry);
            } catch (Exception exception) {
                String message = "Geometry数据解析失败，Geometry = " + geometry.toText();
                throw new JtsParseException(message,exception);
            }
        }
        return null;
    }

    public static String parseWkt(Geometry geometry) throws JtsParseException {
        if (GeneralUtils.isNotEmpty(geometry)) {
            try {
                WKTWriter writer = new WKTWriter();
                return writer.write(geometry);
            } catch (Exception exception) {
                String message = "Geometry数据解析失败，Geometry = " + geometry.toText();
                throw new JtsParseException(message,exception);
            }
        }
        return null;
    }

    public static Geometry parseGeometry(String WktString) throws JtsParseException {
        if (GeneralUtils.isNotEmpty(WktString)) {
            try {
                WKTReader reader = new WKTReader();
                return reader.read(WktString);
            } catch (ParseException exception) {
                String message = "Wkt数据读取失败，Wkt = " + WktString;
                throw new JtsParseException(message,exception);
            }
        }
        return null;
    }

    public static byte[] parseWkb(String WktString) throws JtsParseException {
        if (GeneralUtils.isNotEmpty(WktString)) {
            try {
                WKTReader reader = new WKTReader();
                WKBWriter writer = new WKBWriter();
                return writer.write(reader.read(WktString));
            } catch (ParseException exception) {
                String message = "Wkt数据读取失败，Wkt = " + WktString;
                throw new JtsParseException(message,exception);
            }
        }
        return null;
    }

    public static Geometry parseGeojson(String geojson) throws JtsParseException {
        if (GeneralUtils.isNotEmpty(geojson)) {
            try {
                GeometryJSON geometryJSON = new GeometryJSON();
                Reader reader = new StringReader(geojson);
                return geometryJSON.read(reader);
            } catch (IOException exception) {
                String message = "GeoJson数据解析失败，GeoJson = " + geojson;
                throw new JtsParseException(message,exception);
            }
        }
        return null;
    }
}
