package cyan.toolkit.chief.jts;

import cyan.toolkit.chief.jts.error.JtsBoxInvalidException;
import cyan.toolkit.chief.jts.error.JtsParseException;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Geometry;

/**
 * <p>JtsUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:52 2020/9/18
 */
@Slf4j
public class JtsUtils {

    public static String parseWkt(JtsBox box) {
        try {
            JtsHelper.parseWkt(box);
        } catch (JtsBoxInvalidException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static String parseGeojson(JtsBox box) {
        try {
            JtsHelper.parseGeojson(box);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static JtsBox parseBox(String WktString) {
        try {
            JtsHelper.parseBox(WktString);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static JtsBox parseBox(Geometry geometry) {
        try {
            JtsHelper.parseBox(geometry);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static String parseGeojson(Geometry geometry) {
        try {
            JtsHelper.parseGeojson(geometry);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static Geometry parseGeometry(byte[] WkbBytes) {
        try {
            JtsHelper.parseGeometry(WkbBytes);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static String parseWkt(byte[] WkbBytes) {
        try {
            JtsHelper.parseWkt(WkbBytes);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static byte[] parseWkb(Geometry geometry) {
        try {
            JtsHelper.parseWkb(geometry);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static String parseWkt(Geometry geometry) {
        try {
            JtsHelper.parseWkt(geometry);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static Geometry parseGeometry(String WktString) {
        try {
            JtsHelper.parseGeometry(WktString);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static byte[] parseWkb(String WktString) {
        try {
            JtsHelper.parseWkb(WktString);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }

    public static Geometry parseGeojson(String geojson) {
        try {
            JtsHelper.parseGeojson(geojson);
        } catch (JtsParseException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
        return null;
    }
}
