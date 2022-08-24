package com.smile.common.exception;

import com.smile.common.enums.BizEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @ClassName BizException
 * @Author smile
 * @date 2022.07.31 19:14
 */
@Getter
@Setter
public class BizException extends RuntimeException {

    private Integer code;
    private String message;

    public BizException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BizException(BizEnum bizEnum) {
        this.code = bizEnum.getCode();
        this.message = bizEnum.getMessage();
    }

    public BizException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "BizException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
