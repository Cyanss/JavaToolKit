package cyan.toolkit.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * <p>LoggerUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:07 2019/12/16
 */
public class LoggerUtils {
    private static Logger DEFAULT_LOGGER = LoggerFactory.getLogger(LoggerUtils.class);

    public LoggerUtils() {
    }

    public static void info(String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.info(format);
    }

    public static void info(String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append,throwable);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.info(format,throwable);
    }

    public static void debug(String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.debug(format);
    }

    public static void debug(String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append,throwable);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.debug(format,throwable);
    }

    public static void warn(String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.warn(format);
    }

    public static void warn(String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append,throwable);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.debug(format,throwable);
    }

    public static void error(String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.error(format);
    }

    public static void error(String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append, throwable);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.error(format,throwable);
    }

    public static void error(Integer status, String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.error("status: ".concat(String.valueOf(status)).concat(", message: ").concat(format));
    }

    public static void error(Integer status, String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append, throwable);
        String format = formattingTuple.getMessage();
        DEFAULT_LOGGER.error("status: ".concat(String.valueOf(status)).concat(", message: ").concat(format).concat(", error: ").concat(throwable.getMessage()), throwable);
    }
}
