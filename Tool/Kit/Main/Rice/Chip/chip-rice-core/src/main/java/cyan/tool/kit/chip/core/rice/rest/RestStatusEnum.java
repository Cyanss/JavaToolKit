package cyan.tool.kit.chip.core.rice.rest;


import cyan.tool.kit.chip.core.util.EmptyUtils;
import cyan.tool.kit.chip.core.util.EnumUtils;
import cyan.tool.kit.chip.core.util.RandomUtils;

/**
 * <p>RiceStatus</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:07 2019/12/16
 */
public interface RestStatusEnum extends RestStatus {

    /**
     * 通过名称获取枚举
     * @param clazz 枚举类型
     * @param name name值
     * @param <T> 泛型
     * @return T
     */
    static <T extends Enum<T>> T get(Class<T> clazz, String name){
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
    static <T extends Enum<T>> T add(Class<T> clazz, String name, Integer status, String message) {
        EnumUtils.addEnum(clazz, name, new Class[] {Integer.class, String.class },
                new Object[] {status, message});
        return get(clazz,name);
    }


    /**
     * 构建ErrorStatus
     * @param status 状态码
     * @param message 信息
     * @return IChipStatus
     */
    static <T extends Enum<T>> T add(Class<T> clazz, Integer status, String message) {
        String randomEnumName = RandomUtils.randomEnum(status);
        EnumUtils.addEnum(clazz, randomEnumName, new Class[] {Integer.class, String.class},
                new Object[] {status, message });
        return get(clazz,randomEnumName);
    }
}
