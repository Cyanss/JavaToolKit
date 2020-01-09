package cyan.tool.kit.rice.core.rice.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>RiceStatus</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:07 2019/12/16
 */
public interface RestStatus {

    /**
     * 获取名字
     * @return String
     */
    String getName();
    /**
     * 获取错误码
     * @return Integer
     */
    Integer getStatus();

    /**
     * 获取错误信息
     * @return String
     */
    String getMessage();

    /**
     * 枚举信息 <status,message>
     * @return Map<Integer,String>
     */
    Map<Integer,String> entry();

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<T> values(Class<T> clazz) {
        return Arrays.asList(clazz.getEnumConstants());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<Map<Integer,String>> entry(Class<T> clazz) {
        return values(clazz).stream().map(RestStatus::entry).distinct().collect(Collectors.toList());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<Integer> status(Class<T> clazz) {
        return values(clazz).stream().map(RestStatus::getStatus).distinct().collect(Collectors.toList());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<String> message(Class<T> clazz) {
        return values(clazz).stream().map(RestStatus::getMessage).distinct().collect(Collectors.toList());
    }

    /**
     * pa
     * @param clazz 枚举类型
     * @param status status值
     * @param <T> 泛型
     * @return boolean
     */
    static <T extends RestStatus> Boolean confirm(Class<T> clazz, Integer status) {
        return Optional.ofNullable(get(clazz,status)).isPresent();
    }


    /**
     * 根据status获取枚举值
     * @param clazz 枚举类型
     * @param status status值
     * @param <T> 泛型
     * @return T
     */
    static <T extends RestStatus> T get(Class<T> clazz, Integer status){
        List<T> enumList = Arrays.asList(clazz.getEnumConstants());
        Map<Integer, T> errorMap = enumList.stream().collect(Collectors.toMap(RestStatus::getStatus, error -> error));
        return errorMap.get(status);
    }

}
