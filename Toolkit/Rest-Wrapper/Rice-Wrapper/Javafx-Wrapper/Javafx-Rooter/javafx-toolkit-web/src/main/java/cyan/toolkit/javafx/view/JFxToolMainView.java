package cyan.toolkit.javafx.view;

import cyan.toolkit.javafx.JavaFxView;
import de.felixroske.jfxsupport.FXMLView;

/**
 * <p>JFxToolMainView</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 15:31 2020/7/22
 */
@FXMLView(value = "/javafx/view/JFxToolMainView.fxml")
public class JFxToolMainView extends JavaFxView {
    public JFxToolMainView() {
        super();
        setWidth(600.0);
        setHeight(400.0);
    }
}
