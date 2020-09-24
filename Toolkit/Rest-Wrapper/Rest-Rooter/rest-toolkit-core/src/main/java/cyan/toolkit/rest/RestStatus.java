package cyan.toolkit.rest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    String name();
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
    default Map<Integer,String> entry() {
        return Collections.singletonMap(this.getStatus(),this.getMessage());
    }

    /**
     *
     * @param clazz Class<T>
     * @param <T> T
     * @return List<T>
     */
    static <T extends RestStatus> List<T> lists(Class<T> clazz) {
        return Arrays.asList(clazz.getEnumConstants());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<Map<Integer,String>> entries(Class<T> clazz) {
        return lists(clazz).stream().map(RestStatus::entry).distinct().collect(Collectors.toList());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<Integer> statuses(Class<T> clazz) {
        return lists(clazz).stream().map(RestStatus::getStatus).distinct().collect(Collectors.toList());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<String> messages(Class<T> clazz) {
        return lists(clazz).stream().map(RestStatus::getMessage).distinct().collect(Collectors.toList());
    }

    /**
     * pa
     * @param clazz 枚举类型
     * @param status status值
     * @param <T> 泛型
     * @return boolean
     */
    static <T extends RestStatus> Boolean confirm(Class<T> clazz, Integer status) {
        return Optional.ofNullable(parseStatus(clazz,status)).isPresent();
    }


    /**
     * 根据status获取枚举值
     * @param clazz 枚举类型
     * @param status status值
     * @param <T> 泛型
     * @return T
     */
    static <T extends RestStatus> T parseStatus(Class<T> clazz, Integer status){
        if (status != null && clazz.isEnum()) {
            Map<Integer, T> errorMap = Stream.of(clazz.getEnumConstants()).collect(Collectors.toMap(RestStatus::getStatus, Function.identity()));
            return errorMap.get(status);
        }
        return null;
    }

}
