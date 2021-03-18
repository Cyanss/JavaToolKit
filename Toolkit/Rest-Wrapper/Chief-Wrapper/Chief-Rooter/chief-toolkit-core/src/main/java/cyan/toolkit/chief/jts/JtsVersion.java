package cyan.toolkit.chief.jts;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.util.VersionUtil;

/**
 * <p>JtsVersion</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:15 2020/9/22
 */
public class JtsVersion implements Versioned {
    public static final Version VERSION = VersionUtil.parseVersion("0.0.1-SNAPSHOT", "cyan.tool.kit", "chief-toolkit-core");

    public JtsVersion() {
    }

    public Version version() {
        return VERSION;
    }
}
