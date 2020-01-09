package cyan.tool.kit.rice.flux.rice.util.often;

import cyan.tool.kit.rice.flux.rice.util.natives.RiceRandomUtils;
import cyan.tool.kit.rice.flux.rice.util.supply.RiceJsonUtils;

import java.util.HashMap;
import java.util.Map;

public class RiceNameUtils {
    public static final String UUID = "uuid";
    public static final String NAME = "name";
    public static final String EXT = "ext";

    /**
     * 文件名截取 [name.ext]
     * @param fileNameString 文件名
     * @return Map<String,String>
     */
    public static Map<String,String> parseFileName(String fileNameString) {
        Map<String,String> fileNameMap = new HashMap<>();
        String [] result = new String[2];
        if (fileNameString.contains(".")) {
            String[] stringTemp = fileNameString.split("\\.");
            /** 最后一个必是扩展名 */
            result[1] = stringTemp[stringTemp.length - 1];
            if (stringTemp.length > 2) {
                StringBuilder nameBuffer = new StringBuilder();
                for (int i = 0; i < stringTemp.length - 1; i++) {
                    nameBuffer.append(".").append(stringTemp[i]);
                }
                result[0] = (nameBuffer.toString().substring(1));
            } else {
                result[0] = stringTemp[0];
            }
        } else {
            result[0] = fileNameString;
            result[1] = null;
        }
        fileNameMap.put(NAME,result[0]);
        fileNameMap.put(EXT,result[1]);
        return fileNameMap;
    }

    public static String buildFileName(String name,String ext) {
        return name+"." + ext;
    }

    public static String buildFileName(Map<String,String> fileNameMap) {
        String name = fileNameMap.get(NAME);
        String ext = fileNameMap.get(EXT);
        return buildFileName(name,ext);
    }

    /**
     * 文件名截取 [uuid_name.ext]
     * @param fileNameString 文件名
     * @return Map<String,String>
     */
    public static Map<String,String> parseAliasName(String fileNameString) {
        Map<String,String> AliasNameMap = new HashMap<>();
        Map<String, String> nameMap = parseFileName(fileNameString);
        String fileName = nameMap.get(NAME);
        String [] result = new String[2];
        if (fileName.contains("_")) {
            String[] stringTemp = fileName.split("_");
            /** 第一个必是也必须是ID */
            result[0] = stringTemp[0];
            if (stringTemp.length > 2) {
                StringBuilder nameBuffer = new StringBuilder();
                for (int i = 1; i < stringTemp.length; i++) {
                    nameBuffer.append("_").append(stringTemp[i]);
                }
                result[1] = nameBuffer.toString().substring(1);
            } else {
                result[1] = stringTemp[1];
            }
        } else {
            result[0] = null;
            result[1] = fileName;

        }
        AliasNameMap.put(UUID,result[0]);
        AliasNameMap.put(NAME,result[1]);
        AliasNameMap.put(EXT,nameMap.get(EXT));
        return AliasNameMap;
    }

    public static String buildAliasName(String name,String ext) {
        String uuid = RiceRandomUtils.uuid();
        return uuid + "_" + name+"." + ext;
    }


    /**
     * 文件名截取 [name_uuid]
     * @param sliceNameString 分片文件名
     * @return Map<String,String>
     */
    public static Map<String,String> parseSliceName(String sliceNameString) {
        Map<String,String> sliceMap = new HashMap<>();
        String [] result = new String[2];
        if (sliceNameString.contains("_")) {
            String[] stringTemp = sliceNameString.split("_");
            /** 最后一个必是也必须是uuid */
            result[1] = stringTemp[stringTemp.length - 1];
            if (stringTemp.length > 2) {
                StringBuilder nameBuffer = new StringBuilder();
                for (int i = 0; i < stringTemp.length - 1; i++) {
                    nameBuffer.append("_").append(stringTemp[i]);
                }
                result[0] = nameBuffer.toString().substring(1);
            } else {
                result[0] = stringTemp[0];
                result[1] = null;
            }
        }
        sliceMap.put(UUID,result[0]);
        sliceMap.put(NAME,result[1]);
        return sliceMap;
    }


    public static void main(String[] args) {
        String s = buildAliasName("511_test", "ext");
        Map<String, String> map = parseAliasName(s);
        System.out.println(RiceJsonUtils.parserJson(map));

        String s1 = buildFileName("aa_test", "ext");
        Map<String, String> maps = parseFileName(s1);
        System.out.println(RiceJsonUtils.parserJson(maps));
    }


}
