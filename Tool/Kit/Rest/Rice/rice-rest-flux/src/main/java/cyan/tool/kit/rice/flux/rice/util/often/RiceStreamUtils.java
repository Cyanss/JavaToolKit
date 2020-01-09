package cyan.tool.kit.rice.flux.rice.util.often;


import cyan.tool.kit.rice.core.rice.error.often.StreamReadException;
import cyan.tool.kit.rice.core.rice.error.often.StreamWriteException;
import cyan.tool.kit.rice.flux.rice.flux.RiceStreamFluxes;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class RiceStreamUtils {

    public static String readBuffer(InputStream inputStream) {
        try {
            return RiceStreamFluxes.readBuffer(inputStream);
        } catch (StreamReadException exception) {
            log.error("It is failed during reading of inputStream!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    public static byte[] readByte(InputStream inputStream) {
        try {
            return RiceStreamFluxes.readByte(inputStream);
        } catch (StreamReadException exception) {
            log.error("It is failed during reading of inputStream!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    public static void writeOut(OutputStream outputStream, String string) {
        try {
            RiceStreamFluxes.writeOut(outputStream, string);
        } catch (StreamWriteException exception) {
            log.error("It is failed when string write to outputStream!", exception);
            exception.printStackTrace();
        }
    }

    public static void writeFile(File file, byte[] bytes) {
        try {
            RiceStreamFluxes.writeFile(file, bytes);
        } catch (StreamWriteException exception) {
            log.error("It is failed when bytes write to file!", exception);
            exception.printStackTrace();
        }
    }

}
