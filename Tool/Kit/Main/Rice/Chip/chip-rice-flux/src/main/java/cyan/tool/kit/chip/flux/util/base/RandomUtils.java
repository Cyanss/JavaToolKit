package cyan.tool.kit.chip.flux.util.base;

import java.util.UUID;

/**
 * <p>RandomUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:34 2019/12/19
 */
public class RandomUtils {
    private static final String BASE_SYMBOL = "!@#$%^&*()[]{}\";:+~·=-/,.<>?\\|";
    private static final String BASE_STRING_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String BASE_STRING_LOWER = BASE_STRING_UPPER.toLowerCase();
    private static final String BASE_REGEX = "_";
    private static final String BASE_NUMBER = "0123456789";
    private static final Integer MIN_LENGTH = 3;

    public static synchronized String uuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static synchronized Long randomLong() {
        return System.currentTimeMillis() + (long) ((int) (Math.random() * 10000));
    }

    public static synchronized Double randomDouble() {
        return System.currentTimeMillis() + Math.random();
    }
}
