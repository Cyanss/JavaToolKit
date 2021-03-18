package cyan.toolkit.javafx.controller;


import cyan.toolkit.javafx.ViewManager;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.Initializable;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * <p>JFxToolMainController</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2020/1/9
 */
@FXMLController
public class JFxToolMainController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ViewManager.PRIMARY_STAGE.setOnShowing(this::stageOnShowing);
    }

    private void stageOnShowing(WindowEvent event) {
    }
}
