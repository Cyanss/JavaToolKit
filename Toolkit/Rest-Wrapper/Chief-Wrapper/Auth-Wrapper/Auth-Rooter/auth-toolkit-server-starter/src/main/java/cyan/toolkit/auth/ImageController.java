package cyan.toolkit.image;

import cyan.toolkit.image.base64.Base64MultipartFile;
import cyan.toolkit.image.model.ImageCapability;
import cyan.toolkit.image.model.ImageInfo;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.RestResult;
import cyan.toolkit.rest.error.often.FieldNullException;
import cyan.toolkit.rest.util.GeneralUtils;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * <p>ImageController</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:12 2020/8/18
 */
@CrossOrigin
@RestController
@RequestMapping({"/image"})
public class ImageController {

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("files") MultipartFile[] files) throws RestException {
        if (GeneralUtils.isEmpty(files)) {
            throw new FieldNullException("files","请选择要上传的图片！");
        }
        ImageService imageService = ImageManager.get();
        List<ImageInfo> imageInfoList = new ArrayList<>();
        for (MultipartFile file : files) {
            if (imageService.support(file)) {
                ImageInfo upload = imageService.upload(file);
                imageInfoList.add(upload);
            }
        }
        String message = imageInfoList.size() == files.length ? "全部成功！" : "部分未成功已忽略！";
        return RestResult.ok(message,imageInfoList);
    }

    @PostMapping("/upload/base64")
    public ResponseEntity upload(@RequestBody String base64) throws RestException {
        if (GeneralUtils.isEmpty(base64)) {
            throw new FieldNullException("base64","请选择要上传的图片！");
        }
        ImageService imageService = ImageManager.get();
        MultipartFile file = Base64MultipartFile.build(base64);
        ImageInfo imageInfo = null;
        if (imageService.support(file)) {
            imageInfo = imageService.upload(file);
        }
        if (GeneralUtils.isEmpty(imageInfo)) {
            return RestResult.error("上传失败，图片格式或大小不支持！");
        } else {
            return RestResult.ok(imageInfo);
        }
    }

    @GetMapping("/info/{uuid}")
    public ResponseEntity info(@PathVariable("uuid") String uuid) throws RestException {
        ImageService imageService = ImageManager.get();
        ImageInfo imageInfo = imageService.info(uuid);
        return RestResult.ok(imageInfo);
    }

    @GetMapping("/download/{uuid}")
    public void download(@PathVariable("uuid") String uuid, HttpServletResponse response) throws RestException {
        ImageService imageService = ImageManager.get();
        ImageInfo imageInfo = imageService.info(uuid);
        response.setContentType("image/".concat(imageInfo.getExtension()));
        imageService.download(uuid,response);
    }

    @DeleteMapping({"/delete/{uuid}"})
    public ResponseEntity delete(@PathVariable("uuid") String uuid) throws RestException {
        ImageService imageService = ImageManager.get();
        imageService.delete(uuid);
        return RestResult.ok();
    }

    @GetMapping({"/capability"})
    public ResponseEntity capability() throws RestException {
        ImageService imageService = ImageManager.get();
        ImageCapability capability = imageService.capability();
        return RestResult.ok(capability);
    }

}
