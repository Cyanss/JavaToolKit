package cyan.toolkit.image;

import cyan.toolkit.image.model.ImageCapability;
import cyan.toolkit.image.model.ImageInfo;
import cyan.toolkit.rest.error.natives.FileErrorException;
import cyan.toolkit.rest.error.often.StreamTransferException;
import cyan.toolkit.rest.error.supply.ParamInvalidException;
import cyan.toolkit.rest.error.supply.ResourceNotFoundException;
import cyan.toolkit.rest.util.common.FileUtils;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.often.RandomUtils;
import cyan.toolkit.rest.util.often.StreamUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * <p>DefaultImageService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:58 2020/8/18
 */
@Service("default")
final class DefaultImageService implements ImageService {

    @Override
    public Boolean support(MultipartFile file) throws ImageException {
        return true;
    }

    @Override
    public ImageInfo upload(@NonNull MultipartFile file) throws ImageException {
        String filename = file.getOriginalFilename();
        long size = file.getSize();
        assert filename != null;
        String uuid = RandomUtils.uuid();
        ImageInfo imageInfo;
        try {
            String uuidPath = ImageManager.uuid(uuid);
            String imagePath = uuidPath.concat(File.separator).concat(filename);
            FileOutputStream outputStream = new FileOutputStream(new File(imagePath));
            StreamUtils.transfer(file.getInputStream(), outputStream);
            String metaPath = uuidPath.concat(File.separator).concat(uuid).concat(".meta");
            String extension = FileUtils.extension(filename);
            if (GeneralUtils.isEmpty(extension)) {
                throw new ImageException("图片格式错误！", new ParamInvalidException());
            }
            ImageInfo.Builder builder = new ImageInfo.Builder();
            builder.uuid(uuid).extension(extension).name(filename).size(size).path(imagePath);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(metaPath));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            imageInfo = new ImageInfo(builder);
            objectOutputStream.writeObject(imageInfo);
        } catch (FileNotFoundException exception) {
            throw new ImageException("上传错误！error: ".concat(exception.getMessage()), new ResourceNotFoundException());
        } catch (IOException exception) {
            throw new ImageException("meta信息生成错误！error: ".concat(exception.getMessage()), new FileErrorException());
        }
        return imageInfo;
    }

    @Override
    public void download(@NonNull String uuid, @NonNull HttpServletResponse response) throws ImageException {
        try {
            ImageInfo imageInfo = info(uuid);
            String imagePath = imageInfo.getPath();
            FileInputStream imageInputStream = new FileInputStream(new File(imagePath));
            StreamUtils.transfer(imageInputStream, response.getOutputStream());
        } catch (FileNotFoundException exception) {
            throw new ImageException("下载错误！error: ".concat(exception.getMessage()), new ResourceNotFoundException());
        } catch (IOException exception) {
            throw new ImageException("下载错误！error: ".concat(exception.getMessage()), new StreamTransferException());
        }
    }

    @Override
    public ImageCapability capability() throws ImageException {
        return new ImageCapability();
    }

    @Override
    public ImageInfo info(String uuid) throws ImageException {
        try {
            String uuidPath = ImageManager.uuid(uuid);
            String metaPath = uuidPath.concat(File.separator).concat(uuid).concat(".meta");
            FileInputStream metaInputStream = new FileInputStream(new File(metaPath));
            ObjectInputStream objectInputStream = new ObjectInputStream(metaInputStream);
            return (ImageInfo) objectInputStream.readObject();
        } catch (FileNotFoundException | ClassNotFoundException exception) {
            throw new ImageException("下载错误！error: ".concat(exception.getMessage()), new ResourceNotFoundException());
        } catch (IOException exception) {
            throw new ImageException("meta信息读取错误！error: ".concat(exception.getMessage()), new FileErrorException());
        }
    }

    @Override
    public void delete(String uuid) throws ImageException {
        throw new ImageException("不支持文件删除!");
    }



}
