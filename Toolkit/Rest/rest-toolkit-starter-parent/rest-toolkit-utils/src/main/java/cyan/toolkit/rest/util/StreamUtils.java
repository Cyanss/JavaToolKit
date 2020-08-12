package cyan.toolkit.rest.util;


import cyan.toolkit.rest.error.often.StreamReadException;
import cyan.toolkit.rest.error.often.StreamWriteException;
import cyan.toolkit.rest.helper.StreamHelper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
public class StreamUtils {

    public static String read(InputStream inputStream) {
        try {
            return StreamHelper.read(inputStream);
        } catch (StreamReadException exception) {
            log.error("It is failed during reading of inputStream!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    public static byte[] bytes(InputStream inputStream) {
        try {
            return StreamHelper.bytes(inputStream);
        } catch (StreamReadException exception) {
            log.error("It is failed during reading of inputStream!", exception);
            exception.printStackTrace();
            return null;
        }
    }

    public static void write(OutputStream outputStream, String string) {
        try {
            StreamHelper.write(outputStream, string);
        } catch (StreamWriteException exception) {
            log.error("It is failed when string write to outputStream!", exception);
            exception.printStackTrace();
        }
    }

    public static void write(HttpServletResponse response, String json) {
        try {
            StreamHelper.write(response, json);
        } catch (StreamWriteException exception) {
            log.error("It is failed when json write to response!", exception);
            exception.printStackTrace();
        }
    }

    public static void write(HttpServletResponse response, byte[] data) throws StreamWriteException {
        try {
            StreamHelper.write(response, data);
        } catch (StreamWriteException exception) {
            log.error("It is failed when data write to response!", exception);
            exception.printStackTrace();
        }
    }


    public static void write(OutputStream outputStream, byte[] data) throws StreamWriteException {
        try {
            StreamHelper.write(outputStream, data);
        } catch (StreamWriteException exception) {
            log.error("It is failed when data write to outputStream!", exception);
            exception.printStackTrace();
        }

    }

    public static void write(String filename, byte[] data) throws StreamWriteException {
        try {
            StreamHelper.write(filename, data);
        } catch (StreamWriteException exception) {
            log.error("It is failed when data write to file !", exception);
            exception.printStackTrace();
        }

    }


    public static void write(File file, byte[] data) {
        try {
            StreamHelper.write(file, data);
        } catch (StreamWriteException exception) {
            log.error("It is failed when bytes write to file!", exception);
            exception.printStackTrace();
        }
    }

}
