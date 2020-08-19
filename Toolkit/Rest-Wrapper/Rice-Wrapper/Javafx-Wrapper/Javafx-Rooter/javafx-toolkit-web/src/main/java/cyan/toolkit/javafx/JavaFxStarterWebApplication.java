package cyan.toolkit.javafx;

import cyan.toolkit.javafx.view.JFxToolMainView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>CloudStarterWebApplication</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:00 2020/7/22
 */

@SpringBootApplication(scanBasePackages = "cyan.toolkit.javafx")
public class JavaFxStarterWebApplication {

    public static void main(String[] args) {
        ViewManager.start(JFxToolMainView.class, args);
    }
}
