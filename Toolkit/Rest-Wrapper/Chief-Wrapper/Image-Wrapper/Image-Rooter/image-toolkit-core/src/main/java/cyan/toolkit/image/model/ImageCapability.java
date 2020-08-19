package cyan.toolkit.image.model;

import lombok.Data;

import java.util.List;

/**
 * <p>ImageServiceCapability</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:57 2020/8/18
 */
@Data
public class ImageCapability {
    private Boolean upload;
    private Boolean remove;
    private Boolean process;
    private Long limit;
    private List<String> support;

    public ImageCapability() {
    }
}
