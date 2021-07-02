package cyan.toolkit.rest.util.common;

import cyan.toolkit.rest.error.often.FileCopyException;
import cyan.toolkit.rest.error.often.FileCreateException;
import cyan.toolkit.rest.helper.FileHelper;
import cyan.toolkit.rest.util.often.NameUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>FileUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:15 2019/12/26
 */
@Slf4j
public class FileUtils {

    public static File cacheFile(String cachePath, MultipartFile file) {
        createPath(cachePath);
        String originalFilename = file.getOriginalFilename();
        String path = cachePath + originalFilename;
        File cacheFile = new File(path);
        try {
            file.transferTo(cacheFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cacheFile;
    }

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
            return FileHelper.createFile(file);
        } catch (FileCreateException exception) {
            log.error("It is failed during creating of file!", exception);
            exception.printStackTrace();
        }
        return file;
    }

    public static void copyFile(File srcFile, File targetFile) {
        try {
            FileHelper.copyFile(srcFile, targetFile);
        } catch (FileCopyException exception) {
            log.error("It is failed during copying of file!", exception);
            exception.printStackTrace();
        }
    }

    public static void copyFile(String srcPath, String targetPath) {
        File srcFile = new File(srcPath);
        File targetFile = new File(targetPath);
        copyFile(srcFile, targetFile);
    }

    public static Boolean deleteFile(String path) {
        return FileHelper.deleteFile(path);
    }

    public static Boolean deleteFile(File file) {
        return FileHelper.deleteFile(file);
    }

    public static Boolean clearFile(String path) {
        return FileHelper.clearFile(path);
    }

    /**
     * 生成文件路径
     * @param path 文件路径
     * @return String 文件路径
     */
    public static String createPath(String path) {
        File filePath = new File(path);
        if (!filePath.exists()) {
            boolean mkdirs = filePath.mkdirs();
        }
        return filePath.getPath();
    }

    /**
     * 生成子文件路径
     * @param path 父文件路径
     * @param child 子文件路径
     * @return 子文件路径
     */
    public static String createPath(String path, String child) {
        File childPath = new File(path, child);
        if (!childPath.exists()) {
            boolean mkdirs = childPath.mkdirs();
        }
        return childPath.getPath();
    }

    /**
     * 清空文件夹及子文件
     * @param root 路径
     * @return boolean
     */
    public static boolean clear(File root) {
        if (root != null && root.exists()) {
            if (root.isDirectory()) {
                File[] children = root.listFiles();
                if (children != null) {
                    for (File child : children) {
                        clear(child);
                    }
                }
            }
            return root.delete();
        }
        return false;
    }

    /**
     * 清空文件夹及子文件
     * @param path 路径
     * @return boolean
     */
    public static boolean clear(String path) {
        File file = new File(path);
        return clear(file);
    }

    /**
     * 删除文件
     * @param path 路径
     */
    public static void delete(String path) {
        File file = new File(path);
        if (file.exists()) {
            boolean delete = file.delete();
        }
    }

    public static void delete(File file) {
        if (file.isFile()) {
            boolean delete = file.delete();
        }
    }


    /**
     * 追加写入文件
     * @param file 文件
     * @param data 写入数据
     */
    public static void write(File file, byte[] data) {
        if (!file.exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
        }
        /** 追加写入 */
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data);
            fileOutputStream.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage(), exception);
        } finally {
            close(fileOutputStream);
        }
    }

    /**
     * 读取文件
     * @param file 文件
     * @return byte[] 字节数组
     */
    public static byte[] read(File file) {
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int read = fileInputStream.read(fileContent);
            fileInputStream.close();
            return fileContent;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            close(fileInputStream);
        }
    }

    /**
     * 关闭方法
     * @param closeableArray 要关闭的流
     */
    public static void close(Closeable... closeableArray) {
        List<Closeable> closeableList = Arrays.stream(closeableArray).filter(Objects::nonNull).collect(Collectors.toList());
        if (GeneralUtils.isNotEmpty(closeableList)) {
            closeableList.forEach(closeable -> {
                try {
                    closeable.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                    log.error(exception.getMessage(), exception);
                }
            });
        }
    }

    /**
     * 关闭方法
     * @param stream 要关闭的流
     */
    public static void close(FileOutputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
                log.error(exception.getMessage(), exception);
            }

        }
    }

    /**
     * 关闭方法
     * @param threadArray 线程关闭
     */
    public static void close(Thread... threadArray) {
        List<Thread> threadList = Arrays.stream(threadArray).filter(Objects::nonNull).filter(Thread::isAlive).collect(Collectors.toList());
        if (GeneralUtils.isNotEmpty(threadList)) {
            threadList.forEach(Thread::interrupt);
        }
    }

    public static String suffix(String name){
        if(GeneralUtils.isEmpty(name)){
            return null;
        }
        return name.substring(name.lastIndexOf(".") + 1);
    }

    public static String filename(final String originalName){
        if(GeneralUtils.isEmpty(originalName)){
            return "";
        }
        return originalName.substring(0,originalName.lastIndexOf("."));
    }

    public static void writeZip(File file, HttpServletResponse response) throws Exception {
        write(file,"application/octet-stream",response);
    }

    public static void writeExcel(File file, HttpServletResponse response) throws Exception {
        write(file,"application/vnd.ms-excel",response);
    }

    public static void write(File file,String contentType, HttpServletResponse response) throws Exception {
        /** 写入response */
        String filename = file.getName();
        InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bufferCache = new byte[bufferedInputStream.available()];
        int readSize = bufferedInputStream.read(bufferCache);
        bufferedInputStream.close();
        response.reset();
        response.addHeader("Content-Disposition", "attachment;filename="
                + new String(filename.replaceAll(" ", "").getBytes(StandardCharsets.UTF_8), "iso8859-1"));
        response.addHeader("Content-Length", "" + file.length());
        response.setCharacterEncoding("UTF-8");
        OutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
        response.setContentType(contentType);
        bufferedOutputStream.write(bufferCache);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public static String fileSize(Long fileSize) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String fileSizeString;
        String wrongSize = "0B";
        if (fileSize == 0) {
            return wrongSize;
        }
        if (fileSize < 1024) {
            fileSizeString = decimalFormat.format((double) fileSize) + "B";
        } else if (fileSize < 1048576) {
            fileSizeString = decimalFormat.format((double) fileSize / 1024) + "KB";
        } else if (fileSize < 1073741824) {
            fileSizeString = decimalFormat.format((double) fileSize / 1048576) + "MB";
        } else {
            fileSizeString = decimalFormat.format((double) fileSize / 1073741824) + "GB";
        }
        return fileSizeString;
    }

    public static void attachment(HttpServletRequest request, HttpServletResponse response, String fileName) {
        String browser;
        try {
            if (request != null && request.getHeader("User-Agent") != null) {
                browser = request.getHeader("User-Agent");
                if (browser.contains("MSIE 6.0") || browser.contains("MSIE 7.0")) {
                    // IE6, IE7 浏览器
                    response.addHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
                } else if (browser.contains("MSIE 8.0")) {
                    // IE8
                    response.addHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                } else if (browser.contains("MSIE 9.0")) {
                    // IE9
                    response.addHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                } else if (browser.contains("Chrome")) {
                    // 谷歌
                    response.addHeader("content-disposition", "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
                } else if (browser.contains("Safari")) {
                    // 苹果
                    response.addHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
                } else {
                    // 火狐或者其他的浏览器
                    response.addHeader("content-disposition", "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
                }
            } else {
                response.addHeader("content-disposition", "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
