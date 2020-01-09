package cyan.tool.kit.rice.flux.rice.util.natives;

import java.util.Random;
import java.util.UUID;

/**
 * <p>RandomUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:34 2019/12/19
 */
public class RiceRandomUtils {
    private static final String BASE_SYMBOL = "!@#$%^&*()[]{}\";:+~·=-/,.<>?\\|";
    private static final String BASE_STRING_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String BASE_STRING_LOWER = BASE_STRING_UPPER.toLowerCase();
    private static final String BASE_REGEX = "_";
    private static final String BASE_NUMBER = "0123456789";
    private static final Integer MIN_LENGTH = 3;
    private static final Random RANDOM = new Random();

    public static synchronized String uuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static synchronized Long randomLong() {
        return System.currentTimeMillis() + (long) ((int) (Math.random() * 10000));
    }

    public static synchronized Double randomDouble() {
        return System.currentTimeMillis() + Math.random();
    }

    public static synchronized Integer randomInt() {
        return RANDOM.nextInt();
    }

    public static String randomId() {
        return randomId(16);
    }

    public static String randomId(int length) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            int d = Math.abs(randomInt()) % (26 + 26 + 10);

            int c = (d < 10 ? ('0' + d)
                    : (d < 36 ? ('A' + d - 10)
                    : 'a' + d - 36));

            result.append((char) c);
        }

        return new String(result);
    }
}
