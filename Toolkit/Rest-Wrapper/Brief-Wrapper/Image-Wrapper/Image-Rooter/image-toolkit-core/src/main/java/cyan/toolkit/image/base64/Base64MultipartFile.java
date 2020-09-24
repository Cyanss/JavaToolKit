package cyan.toolkit.image.base64;

import cyan.toolkit.rest.util.often.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * <p>Base64MultipartFile</p>
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
    @NonNull
    public String getName() {
        return RandomUtils.randomDouble() + "." + this.header.split("/")[1];
    }

    @Override
    public String getOriginalFilename() {
        return RandomUtils.randomLong() + "." + this.header.split("/")[1];
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
    @NonNull
    public  byte[] getBytes() {
        return this.content;
    }

    @Override
    @NonNull
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.content);
    }

    @Override
    public void transferTo(@NonNull File file) throws IOException, IllegalStateException {
        new FileOutputStream(file).write(this.content);
    }

    public static MultipartFile build(String base64) {
        String[] splitString = base64.split(",");
        byte[] bytes;
        bytes = Base64.decodeBase64(splitString[1]);
        for(int i = 0; i < bytes.length; ++i) {
            if (bytes[i] < 0) {
                bytes[i] = (byte)(bytes[i] + 256);
            }
        }
        return new Base64MultipartFile(bytes, splitString[0]);
    }
}
