package com.smile.common.domain;

import com.smile.common.enums.BizEnum;
import com.smile.common.exception.BizException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import static com.smile.common.enums.BizEnum.FAILURE;
import static com.smile.common.enums.BizEnum.SUCCESS;

/**
 * @Description
 * @ClassName BizResponse
 * @Author smile
 * @date 2022.07.03 18:03
 */
@Getter
@Setter
@ApiModel("API通用响应")
public class BizResponse<T> {

    @ApiModelProperty("0表示成功,非0表示失败")
    private Integer code;

    @ApiModelProperty("描述信息")
    private String message;

    @ApiModelProperty("数据")
    private T data;

    public BizResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BizResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BizResponse<T> success(T data) {
        return new BizResponse<>(SUCCESS.getCode(), SUCCESS.getMessage(), data);
    }

    /**
     * @param e
     * @return
     */
    public static BizResponse failure(BizException e) {
        return new BizResponse(e.getCode(), e.getMessage(), null);
    }

    /**
     * 操作成功
     *
     * @param <T>
     * @return
     */
    public static <T> BizResponse<T> success() {
        return new BizResponse<>(SUCCESS.getCode(), SUCCESS.getMessage());
    }

    /**
     * 失败
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BizResponse<T> failure(T data) {
        return new BizResponse<>(FAILURE.getCode(), FAILURE.getMessage(), data);
    }


    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> BizResponse<T> failure() {
        return new BizResponse<>(FAILURE.getCode(), FAILURE.getMessage());
    }
}
