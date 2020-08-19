package cyan.toolkit.javafx.controller;


import cyan.toolkit.javafx.ViewManager;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * <p>JFxToolMainController</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:46 2020/7/22
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
