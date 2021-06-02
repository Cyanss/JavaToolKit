package cyan.toolkit.scrap.jts.error;

/**
 * <p>InvalidBoxRangeException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:03 2020/9/19
 */
public class JtsBoxInvalidException extends JtsParseException {
    public static final Integer ERROR_STATUS = 10701;
    public static final String ERROR_MESSAGE = "box范围无效";
    public JtsBoxInvalidException() {
        super(ERROR_STATUS,ERROR_MESSAGE);
    }

    public JtsBoxInvalidException(String message) {
        super(ERROR_STATUS,message);
    }

    public JtsBoxInvalidException get() {
        return new JtsBoxInvalidException();
    }

    public String name() {
        return "box invalid exception";
    }
}
