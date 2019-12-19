package cyan.tool.kit.chip.flux.util.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
public class RiceStreamUtils {

    /**
     * request请求的输入流转换为String
     * @param inputStream 输入流数据
     * @return String
     */
    public static String readBuffer(InputStream inputStream)  {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempString);
            }
            bufferedReader.close();
        } catch (IOException exception) {
            log.error("It is failed during reading of inputStream!",exception);
            exception.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * request请求的输入流转换为byte字节数组
     * @param inputStream 输入流数据
     * @return byte[]
     */
    public static byte[] readByte(InputStream inputStream)  {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        byte[] bytes = null;
        int length;
        try {
            while ((length = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            bytes = byteArrayOutputStream.toByteArray();
            inputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException exception) {
            log.error("It is failed during reading of inputStream!",exception);
            exception.printStackTrace();
        }
        return bytes;
    }

    /**
     * 将字符串写进输出流里
     * @param outputStream 输出流
     * @param string 字符数据
     */
    public static void write(OutputStream outputStream, String string)  {
        try {
            outputStream.write(string.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException exception) {
            log.error("It is failed when string write to outputStream!",exception);
            exception.printStackTrace();
        }

    }

    /**
     * byte[]字节数组写入文件
     * @param file 文件
     * @param bytes bytes数据
     */
    public static void write(File file, byte[] bytes) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException exception) {
            log.error("It is failed when bytes write to file!",exception);
            exception.printStackTrace();
        }
    }

}
