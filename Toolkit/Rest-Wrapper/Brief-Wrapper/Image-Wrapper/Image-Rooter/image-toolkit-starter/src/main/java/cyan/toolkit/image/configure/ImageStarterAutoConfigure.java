package cyan.toolkit.image.configure;

import cyan.toolkit.image.ImageManager;
import cyan.toolkit.image.ImageService;
import cyan.toolkit.rest.error.supply.ConfigInvalidException;
import cyan.toolkit.rest.error.supply.ServiceUnavailableException;
import cyan.toolkit.rest.util.common.GeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * <p>ImageStarterAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:18 2020/1/13
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.image"})
public class ImageStarterAutoConfigure implements ApplicationContextAware, InitializingBean {

    @Autowired
    private ImageStarterProperties properties;

    public ImageStarterAutoConfigure() {
        log.debug("================= image-toolkit-starter initiated ！ ===================");
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        ImageManager.setApplicationContext(applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String path = properties.getPath();
        if (GeneralUtils.isEmpty(path)) {
            throw new ConfigInvalidException("cyan.toolkit.image.path");
        }
        String active = properties.getActive();
        if (GeneralUtils.isEmpty(active)) {
            throw new ConfigInvalidException("cyan.toolkit.image.active");
        }
        ImageManager.initConfig(path,active);
        ImageService imageService = ImageManager.get();
        if (GeneralUtils.isEmpty(imageService)) {
            throw new ServiceUnavailableException(active);
        }
    }


}
