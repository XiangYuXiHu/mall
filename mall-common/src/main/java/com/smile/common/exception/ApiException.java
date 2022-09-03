package com.smile.common.exception;

import com.smile.common.enums.ResultCode;
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
public class ApiException extends RuntimeException {

    private Integer code;
    private String message;

    public ApiException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ApiException(String message) {
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
