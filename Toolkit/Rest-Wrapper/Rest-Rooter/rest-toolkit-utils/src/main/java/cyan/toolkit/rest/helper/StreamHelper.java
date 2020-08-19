package cyan.toolkit.rest.helper;

import cyan.toolkit.rest.error.often.StreamReadException;
import cyan.toolkit.rest.error.often.StreamTransferException;
import cyan.toolkit.rest.error.often.StreamWriteException;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * <p>StreamHelper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:15 2019/12/26
 */
public class StreamHelper {

    public static void transfer(InputStream inputStream, OutputStream outputStream) throws StreamTransferException {
        try {
            int length;
            byte[] buffer = new byte[1024];
            while((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
                outputStream.flush();
            }
        } catch (IOException exception) {
            throw new StreamTransferException(exception.getMessage());
        }
    }

    public static String read(InputStream inputStream) throws StreamReadException {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempString);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (IOException exception) {
            throw new StreamReadException(exception.getMessage());
        }

    }

    public static byte[] bytes(InputStream inputStream) throws StreamReadException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int length;
            byte[] buffer = new byte[1024];
            while ((length = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            inputStream.close();
            byteArrayOutputStream.close();
            return bytes;
        } catch (IOException exception) {
            throw new StreamReadException(exception.getMessage());
        }

    }

    public static void write(OutputStream outputStream, String string) throws StreamWriteException {
        try {
            outputStream.write(string.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException exception) {
            throw new StreamWriteException(exception.getMessage());
        }

    }

    public static void write(HttpServletResponse response, String json) throws StreamWriteException {
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            OutputStream oStream = response.getOutputStream();
            oStream.write(json.getBytes());
            oStream.flush();
            oStream.close();
        } catch (IOException exception) {
            throw new StreamWriteException(exception.getMessage());
        }
    }

    public static void write(HttpServletResponse response, byte[] data) throws StreamWriteException {
        try {
            OutputStream oStream = response.getOutputStream();
            oStream.write(data);
            oStream.flush();
            oStream.close();
        } catch (IOException exception) {
            throw new StreamWriteException(exception.getMessage());
        }
    }


    public static void write(OutputStream outputStream, byte[] data) throws StreamWriteException {
        try {
            InputStream inputStream = new ByteArrayInputStream(data);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException exception) {
            throw new StreamWriteException(exception.getMessage());
        }

    }

    public static void write(File file, byte[] data) throws StreamWriteException {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            write(outputStream,data);
        } catch (IOException exception) {
            throw new StreamWriteException(exception.getMessage());
        }

    }

    public static void write(String filename, byte[] data) throws StreamWriteException {
        try {
            OutputStream outputStream = new FileOutputStream(filename);
            write(outputStream,data);
        } catch (IOException exception) {
            throw new StreamWriteException(exception.getMessage());
        }

    }

}
