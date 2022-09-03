package com.smile.common.enums;

import lombok.Getter;

/**
 * @Description
 * @ClassName BizEnum
 * @Author smile
 * @date 2022.07.03 18:09
 */
@Getter
public enum ResultCode {
    SUCCESS(10000, "操作成功"),
    FAILURE(10024, "操作失败"),
    /**
     * 管理后台
     */
    REGISTRY_ALREADY(10001, "用户名已注册"),
    REGISTRY_SUCCESS(10002, "注册成功"),

    USER_PASSWORD_ERROR(10003, "用户名或密码错误"),
    PASSWORD_ERROR(10003, "密码不正确"),
    ACCOUNT_FREEZE(10004, "账号已被冻结"),
    TOKEN_EXPIRED(10005, "token已过期"),
    UNAUTHORIZED(10006, "暂未登录或token已经过期"),
    FORBIDDEN(10007, "没有相关权限"),
    VALIDATE_FAILED(10008, "参数检验失败");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BizEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
