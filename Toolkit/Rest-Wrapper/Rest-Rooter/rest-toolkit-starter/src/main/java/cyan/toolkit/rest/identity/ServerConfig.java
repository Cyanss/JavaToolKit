package cyan.toolkit.rest.identity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * <p>ServerConfig</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:30 2020/12/15
 */
@Builder
@AllArgsConstructor
public class ServerConfig {
    @JsonIgnore
    public static final String IP_ADDRESS = "spring.cloud.client.ip-address";
    @JsonIgnore
    public static final String SERVER_PORT = "server.port";
    @JsonIgnore
    public static final String APP_NAME = "spring.application.name";

    private String ip;
    private String port;
    private String name;

    public ServerConfig() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toServer() {
        return name + "/" + ip + ":" + name + ":" + port;
    }
}
