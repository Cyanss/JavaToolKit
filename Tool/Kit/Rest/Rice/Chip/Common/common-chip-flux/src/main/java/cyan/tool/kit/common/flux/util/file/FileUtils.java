package cyan.tool.kit.common.flux.util.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Map;

@Slf4j
public class FileUtils {

    public static File createFile(String path) {
        return createFile(path);
    }

    public static File createFile(String path, Map<String, String> nameMap) {
        return createFile(new File(path + "/" + nameMap.get(NameUtils.NAME) + nameMap.get(NameUtils.EXT)));
    }

    public static File createFile(String path, String name, String ext) {
        return createFile(new File(path + "/" + name + ext));
    }

    public static File createFile(File file) {
        if (!file.exists()) {
            try {
                boolean newFile = file.createNewFile();
            } catch (IOException exception) {
                log.error("It is failed during creating of file!",exception);
                exception.printStackTrace();
            }
        }
        return file;
    }

    public static void copyFile(File srcFile, File targetFile) {
        FileChannel input;
        FileChannel output;
        try {
            input = new FileInputStream(srcFile).getChannel();
            output = new FileOutputStream(targetFile).getChannel();
            output.transferFrom(input, 0, input.size());
            input.close();
            output.close();
        } catch (Exception exception) {
            log.error("It is failed during copying of file!",exception);
            exception.printStackTrace();
        }
    }

    public static void copyFile(String srcPath, String targetPath) {
        File srcFile = new File(srcPath);
        File targetFile = new File(targetPath);
        copyFile(srcFile, targetFile);
    }

    public static Boolean deleteFile(String path) {
        File file = new File(path);
        return deleteFile(file);
    }

    public static Boolean deleteFile(File file) {
        if (file.exists() && file.isFile()) {
            return file.delete();
        } else {
            return true;
        }
    }

    public static Boolean clearFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            return false;
        }
        String[] tempList = file.list();
        File temp;
        for (int i = 0; tempList != null && i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                boolean delete = temp.delete();
            }
            if (temp.isDirectory()) {
                /** 先删除文件夹里面的文件 */
                clearFile(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }
}
