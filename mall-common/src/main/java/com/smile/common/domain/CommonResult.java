package com.smile.common.domain;

import com.smile.common.enums.ResultCode;
import com.smile.common.exception.ApiException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import static com.smile.common.enums.ResultCode.*;

/**
 * @Description
 * @ClassName CommonResult
 * @Author smile
 * @date 2022.07.03 18:03
 */
@Getter
@Setter
public class CommonResult<T> {

    /**
     * code
     */
    private Integer code;

    /**
     * 描述
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 操作成功
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<>(SUCCESS.getCode(), SUCCESS.getMessage());
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(SUCCESS.getCode(), SUCCESS.getMessage(), data);
    }

    /**
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(String message) {
        return new CommonResult<>(SUCCESS.getCode(), message);
    }

    /**
     * 无权限
     *
     * @param resultCode
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unauthorized(ResultCode resultCode) {
        return new CommonResult<T>(resultCode.getCode(), resultCode.getMessage());
    }

    /**
     * @param e
     * @return
     */
    public static <T> CommonResult<T> failed(ApiException e) {
        return new CommonResult<T>(e.getCode(), e.getMessage(), null);
    }

    /**
     * 失败
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(T data) {
        return new CommonResult<T>(FAILURE.getCode(), FAILURE.getMessage(), data);
    }


    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed() {
        return new CommonResult<T>(FAILURE.getCode(), FAILURE.getMessage());
    }
}
