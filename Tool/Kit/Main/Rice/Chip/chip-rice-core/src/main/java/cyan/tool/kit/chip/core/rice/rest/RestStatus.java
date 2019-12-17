package cyan.tool.kit.chip.core.rice.rest;

import cyan.tool.kit.chip.core.rice.bean.ErrorStatus;
import cyan.tool.kit.chip.core.util.EmptyUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
     * 转换bean
     * @return ErrorStatus
     */
    ErrorStatus cast();

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<T> enums(Class<T> clazz) {
        return Arrays.asList(clazz.getEnumConstants());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<Map<Integer,String>> entries(Class<T> clazz) {
        return enums(clazz).stream().map(RestStatus::entry).distinct().collect(Collectors.toList());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<Integer> statuses(Class<T> clazz) {
        return enums(clazz).stream().map(RestStatus::getStatus).distinct().collect(Collectors.toList());
    }

    /**
     * message集合 <message>
     * @return Set<String>
     */
    static <T extends RestStatus> List<String> messages(Class<T> clazz) {
        return enums(clazz).stream().map(RestStatus::getMessage).distinct().collect(Collectors.toList());
    }



    /**
     * 根据status获取枚举值
     * @param clazz 枚举类型
     * @param status status值
     * @param <T> 泛型
     * @return T
     */
    static <T extends RestStatus> T get(Class<T> clazz, Integer status){
        if (EmptyUtils.isNotEmpty(status)) {
            List<T> enumList = Arrays.asList(clazz.getEnumConstants());
            Map<Integer, T> errorMap = enumList.stream().collect(Collectors.toMap(RestStatus::getStatus, error -> error));
            return errorMap.get(status);
        }
        return null;
    }

}
