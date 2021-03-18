package cyan.toolkit.javafx;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.stage.StageStyle;

/**
 * <p>GxFxmlView</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:12 2020/8/14
 */
public class JavaFxView extends AbstractFxmlView {
    private String value;

    private String[] css;

    private String bundle;

    private String encoding;

    private String title;

    private StageStyle stageStyle;

    private Double width;

    private Double height;

    private final FXMLView annotation = getFXMLAnnotation();

    public JavaFxView() {
        super();
        this.value = this.annotation.value();
        this.css = this.annotation.css();
        this.bundle = this.annotation.bundle();
        this.encoding = this.annotation.encoding();
        this.title = this.annotation.title();
        String style = this.annotation.stageStyle();
        this.stageStyle = StageStyle.valueOf(style.toUpperCase());
    }

    private FXMLView getFXMLAnnotation() {
        Class<? extends AbstractFxmlView> clazz = this.getClass();
        FXMLView annotation = clazz.getAnnotation(FXMLView.class);
        return annotation;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String[] getCss() {
        return css;
    }

    public void setCss(String[] css) {
        this.css = css;
    }

    public String getBundle() {
        return bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StageStyle getStageStyle() {
        return stageStyle;
    }

    public void setStageStyle(StageStyle stageStyle) {
        this.stageStyle = stageStyle;
    }

    public FXMLView getAnnotation() {
        return annotation;
    }


}
