package org.fsc.saas.admin.common.enums;


import org.fsc.saas.admin.common.convention.errorcode.IErrorCode;

/**
 * ClassName:UserErrorCodeEnum
 * Package:com.nageoffer.shortlink.admin.common.enums
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/10/31 - 13:39
 * @Version: v1.0
 */
public enum UserErrorCodeEnum implements IErrorCode {

    USER_NULL("B000200","用户记录不存在"),
    USER_NAME_EXIST("B000201","用户名已存在"),
    USER_EXIST("B000202","用户名已存在"),
    USER_SAVE_ERROR("B000203","用户记录新增失败");

    private final String code;

    private final String message;
    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
