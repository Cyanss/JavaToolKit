package cyan.toolkit.token.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * <p>TokenUserProperties</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:15 2021/6/1
 */
@Component
@ConfigurationProperties(prefix = "cyan.toolkit.token.user")
public class TokenUserProperties {
    private static final String PREFIX = "token-user-server";
    private static final String DEFAULT_PATH = "classpath:default";
    private Boolean enabled = true;
    private String defaultAvatar = "noavatar.png";
    private String rootPath = "/data/token-user-server";
    private String avatarPath = "/avatar/";
    private String cachePath = "/cache/";

    public TokenUserProperties() {
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getDefaultAvatar() {
        return defaultAvatar;
    }

    public void setDefaultAvatar(String defaultAvatar) {
        this.defaultAvatar = defaultAvatar;
    }

    public String getRootPath() {
        String trim = this.rootPath.toLowerCase().trim();
        if (!trim.endsWith(PREFIX)) {
            if (!trim.endsWith(File.separator)) {
                return trim.concat(File.separator).concat(PREFIX);
            } else {
                return trim.concat(PREFIX);
            }
        }
        return trim;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getAvatarPath() {
        String trim = this.avatarPath.toLowerCase().trim();
        return concat(trim);
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getCachePath() {
        String trim = this.cachePath.toLowerCase().trim();
        return concat(trim);
    }

    public void setCachePath(String cachePath) {
        this.cachePath = cachePath;
    }

    private String concat(String path) {
        String rootPath = getRootPath();
        if (!path.startsWith(rootPath)) {
            return rootPath.concat(path).concat(File.separator);
        }
        if (!path.endsWith(File.separator)) {
            return path.concat(File.separator);
        }
        return path;
    }
}
