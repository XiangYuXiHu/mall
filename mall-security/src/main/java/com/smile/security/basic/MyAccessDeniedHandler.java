package com.smile.security.basic;

import com.alibaba.fastjson.JSONObject;
import com.smile.common.vo.BaseVo;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 没有权限访问时，返回结果
 *
 * @Description
 * @ClassName AccessDeniedHandler
 * @Author smile
 * @date 2022.07.16 22:14
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.println(JSONObject.toJSONString(BaseVo.failed(e.getMessage())));
        writer.flush();
    }
}
