package cyan.toolkit.rest.util.network;

import cyan.toolkit.rest.util.common.GeneralUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>GxIpAddressUtils</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 15:30 2020/9/3
 */
public class IpAddressUtils {
    public static final String DEFAULT_IP = "127.0.0.1";

    private String getRemoteIp(HttpServletRequest request) {
        String unknown = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private String getUserIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("0:0:0:0:0:0:0:1".equals(ip)) {
                ip = "127.0.0.1";
            }
        }
        if ("unknown".equalsIgnoreCase(ip)) {
            ip = "127.0.0.1";
            return ip;
        } else {
            int index = ip.indexOf(44);
            if (index >= 0) {
                ip = ip.substring(0, index);
            }
            return ip;
        }
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = null;

        try {
            String Xip = request.getHeader("X-Real-IP");
            String XFor = request.getHeader("X-Forwarded-For");
            if (GeneralUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
                int index = XFor.indexOf(",");
                if (index >= 0) {
                    return XFor.substring(0, index);
                }
                return XFor;
            }
            ip = Xip;
            if (GeneralUtils.isEmpty(Xip) || "unknown".equalsIgnoreCase(Xip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (GeneralUtils.isEmpty(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (GeneralUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (GeneralUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (GeneralUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if ("0:0:0:0:0:0:0:1".equals(ip)) {
                    ip = "127.0.0.1";
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ip;
    }
}
