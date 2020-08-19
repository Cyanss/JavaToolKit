package cyan.toolkit.image.model;

import cyan.toolkit.rice.model.UuidModel;

/**
 * <p>ImageInfo</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:48 2020/8/18
 */
public class ImageInfo extends UuidModel<ImageInfo> {
    private String name;
    private String extension;
    private String path;
    private Long size;
    private Integer width;
    private Integer height;

    public ImageInfo() {
    }

    public ImageInfo(String uuid) {
        super(uuid);
    }

    public ImageInfo(ImageInfo.Builder builder) {
        super(builder);
        this.name = builder.name;
        this.extension = builder.extension;
        this.path = builder.path;
        this.size = builder.size;
        this.width = builder.width;
        this.height = builder.height;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public static class Builder extends UuidModel.Builder {
        protected String name;
        protected String extension;
        protected String path;
        protected Long size;
        protected Integer width;
        protected Integer height;

        public Builder() {
        }

        public ImageInfo.Builder uuid(String uuid) {
            super.uuid(uuid);
            return this;
        }

        public ImageInfo.Builder name(String name) {
            this.name = name;
            return this;
        }

        public ImageInfo.Builder extension(String extension) {
            this.extension = extension;
            return this;
        }

        public ImageInfo.Builder path(String path) {
            this.path = path;
            return this;
        }

        public ImageInfo.Builder size(Long size) {
            this.size = size;
            return this;
        }

        public ImageInfo.Builder width(Integer width) {
            this.width = width;
            return this;
        }

        public ImageInfo.Builder height(Integer height) {
            this.height = height;
            return this;
        }

        public ImageInfo build() {
            return new ImageInfo(this);
        }
    }

}
