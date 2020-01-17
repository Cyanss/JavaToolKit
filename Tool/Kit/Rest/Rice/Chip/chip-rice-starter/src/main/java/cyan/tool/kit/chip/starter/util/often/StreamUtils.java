package cyan.tool.kit.chip.starter.util.often;


import cyan.tool.kit.chip.starter.flux.often.StreamFluxes;
import cyan.tool.kit.rice.core.rice.error.often.StreamReadException;
import cyan.tool.kit.rice.core.rice.error.often.StreamWriteException;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class StreamUtils {

    public static String readBuffer(InputStream inputStream) {
        try {
            return StreamFluxes.readBuffer(inputStream);
        } catch (StreamReadException exception) {
            log.error("It is failed during reading of inputStream!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    public static byte[] readByte(InputStream inputStream) {
        try {
            return StreamFluxes.readByte(inputStream);
        } catch (StreamReadException exception) {
            log.error("It is failed during reading of inputStream!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    public static void writeOut(OutputStream outputStream, String string) {
        try {
            StreamFluxes.writeOut(outputStream, string);
        } catch (StreamWriteException exception) {
            log.error("It is failed when string write to outputStream!", exception);
            exception.printStackTrace();
        }
    }

    public static void writeFile(File file, byte[] bytes) {
        try {
            StreamFluxes.writeFile(file, bytes);
        } catch (StreamWriteException exception) {
            log.error("It is failed when bytes write to file!", exception);
            exception.printStackTrace();
        }
    }

}
