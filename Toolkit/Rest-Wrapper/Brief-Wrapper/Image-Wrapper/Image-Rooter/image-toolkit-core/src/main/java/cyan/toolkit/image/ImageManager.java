package cyan.toolkit.image;

import cyan.toolkit.rest.util.common.FileUtils;
import cyan.toolkit.rest.util.common.GeneralUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * <p>ImageManager</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:18 2020/8/18
 */
public class ImageManager {
    /** 监控器程序全局上下文 */
    private static ApplicationContext APPLICATION_CONTEXT;

    private static Map<String, ImageService> IMAGE_SERVICE_HOLDER;

    private static String BEAN_TYPE = "default";

    private static String IMAGE_PATH = "/default/image";

    public static void setApplicationContext(ApplicationContext context) throws BeansException {
        APPLICATION_CONTEXT = context;
    }

    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    public static void initConfig(String path,String active) {
        if (GeneralUtils.isNotEmpty(path)) {
            IMAGE_PATH = path;
        }
        if (GeneralUtils.isNotEmpty(active)) {
            BEAN_TYPE = active;
        }
        IMAGE_PATH = FileUtils.createPath(IMAGE_PATH);
        IMAGE_SERVICE_HOLDER = ImageManager.getApplicationContext().getBeansOfType(ImageService.class);
    }

    public static String id(String id) {
        String defaultPath = "default";
        if (GeneralUtils.isNotEmpty(id)) {
            defaultPath = id;
        }
        return FileUtils.createPath(IMAGE_PATH, defaultPath);

    }

    public static ImageService get() {
        if (GeneralUtils.isEmpty(IMAGE_SERVICE_HOLDER)) {
            IMAGE_SERVICE_HOLDER = APPLICATION_CONTEXT.getBeansOfType(ImageService.class);
        }
        return IMAGE_SERVICE_HOLDER.get(BEAN_TYPE);
    }

}
