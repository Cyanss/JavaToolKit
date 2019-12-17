package cyan.tool.kit.chip.parent.core;

import cyan.tool.kit.chip.flux.util.base.EmptyUtils;
import cyan.tool.kit.chip.flux.util.exception.EnumUtils;
import cyan.tool.kit.chip.flux.util.exception.RandomUtils;

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
public interface DefaultStatus {
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
     * 根据status获取枚举值
     * @param clazz 枚举类型
     * @param status status值
     * @param <T> 泛型
     * @return T
     */
    static <T extends DefaultStatus> T getEnum(Class<T> clazz, Integer status){
        if (EmptyUtils.isNotEmpty(status)) {
            List<T> enumList = Arrays.asList(clazz.getEnumConstants());
            Map<Integer, T> errorMap = enumList.stream().collect(Collectors.toMap(DefaultStatus::getStatus, error -> error));
            return errorMap.get(status);
        }
        return null;
    }

    /**
     * 通过名称获取枚举
     * @param clazz 枚举类型
     * @param name name值
     * @param <T> 泛型
     * @return T
     */
    static <T extends Enum<T>> T getEnum(Class<T> clazz, String name){
        if (EmptyUtils.isNotEmpty(name)) {
            return Enum.valueOf(clazz,name);
        }
        return null;
    }

    /**
     * 构建ErrorStatus
     * @param name 名称
     * @param status 状态码
     * @param message 信息
     * @return IChipStatus
     */
    static <T extends Enum<T>> T build(Class<T> clazz, String name, Integer status, String message) {
        EnumUtils.addEnum(clazz, name, new Class[] {java.lang.Integer.class, String.class },
                new Object[] {status, message});
        return getEnum(clazz,name);
    }


    /**
     * 构建ErrorStatus
     * @param status 状态码
     * @param message 信息
     * @return IChipStatus
     */
    static <T extends Enum<T>> T build(Class<T> clazz, Integer status, String message) {
        String randomEnumName = RandomUtils.randomEnum(status);
        EnumUtils.addEnum(clazz, randomEnumName, new Class[] {java.lang.Integer.class, String.class },
                new Object[] {status, message });
        return getEnum(clazz,randomEnumName);
    }
}
