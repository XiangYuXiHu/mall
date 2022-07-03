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
    SUCCESS(0, "操作成功"),
    FAILURE(1024, "操作失败");
    private Integer code;
    private String message;

    BizEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
