package cyan.tool.kit.rice.flux.rice.flux;

import cyan.tool.kit.rice.core.rice.error.often.StreamReadException;
import cyan.tool.kit.rice.core.rice.error.often.StreamWriteException;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * <p>RiceStreamHelper</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:15 2019/12/26
 */
public class RiceStreamFluxes {

    public static String readBuffer(InputStream inputStream) throws StreamReadException {
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

    public static byte[] readByte(InputStream inputStream) throws StreamReadException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
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

    public static void writeOut(OutputStream outputStream, String string) throws StreamWriteException {
        try {
            outputStream.write(string.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException exception) {
            throw new StreamWriteException(exception.getMessage());
        }

    }

    public static void writeFile(File file, byte[] bytes) throws StreamWriteException {
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
            throw new StreamWriteException(exception.getMessage());
        }
       
    }
}
