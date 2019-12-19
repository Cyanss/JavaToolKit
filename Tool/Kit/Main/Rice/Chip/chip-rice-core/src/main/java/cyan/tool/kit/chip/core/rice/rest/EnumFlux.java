package cyan.tool.kit.chip.core.rice.rest;


import sun.reflect.ConstructorAccessor;
import sun.reflect.FieldAccessor;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class EnumFlux {

    private static final String MODIFIERS = "modifiers";
    private static final String ENUM_CONSTANT_DIRECTORY = "enumConstantDirectory";
    private static final String ENUM_CONSTANTS = "enumConstants";
    private static final String VALUES = "$VALUES";

    private static final ReflectionFactory REFLECTION_FACTORY = ReflectionFactory.getReflectionFactory();

    private static synchronized void setFailsafeFieldValue(Field field, Object target, Object value) throws NoSuchFieldException,
            IllegalAccessException {

        /** 设置属性可访问 */
        field.setAccessible(true);
        /** 修改静态常量属性 */
        Field modifiersField = Field.class.getDeclaredField(MODIFIERS);
        modifiersField.setAccessible(true);
        int modifiers = modifiersField.getInt(field);

        /** 清空修饰符int中的最后一位 */
        modifiers &= ~Modifier.FINAL;
        modifiersField.setInt(field, modifiers);

        FieldAccessor fieldAccessor = REFLECTION_FACTORY.newFieldAccessor(field, false);
        fieldAccessor.set(target, value);
    }

    private static synchronized void blankField(Class<?> enumClass, String fieldName) throws NoSuchFieldException,
            IllegalAccessException {
        for (Field field : Class.class.getDeclaredFields()) {
            if (field.getName().contains(fieldName)) {
                AccessibleObject.setAccessible(new Field[] { field }, true);
                setFailsafeFieldValue(field, enumClass, null);
                break;
            }
        }
    }

    private static synchronized void cleanEnumCache(Class<?> enumClass) throws NoSuchFieldException, IllegalAccessException {
        /** Sun (Oracle?!?) JDK 1.5/6 */
        blankField(enumClass, ENUM_CONSTANT_DIRECTORY);
        /** IBM JDK */
        blankField(enumClass, ENUM_CONSTANTS);
    }

    private static synchronized ConstructorAccessor getConstructorAccessor(Class<?> enumClass, Class<?>[] additionalParameterTypes)
            throws NoSuchMethodException {
        Class<?>[] parameterTypes = new Class[additionalParameterTypes.length + 2];
        parameterTypes[0] = String.class;
        parameterTypes[1] = int.class;
        System.arraycopy(additionalParameterTypes, 0, parameterTypes, 2, additionalParameterTypes.length);
        return REFLECTION_FACTORY.newConstructorAccessor(enumClass.getDeclaredConstructor(parameterTypes));
    }

    private static synchronized Object makeEnum(Class<?> enumClass, String value, int ordinal, Class<?>[] additionalTypes,
                                   Object[] additionalValues) throws Exception {
        Object[] parms = new Object[additionalValues.length + 2];
        parms[0] = value;
        parms[1] = ordinal;
        System.arraycopy(additionalValues, 0, parms, 2, additionalValues.length);
        return enumClass.cast(getConstructorAccessor(enumClass, additionalTypes).newInstance(parms));
    }

    /**
     * 枚举值动态添加
     * @param enumType 枚举类型
     * @param enumName 新枚举名称
     * @param additionalTypes 添加的枚举自定义类型
     * @param additionalValues 添加的枚举自定义值
     * @param <T> 类型
     */
    @SuppressWarnings("unchecked")
    public static synchronized <T extends Enum<?>> void addEnum(Class<T> enumType, String enumName, Class<?>[] additionalTypes, Object[] additionalValues) {

        /** 校验枚举 */
        if (!Enum.class.isAssignableFrom(enumType)) {
            throw new RuntimeException("class " + enumType + " is not an instance of Enum");
        }
        /** 获取内存$VALUES的数据 */
        Field valuesField = null;
        Field[] fields = enumType.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().contains(VALUES)) {
                valuesField = field;
                break;
            }
        }
        AccessibleObject.setAccessible(new Field[] { valuesField }, true);
        try {
            /** 拷贝 */
            T[] previousValues = (T[]) Objects.requireNonNull(valuesField).get(enumType);
            List<T> values = new ArrayList<>(Arrays.asList(previousValues));
            /** 构建一个新值 */
            T newValue = (T) makeEnum(enumType, enumName, values.size(), additionalTypes, additionalValues);
            /** 添加新值 */
            values.add(newValue);
            /** 设置新的值 */
            setFailsafeFieldValue(valuesField, null, values.toArray((T[]) Array.newInstance(enumType, 0)));
            /** 清空枚举缓存 */
            cleanEnumCache(enumType);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
