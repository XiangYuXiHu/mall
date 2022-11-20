package com.smile.common.vo;

import com.smile.common.enums.ResultCode;
import com.smile.common.exception.ApiException;
import lombok.Getter;
import lombok.Setter;

import static com.smile.common.enums.ResultCode.FAILURE;
import static com.smile.common.enums.ResultCode.SUCCESS;

/**
 * @Description
 * @ClassName CommonResult
 * @Author smile
 * @date 2022.07.03 18:03
 */
@Getter
@Setter
public class BaseVo<T> {

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

    public BaseVo(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseVo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 操作成功
     *
     * @param <T>
     * @return
     */
    public static <T> BaseVo<T> success() {
        return new BaseVo<>(SUCCESS.getCode(), SUCCESS.getMessage());
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseVo<T> success(T data) {
        return new BaseVo<T>(SUCCESS.getCode(), SUCCESS.getMessage(), data);
    }

    /**
     * 成功
     *
     * @param resultCode
     * @return
     */
    public static BaseVo success(ResultCode resultCode) {
        return new BaseVo(SUCCESS.getCode(), SUCCESS.getMessage(), resultCode.getMessage());
    }

    /**
     * @param e
     * @return
     */
    public static <T> BaseVo<T> failed(ApiException e) {
        return new BaseVo<T>(e.getCode(), e.getMessage(), null);
    }

    /**
     * 失败
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseVo<T> failed(T data) {
        return new BaseVo<T>(FAILURE.getCode(), FAILURE.getMessage(), data);
    }


    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> BaseVo<T> failed() {
        return new BaseVo<T>(FAILURE.getCode(), FAILURE.getMessage());
    }
}
