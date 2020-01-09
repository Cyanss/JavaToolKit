package cyan.tool.kit.rice.flux.rice.util.often;

import cyan.tool.kit.rest.core.rice.error.often.FileCopyException;
import cyan.tool.kit.rest.core.rice.error.often.FileCreateException;
import cyan.tool.kit.rice.flux.rice.flux.RiceFileFluxes;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Map;

@Slf4j
public class RiceFileUtils {

    public static File createFile(String path) {
        return createFile(new File(path));
    }

    public static File createFile(String path, Map<String, String> nameMap) {
        return createFile(new File(path + "/" + nameMap.get(RiceNameUtils.NAME) + nameMap.get(RiceNameUtils.EXT)));
    }

    public static File createFile(String path, String name, String ext) {
        return createFile(new File(path + "/" + name + ext));
    }

    public static File createFile(File file) {
        try {
            return RiceFileFluxes.createFile(file);
        } catch (FileCreateException exception) {
            log.error("It is failed during creating of file!",exception);
            exception.printStackTrace();
        }
        return file;
    }

    public static void copyFile(File srcFile, File targetFile) {
        try {
            RiceFileFluxes.copyFile(srcFile,targetFile);
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
        return RiceFileFluxes.deleteFile(path);
    }

    public static Boolean deleteFile(File file) {
        return RiceFileFluxes.deleteFile(file);
    }

    public static Boolean clearFile(String path) {
        return RiceFileFluxes.clearFile(path);
    }
}
