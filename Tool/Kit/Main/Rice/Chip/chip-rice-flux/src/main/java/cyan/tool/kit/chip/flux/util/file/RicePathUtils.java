package cyan.tool.kit.chip.flux.util.file;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;


public class RicePathUtils {

    public static String getRootPath() {
        File file;
        String path = null;
        try {
            file = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!file.exists()) {
                file = new File("");
            }
            path = file.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String getChildPath(String childName) {
        String rootPath = getRootPath();
        //如果上传目录为/static/temp/，则可以如下获取：
        File file = new File(rootPath, "static/" + childName + "/");
        if(!file.exists()) {
            boolean mkdirs = file.mkdirs();
        }
        return file.getAbsolutePath();
    }

}
