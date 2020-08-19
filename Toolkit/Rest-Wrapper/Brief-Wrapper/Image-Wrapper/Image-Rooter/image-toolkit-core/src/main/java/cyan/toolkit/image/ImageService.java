package cyan.toolkit.image;

import cyan.toolkit.image.model.ImageCapability;
import cyan.toolkit.image.model.ImageInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>ImageService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:01 2020/8/18
 */
public interface ImageService {

    Boolean support(MultipartFile file) throws ImageException;

    ImageInfo upload(MultipartFile file) throws ImageException;

    void download(String uuid, HttpServletResponse response) throws ImageException;

    ImageInfo info(String uuid) throws ImageException;

    void delete(String uuid) throws ImageException;

    ImageCapability capability() throws ImageException;

}
