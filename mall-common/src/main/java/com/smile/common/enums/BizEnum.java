package com.smile.common.enums;

import lombok.Getter;

/**
 * @Description
 * @ClassName BizEnum
 * @Author smile
 * @date 2022.07.03 18:09
 */
@Getter
public enum BizEnum {
    SUCCESS(10000, "操作成功"),
    FAILURE(10024, "操作失败"),
    REGISTRY_ALREADY(10001, "用户名已注册"),
    PASSWORD_ERROR(10002, "密码不正确"),
    ACCOUNT_FREEZE(10003, "账号已被冻结"),
    TOKEN_EXPIRED(10004, "token已过期");

    private Integer code;
    private String message;

    BizEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
