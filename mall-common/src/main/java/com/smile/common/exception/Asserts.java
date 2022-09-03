package com.smile.common.exception;

import com.smile.common.enums.ResultCode;

/**
 * @Description
 * @ClassName Asserts
 * @Author smile
 * @date 2022.08.28 17:47
 */
public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(ResultCode resultCode) {
        throw new ApiException(resultCode);
    }
}
