package cyan.toolkit.javafx;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>JavaFxAlerts</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:12 2020/8/14
 */
public class JavaFxAlerts {

    public static void info(String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        defaultMessage(null,format,Alert.AlertType.INFORMATION);
    }

    public static void info(String header, String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        defaultMessage(header,format,Alert.AlertType.INFORMATION);
    }

    public static void info(String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append,throwable);
        String format = formattingTuple.getMessage();
        defaultException(null,format,throwable, Alert.AlertType.INFORMATION);
    }

    public static void info(String header, String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append,throwable);
        String format = formattingTuple.getMessage();
        defaultException(header,format,throwable, Alert.AlertType.INFORMATION);
    }

    public static void debug(String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        defaultMessage(null,format,Alert.AlertType.CONFIRMATION);
    }

    public static void debug(String header, String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        defaultMessage(header,format,Alert.AlertType.CONFIRMATION);
    }

    public static void debug(String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append,throwable);
        String format = formattingTuple.getMessage();
        defaultException(null,format,throwable,Alert.AlertType.CONFIRMATION);
    }

    public static void debug(String header, String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append,throwable);
        String format = formattingTuple.getMessage();
        defaultException(header,format,throwable,Alert.AlertType.CONFIRMATION);
    }

    public static void warn(String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        defaultMessage(null,format,Alert.AlertType.WARNING);
    }

    public static void warn(String header, String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        defaultMessage(header, format,Alert.AlertType.WARNING);
    }

    public static void warn(String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append,throwable);
        String format = formattingTuple.getMessage();
        defaultException(null,format,throwable,Alert.AlertType.WARNING);
    }

    public static void warn(String header, String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append,throwable);
        String format = formattingTuple.getMessage();
        defaultException(header,format,throwable,Alert.AlertType.WARNING);
    }

    public static void error(String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        defaultMessage(null, format,Alert.AlertType.ERROR);
    }

    public static void error(String header, String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        defaultMessage(header, format,Alert.AlertType.ERROR);
    }

    public static void error(String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append, throwable);
        String format = formattingTuple.getMessage();
        defaultException(null,format,throwable,Alert.AlertType.ERROR);
    }

    public static void error(String header, String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append, throwable);
        String format = formattingTuple.getMessage();
        defaultException(header,format,throwable,Alert.AlertType.ERROR);
    }

    public static void error(Integer status, String message, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append);
        String format = formattingTuple.getMessage();
        defaultMessage(String.valueOf(status),format,Alert.AlertType.ERROR);
    }

    public static void error(Integer status, String message, Throwable throwable, Object ... append) {
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, append, throwable);
        String format = formattingTuple.getMessage();
        defaultException(String.valueOf(status),format,throwable,Alert.AlertType.ERROR);
    }

    public static void defaultMessage(String header, String message,Alert.AlertType alertType) {
        Alert alert = message(header, message, alertType);
        alert.showAndWait();
    }

    public static void defaultException(String header, String message, Throwable exception, Alert.AlertType alertType) {
        Alert alert = message(header, message, alertType);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        String exceptionMessage = stringWriter.toString();

        Label label = new Label("error: ");
        TextArea textArea = new TextArea(exceptionMessage);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane exceptionPane = new GridPane();
        exceptionPane.setMaxWidth(Double.MAX_VALUE);
        exceptionPane.add(label, 0, 0);
        exceptionPane.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(exceptionPane);

        alert.showAndWait();
    }


    private static Alert message(String header, String message,Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        switch (alertType) {
            case INFORMATION:
                alert.setTitle("信息");
                break;
            case WARNING:
                alert.setTitle("警告");
                break;
            case ERROR:
                alert.setTitle("错误");
                break;
            case CONFIRMATION:
                alert.setTitle("提示");
                break;
            default:
                alert.setTitle("");
                break;
        }
        alert.setHeaderText(header);
        alert.setContentText(message);
        return alert;
    }
}
