package cyan.tool.kit.chip.starter.util.common;

/**
 * <p>HexUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:42 2020/1/17
 */
public class HexUtils {
    public static byte[] parse(String digest) {
        byte[] bytes = new byte[digest.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            String byteString = digest.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            bytes[i] = (byte) byteValue;
        }
        return bytes;
    }

    public static String parse(byte[] bytes) {
        StringBuilder hexBuilder = new StringBuilder();
        for (byte b : bytes) {
            String plainText = Integer.toHexString(0xff & b);
            if (plainText.length() < 2)
                plainText = "0" + plainText;
            hexBuilder.append(plainText);
        }
        return hexBuilder.toString();
    }
}
