package cyan.tool.kit.chip.starter.flux.often;

import cyan.tool.kit.rice.core.rice.error.often.FileCopyException;
import cyan.tool.kit.rice.core.rice.error.often.FileCreateException;
import cyan.tool.kit.chip.starter.util.often.NameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Map;

/**
 * <p>RiceFileHelper</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:37 2019/12/26
 */
public class FileFluxes {
    public static File createFile(String path) throws FileCreateException {
        return createFile(new File(path));
    }

    public static File createFile(String path, String name) throws FileCreateException {
        return createFile(new File(path + "/" + name));
    }

    public static File createFile(String path, Map<String, String> nameMap) throws FileCreateException {
        return createFile(new File(path + "/" + nameMap.get(NameUtils.NAME) + nameMap.get(NameUtils.EXT)));
    }

    public static File createFile(String path, String name, String ext) throws FileCreateException {
        return createFile(new File(path + "/" + name + ext));
    }

    public static File createFile(File file) throws FileCreateException {
        if (file.exists()) {
            return file;
        }
        try {
            boolean create = file.createNewFile();
            if (!create) {
                throw new FileCreateException();
            }
            return file;
        } catch (IOException exception) {
            throw new FileCreateException(exception.getMessage());
        }
    }

    public static void copyFile(File srcFile, File targetFile) throws FileCopyException {
        try {
            FileChannel input = new FileInputStream(srcFile).getChannel();
            FileChannel output = new FileOutputStream(targetFile).getChannel();
            output.transferFrom(input, 0, input.size());
            input.close();
            output.close();
        } catch (IOException exception) {
            throw new FileCopyException(exception.getMessage());
        }
    }

    public static void copyFile(String srcPath, String targetPath) throws FileCopyException {
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
        boolean flag = true;
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
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
                flag = flag && temp.delete();
            } else if (temp.isDirectory()) {
                String subPath = path + "/" + tempList[i];
                flag = flag && clearFile(subPath);
            }
        }
        return flag && file.delete();
    }
}
