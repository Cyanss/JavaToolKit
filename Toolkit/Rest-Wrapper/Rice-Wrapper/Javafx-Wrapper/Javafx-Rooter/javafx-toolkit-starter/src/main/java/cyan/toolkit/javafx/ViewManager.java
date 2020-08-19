package cyan.toolkit.javafx;

import cyan.toolkit.rest.util.GeneralUtils;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import de.felixroske.jfxsupport.GUIState;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>ViewManager</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:13 2020/8/17
 */
@ComponentScan(basePackages = "cyan.toolkit")
public class ViewManager extends AbstractJavaFxApplicationSupport implements InitializingBean {

    private static ConfigurableApplicationContext APPLICATION_CONTEXT;
    public static Scene SCENE;
    public static Stage PRIMARY_STAGE;
    public static ViewManager INSTANCE;

    @Override
    public void afterPropertiesSet() {
        INSTANCE = this;
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        super.beforeInitialView(stage, ctx);
        APPLICATION_CONTEXT = ctx;
        PRIMARY_STAGE = stage;
    }

    public static void show(Class<? extends JavaFxView> window, Modality mode) {
        JavaFxView view = APPLICATION_CONTEXT.getBean(window);
        PRIMARY_STAGE = new Stage();
        if (view.getView().getScene() != null) {
            SCENE = view.getView().getScene();
        } else {
            SCENE = new Scene(view.getView());
        }
        PRIMARY_STAGE.setScene(SCENE);
        PRIMARY_STAGE.initModality(mode);
        PRIMARY_STAGE.initOwner(getStage());
        PRIMARY_STAGE.setTitle(view.getTitle());
        PRIMARY_STAGE.initStyle(view.getStageStyle());
        PRIMARY_STAGE.showAndWait();
    }

    public static void show(Class<? extends JavaFxView> window) {
        JavaFxView view = APPLICATION_CONTEXT.getBean(window);
        Double width = view.getWidth();
        if (GeneralUtils.isNotEmpty(width)) {
            GUIState.getStage().setWidth(width);
        }
        Double height = view.getHeight();
        if (GeneralUtils.isNotEmpty(height)) {
            GUIState.getStage().setHeight(height);
        }
        if (GUIState.getScene() == null) {
            SCENE = new Scene(view.getView());
            GUIState.setScene(SCENE);
        }
        showView(window);
    }


    public static void start(Class<? extends JavaFxView> window, String[] args) {
        launch(ViewManager.class, window, new JavaFxSplash(), args);
    }
}