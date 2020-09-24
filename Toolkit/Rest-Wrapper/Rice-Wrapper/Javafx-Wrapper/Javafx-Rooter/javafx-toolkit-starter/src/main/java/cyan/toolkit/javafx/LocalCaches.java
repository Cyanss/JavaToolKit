package cyan.toolkit.javafx;

import cyan.toolkit.javafx.configure.JavaFxStarterProperties;
import cyan.toolkit.rest.util.common.FileUtils;
import cyan.toolkit.rest.util.common.GeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>ToolCacheManager</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:12 2020/8/14
 */
@Slf4j
@Component
public class LocalCaches implements InitializingBean {
    @Autowired
    private JavaFxStarterProperties properties;
    private static final String DEFAULT_EXT = ".properties";
    private static final String DEFAULT_NAME = "local-cache";
    /** 缓存配置文件地址 */
    private static String CACHE_PATH = null;
    public static String CACHE_PATH_ALL = null;
    /** Properties对象用于读取Properties配置文件 */
    private static Properties PROPERTIES = null;

    @Override
    public void afterPropertiesSet() {
        String localCache = properties.getLocalCache().getPath();
        if (localCache.endsWith(DEFAULT_EXT)) {
            CACHE_PATH = localCache;
        } else {
            CACHE_PATH = localCache.concat(File.separator).concat(DEFAULT_NAME).concat(DEFAULT_EXT);
        }
        CACHE_PATH_ALL = LocalCaches.class.getResource(CACHE_PATH).getFile();
        CACHE_PATH_ALL = FileUtils.createPath(CACHE_PATH_ALL);
    }

    public static void load() {
        PROPERTIES = new Properties();
        InputStream inputStream = LocalCaches.class.getResourceAsStream(CACHE_PATH);
        try {
            PROPERTIES.load(inputStream);
        } catch (Exception exception) {
            exception.printStackTrace();
            log.error("本地缓存文件读取错误！error: {} , path: {}", exception, exception.getMessage(), CACHE_PATH);
        }
    }

    public static String get(String key) {
        if (GeneralUtils.isEmpty(PROPERTIES)) {
            load();
        }
        return PROPERTIES.getProperty(key);
    }

    public static void set(String key, String value) {
        if (GeneralUtils.isEmpty(PROPERTIES)) {
            load();
        }
        PROPERTIES.setProperty(key, value);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(CACHE_PATH_ALL);
            PROPERTIES.store(fileOutputStream, "");
        } catch (IOException exception) {
            exception.printStackTrace();
            log.error("本地缓存修改错误！error: {} , key: {} , value: {}", exception, exception.getMessage(), key, value);
        } finally {
            FileUtils.close(fileOutputStream);
        }
    }

    public static void delete(String key) {
        if (GeneralUtils.isEmpty(PROPERTIES)) {
            load();
        }
        PROPERTIES.remove(key);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(CACHE_PATH_ALL);
            PROPERTIES.store(fileOutputStream, "");
        } catch (IOException exception) {
            exception.printStackTrace();
            log.error("本地缓存配置项删除错误！error: {} , key: {}", exception, exception.getMessage(), key);
        } finally {
            FileUtils.close(fileOutputStream);
        }
    }

    public static Map<String, String> values() {
        if (GeneralUtils.isEmpty(PROPERTIES)) {
            load();
        }
        Enumeration enumeration = PROPERTIES.propertyNames();
        Map<String, String> values = null;
        while (enumeration.hasMoreElements()) {
            Object element = enumeration.nextElement();
            if (GeneralUtils.isEmpty(values)) {
                values = new HashMap<>();
            }
            String key = String.valueOf(element);
            String value = PROPERTIES.getProperty(key);
            values.put(key, value);
        }
        return values;
    }

}
