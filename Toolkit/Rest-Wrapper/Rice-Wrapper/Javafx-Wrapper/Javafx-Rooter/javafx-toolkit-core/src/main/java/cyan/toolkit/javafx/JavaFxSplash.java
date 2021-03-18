package cyan.toolkit.javafx;

import de.felixroske.jfxsupport.SplashScreen;
import org.springframework.stereotype.Component;

/**
 * <p>GxSplashScreen</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:12 2020/8/14
 */
@Component
public class JavaFxSplash extends SplashScreen {
    @Override
    public boolean visible() {
        return false;
    }
}
