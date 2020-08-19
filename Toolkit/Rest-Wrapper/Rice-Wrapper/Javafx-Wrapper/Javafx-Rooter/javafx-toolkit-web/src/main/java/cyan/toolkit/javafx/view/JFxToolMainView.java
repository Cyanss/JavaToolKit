package cyan.toolkit.javafx.view;

import cyan.toolkit.javafx.JavaFxView;
import de.felixroske.jfxsupport.FXMLView;

/**
 * <p>JFxToolMainView</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
 */
@FXMLView(value = "/javafx/view/JFxToolMainView.fxml")
public class JFxToolMainView extends JavaFxView {
    public JFxToolMainView() {
        super();
        setWidth(600.0);
        setHeight(400.0);
    }
}
