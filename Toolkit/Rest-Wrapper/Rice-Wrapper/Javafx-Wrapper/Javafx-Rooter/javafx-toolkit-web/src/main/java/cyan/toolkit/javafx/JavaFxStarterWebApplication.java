package cyan.toolkit.javafx;

import cyan.toolkit.javafx.view.JFxToolMainView;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>JavaFxStarterWebApplication</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
 */

@SpringBootApplication(scanBasePackages = "cyan.toolkit.javafx")
public class JavaFxStarterWebApplication {

    public static void main(String[] args) {
        ViewManager.start(JFxToolMainView.class, args);
    }
}
