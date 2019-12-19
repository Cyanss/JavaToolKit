package cyan.tool.kit.chip.core.rice.rest;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;

/**
 * <p>RiceStatus</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 13:32 2019/12/16
 */
@Getter
public enum RestResultStatus implements RestStatusEnum {

    SUCCESS(200, "成功"),
    FAILED(400, "失败"),
    /** timeout */
    UNKNOWN_ERROR(9999,"未知错误"),
    TIME_OUT(10000, "访问超时"),
    /** base */
    PARAM_ERROR(10010, "参数错误"),
    PARAM_INVALID(10012, "参数无效"),
    PARAM_MISSING(10011, "参数缺失"),
    /** json */
    PARSE_ERROR(10100, "解析错误"),
    JSON_PARSE_ERROR(10110, "JSON解析错误"),
    JSON_PARSE_BEAN(10111, "JSON解析为Bean出错"),
    JSON_PARSE_LIST(10112, "JSON解析为List出错"),
    JSON_PARSE_SET(10113, "JSON解析为Set出错"),
    JSON_PARSE_MAP(10114, "JSON解析为List出错"),
    JSON_PARSE_MAP_LIST(10115, "JSON解析为MapList出错"),
    JSON_PARSE_MAP_MAP(10116, "JSON解析为MapMap出错"),

    /** resource */
    RESOURCE_ERROR(10200, "资源错误"),
    RESOURCE_NOT_EXIST(10201, "资源不存在"),
    RESOURCE_IS_EXIST(10202, "资源已经存在"),
    RESOURCE_UNAVAILABLE(10203, "资源不可用"),

    /** file */
    FILE_ERROR(10210, "文件错误"),
    FILE_NOT_EXIST(10211, "文件不存在"),
    FILE_IS_EXIST(10212, "文件已经存在"),
    FILE_UNAVAILABLE(10213, "文件不可用"),

    /** access */
    AUTH_ERROR(10300, "权限错误"),
    AUTH_DENIED(10302, "拒绝访问"),
    AUTH_FORBIDDEN(10301, "权限不足"),

    /** auth */
    TOKEN_ERROR(10310, "认证错误"),
    TOKEN_EXPIRED(10313, "认证过期"),
    TOKEN_FAILED(10311, "认证失败"),
    TOKEN_ILLEGAL(10312, "认证无效"),

    /** service */
    SERVICE_ERROR(10400, "服务器错误"),
    SERVICE_UNAVAILABLE(10401, "服务不可用"),

    /** field */
    FIELD_ERROR(10500, "对象错误"),
    FIELD_IS_NULL(10501, "对象为空"),
    FIELD_NOT_EXIST(10502, "对象不存在"),
    FIELD_IS_EXIST(10503, "对象已存在"),
    /** name */
    NAME_ERROR(10510, "名称错误"),
    NAME_IS_NULL(10511, "名称为空"),
    NAME_NOT_EXIST(10512, "名称不存在"),
    NAME_IS_EXIST(10513, "名称已存在"),
    NAME_REPEATED(10514, "名称重复"),
    /** id */
    ID_ERROR(10520, "Id错误"),
    ID_IS_NULL(10521, "Id为空"),
    ID_NOT_EXIST(10522, "Id不存在"),
    ID_IS_EXIST(10523, "Id已存在"),
    ID_REPEATED(10524, "Id重复"),
    /** data */
    DATA_ERROR(10600, "数据错误"),
    DATA_CREATE_FAILED(10601, "数据创建失败"),
    DATA_UPDATE_FAILED(10602, "数据更新失败"),
    DATA_DELETE_FAILED(10603, "数据删除失败"),
    DATA_QUERY_FAILED(10604, "数据查询失败"),
    DATA_TRANSFORM_FAILED(10605, "数据转换失败");
    ;
    private final Integer status;
    private final String message;

    RestResultStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


    @Override
    public String getName() {
        return this.name().toLowerCase().replace("_"," ");
    }

    @Override
    public Map<Integer, String> entry() {
        return Collections.singletonMap(this.status,this.message);
    }

}
