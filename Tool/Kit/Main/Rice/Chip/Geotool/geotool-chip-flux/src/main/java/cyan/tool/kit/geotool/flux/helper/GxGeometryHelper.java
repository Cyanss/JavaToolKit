package cyan.tool.kit.geotool.flux.helper;

import cyan.tool.kit.common.flux.util.base.EmptyUtils;
import lombok.extern.slf4j.Slf4j;
import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * <p>WKT相关数据转换工具类</p>
 *
 * @author lipo24@126.com
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c)2016-2021
 * @date created on 上午 11:57 2019-7-16
 */
@Slf4j
public class GxGeometryHelper {

    /**
     * WKB数据转换Geometry
     * @param WKBBytes WKB数据
     * @return Geometry
     */
    public static Geometry buildGeometry(byte[] WKBBytes) {
        if (EmptyUtils.isNotEmpty(WKBBytes)) {
            try {
                WKBReader reader = new WKBReader();
                return reader.read(WKBBytes);
            } catch (Exception e) {
                log.error("WKB数据读取失败，WKBBytes = " + new String(WKBBytes));
            }
        }
        return null;
    }

    /**
     * WKB数据转换WKT
     * @param WKBBytes WKB数据
     * @return Geometry
     */
    public static String buildWKT(byte[] WKBBytes) {
        if (EmptyUtils.isNotEmpty(WKBBytes)) {
            try {
                WKTWriter writer = new WKTWriter();
                WKBReader reader = new WKBReader();
                return writer.write(reader.read(WKBBytes));
            } catch (Exception e) {
                log.error("WKB数据读取失败，WKBBytes = " + new String(WKBBytes));
            }
        }
        return null;
    }

    /**
     * Geometry数据转换为WKB
     * @param geometry Geometry数据
     * @return byte[]
     * @throws Exception
     */
    public static byte[] buildWKB(Geometry geometry) {
        if (EmptyUtils.isNotEmpty(geometry)) {
            try {
                WKBWriter writer = new WKBWriter();
                return writer.write(geometry);
            } catch (Exception e) {
                log.error("Geometry数据读取失败，geometry = " + geometry.toText());
            }
        }
        return null;
    }

    /**
     * Geometry数据转换为WKT
     * @param geometry Geometry数据
     * @return String
     */
    public static String buildWKT(Geometry geometry) {
        if (EmptyUtils.isNotEmpty(geometry)) {
            try {
                WKTWriter writer = new WKTWriter();
                return writer.write(geometry);
            } catch (Exception e) {
                log.error("Geometry数据读取失败，geometry = " + geometry.toText());
            }
        }
        return null;

    }

    /**
     * WKT数据转换Geometry
     * @param WKTString WKT数据
     * @return Geometry
     */
    public static Geometry buildGeometry(String WKTString) {
        if (EmptyUtils.isNotEmpty(WKTString) && !"".equals(WKTString)) {
            try {
                WKTReader reader = new WKTReader();
                return reader.read(WKTString);
            } catch (Exception e) {
                log.error("WKT数据读取失败，WKT = " + WKTString);
            }
        }
        return null;
    }
    /**
     * WKT数据转换WKB
     * @param WKTString WKT数据
     * @return byte[]
     */
    public static byte[] buildWKB(String WKTString) {
        if (EmptyUtils.isNotEmpty(WKTString) && !"".equals(WKTString)) {
            try {
                WKTReader reader = new WKTReader();
                WKBWriter writer = new WKBWriter();
                return writer.write(reader.read(WKTString));
            } catch (Exception exception) {
                log.error("WKT数据读取失败，WKT = " + WKTString);
            }
        }
        return null;

    }


    /**
     * GeoJson数据解析为Geometry
     * @param geoJson GeoJson数据
     * @return Geometry
     */
    public static Geometry analysisGeometry(String geoJson)  {
        if (EmptyUtils.isNotEmpty(geoJson) && !"".equals(geoJson)) {
            try {
                GeometryJSON geometryJSON = new GeometryJSON();
                Reader reader = new StringReader(geoJson);
                return geometryJSON.read(reader);
            } catch (Exception exception) {
                exception.printStackTrace();
                log.error("geoJson数据解析失败，geoJson = " + geoJson);
            }
        }
        return null;
    }

    /**
     * Geometry数据转换geoJson
     * @param geometry Geometry数据
     * @return String
     */
    public static String buildGeoJson(Geometry geometry)  {
        if (EmptyUtils.isNotEmpty(geometry)) {
            try {
                StringWriter writer = new StringWriter();
                GeometryJSON geometryJSON = new GeometryJSON(10);
                geometryJSON.write(geometry, writer);
                return writer.toString();
            } catch (Exception exception) {
                exception.printStackTrace();
                log.error("geometry数据解析失败，geometry = " + geometry.toText());
            }
        }
        return null;
    }
}
