package cyan.tool.kit.chip.parent.core;

import lombok.Getter;

/**
 * <p>RiceStatus</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2019/12/16
 */
@Getter
public enum DefaultResultStatus implements DefaultStatus{

    /** access */
    ACCESS_AUTH_ERROR(10300, "访问授权错误"),
    ACCESS_DENIED(10302, "服务器拒绝访问"),

    ACCESS_FORBIDDEN(10301, "无访问授权"),
    AUTH_INFO_FAILED(10311, "用户认证失败"),
    AUTH_INFO_ILLEGAL(10312, "非法的认证信息"),
    /** auth */
    AUTH_TOKEN_ERROR(10310, "认证失败"),
    AUTH_TOKEN_EXPIRED(10313, "认证令牌过期"),
    FAILED(400, "失败"),
    /** base */
    FIELD_ERROR(10010, "字段或参数错误"),
    FIELD_INVALID(10012, "字段或参数无效"),
    FIELD_MISSING(10011, "字段或参数缺失"),
    /** file */
    FILE_ACCESS_ERROR(10210, "文件访问出错"),
    FILE_ALREADY_EXIST(10212, "文件已经存在"),
    FILE_NOT_FOUND(10211, "文件不存在"),
    FILE_UNAVAILABLE(10213, "文件不可用"),
    JSON_PARSING_BEAN(10101, "JSON解析为Bean出错"),
    /** json */
    JSON_PARSING_ERROR(10100, "JSON解析出错"),
    JSON_PARSING_LIST(10102, "JSON解析为List出错"),
    JSON_PARSING_MAP(10104, "JSON解析为List出错"),
    JSON_PARSING_MAP_LIST(10105, "JSON解析嵌套为MapList出错"),
    JSON_PARSING_MAP_MAP(10106, "JSON解析为MapMap出错"),
    JSON_PARSING_SET(10103, "JSON解析为Set出错"),
    /** resource */
    RESOURCE_ACCESS_ERROR(10200, "资源访问出错"),
    RESOURCE_ALREADY_EXIST(10202, "访问或操作的资源已经存在"),
    RESOURCE_NOT_FOUND(10201, "访问或操作的资源不存在"),
    RESOURCE_UNAVAILABLE(10203, "访问或操作的资源不可用"),
    /** service */
    SERVICE_ACCESS_ERROR(10400, "服务访问错误"),
    SERVICE_UNAVAILABLE(10401, "访问的服务不可用"),
    SUCCESS(200, "成功"),
    /** timeout */
    TIME_OUT(10000, "访问超时"),
    ;

    private final Integer status;
    private final String message;

    DefaultResultStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


}
