package cyan.toolkit.rest.tool;


import cyan.toolkit.rest.error.often.StreamReadException;
import cyan.toolkit.rest.error.often.StreamWriteException;
import cyan.toolkit.rest.kit.StreamKitUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class StreamToolUtils {

    public static String readBuffer(InputStream inputStream) {
        try {
            return StreamKitUtils.readBuffer(inputStream);
        } catch (StreamReadException exception) {
            log.error("It is failed during reading of inputStream!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    public static byte[] readByte(InputStream inputStream) {
        try {
            return StreamKitUtils.readByte(inputStream);
        } catch (StreamReadException exception) {
            log.error("It is failed during reading of inputStream!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    public static void writeOut(OutputStream outputStream, String string) {
        try {
            StreamKitUtils.writeOut(outputStream, string);
        } catch (StreamWriteException exception) {
            log.error("It is failed when string write to outputStream!", exception);
            exception.printStackTrace();
        }
    }

    public static void writeFile(File file, byte[] bytes) {
        try {
            StreamKitUtils.writeFile(file, bytes);
        } catch (StreamWriteException exception) {
            log.error("It is failed when bytes write to file!", exception);
            exception.printStackTrace();
        }
    }

}
