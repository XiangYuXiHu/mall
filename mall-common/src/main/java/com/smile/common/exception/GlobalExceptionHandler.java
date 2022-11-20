package com.smile.common.exception;

import com.smile.common.vo.BaseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 *
 * @Description
 * @ClassName GlobalExceptionHandler
 * @Author smile
 * @date 2022.08.14 23:00
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 业务异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = ApiException.class)
    public BaseVo handle(ApiException e) {
        return BaseVo.failed(e);
    }


}


