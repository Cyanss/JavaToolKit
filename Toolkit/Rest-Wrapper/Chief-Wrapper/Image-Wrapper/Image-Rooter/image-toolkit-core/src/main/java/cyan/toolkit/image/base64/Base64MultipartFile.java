package cyan.toolkit.image.base64;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * <p>Base64</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:12 2020/8/19
 */
@Slf4j
public class Base64MultipartFile implements MultipartFile {
    private final byte[] content;
    private final String header;

    public Base64MultipartFile(byte[] content, String header) {
        this.content = content;
        this.header = header.split(";")[0];
    }

    @Override
    public String getName() {
        return System.currentTimeMillis() + Math.random() + "." + this.header.split("/")[1];
    }

    @Override
    public String getOriginalFilename() {
        return System.currentTimeMillis() + (int)Math.random() * 10000 + "." + this.header.split("/")[1];
    }

    @Override
    public String getContentType() {
        return this.header.split(":")[1];
    }

    @Override
    public boolean isEmpty() {
        return this.content == null || this.content.length == 0;
    }

    @Override
    public long getSize() {
        return this.content.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return this.content;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {
        new FileOutputStream(file).write(this.content);
    }

    public static MultipartFile build(String base64) {
        try {
            String[] splitString = base64.split(",");
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes;
            bytes = decoder.decodeBuffer(splitString[1]);
            for(int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] = (byte)(bytes[i] + 256);
                }
            }
            return new Base64MultipartFile(bytes, splitString[0]);
        } catch (IOException exception) {
            log.error(exception.getMessage());
            return null;
        }
    }
}
