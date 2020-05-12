package cyan.toolkit.rest.tool;

import cyan.toolkit.rest.error.often.FileCopyException;
import cyan.toolkit.rest.error.often.FileCreateException;
import cyan.toolkit.rest.kit.FileKitUtils;
import cyan.toolkit.rest.util.NameUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Map;

@Slf4j
public class FileToolUtils {

    public static File createFile(String path) {
        return createFile(new File(path));
    }

    public static File createFile(String path, Map<String, String> nameMap) {
        return createFile(new File(path + "/" + nameMap.get(NameUtils.NAME) + nameMap.get(NameUtils.EXT)));
    }

    public static File createFile(String path, String name, String ext) {
        return createFile(new File(path + "/" + name + ext));
    }

    public static File createFile(File file) {
        try {
            return FileKitUtils.createFile(file);
        } catch (FileCreateException exception) {
            log.error("It is failed during creating of file!",exception);
            exception.printStackTrace();
        }
        return file;
    }

    public static void copyFile(File srcFile, File targetFile) {
        try {
            FileKitUtils.copyFile(srcFile,targetFile);
        } catch (FileCopyException exception) {
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
        return FileKitUtils.deleteFile(path);
    }

    public static Boolean deleteFile(File file) {
        return FileKitUtils.deleteFile(file);
    }

    public static Boolean clearFile(String path) {
        return FileKitUtils.clearFile(path);
    }
}
