package cyan.tool.kit.chip.core.rice.rest;

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
        if (name != null && name.length() > 0) {
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
        EnumFlux.addEnum(clazz, name, new Class[] {Integer.class, String.class },
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
        String randomEnumName = RandomFlux.randomEnum(status);
        EnumFlux.addEnum(clazz, randomEnumName, new Class[] {Integer.class, String.class},
                new Object[] {status, message });
        return get(clazz,randomEnumName);
    }

    /**
     * 构建ErrorStatus
     * @param status 状态码
     * @param message 信息
     * @return IChipStatus
     */
    static <T extends Enum<T>> T add(Class<T> clazz, Integer status, String message, String baseName) {
        String randomEnumName = RandomFlux.randomEnum(status,baseName);
        EnumFlux.addEnum(clazz, randomEnumName, new Class[] {Integer.class, String.class},
                new Object[] {status, message });
        return get(clazz,randomEnumName);
    }
}
