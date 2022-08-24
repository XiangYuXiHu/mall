package com.smile.admin.controller;


import com.smile.admin.dto.UmsUserRegisterRequest;
import com.smile.admin.dto.request.UmsUserLoginRequest;
import com.smile.common.exception.BizException;
import com.smile.admin.service.UmsRoleService;
import com.smile.admin.service.UmsUserService;
import com.smile.common.domain.BizResponse;
import com.smile.dao.entity.UmsUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.smile.common.enums.BizEnum.TOKEN_EXPIRED;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author smile
 * @since 2022-07-10
 */
@Slf4j
@RestController
@Api(tags = "UmsUserController", value = "后台用户管理")
@RequestMapping("/admin")
public class UmsUserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsUserService umsUserService;

    @Autowired
    private UmsRoleService umsRoleService;

    /**
     * 用户注册
     *
     * @param umsUserRegisterRequest
     * @return
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("register")
    public BizResponse<UmsUser> register(@Validated @RequestBody UmsUserRegisterRequest umsUserRegisterRequest) {
        log.info("注册的请求参数为:{}", umsUserRegisterRequest);
        umsUserService.register(umsUserRegisterRequest);
        return BizResponse.success();
    }

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "登陆返回token")
    @PostMapping("login")
    public BizResponse<Map<String, String>> login(@Validated @RequestBody UmsUserLoginRequest request) {
        log.info("用户登录的请求参数为:{}", request);
        String token = umsUserService.login(request.getUsername(), request.getPassword());

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return BizResponse.success(tokenMap);
    }

    /**
     * 刷新token
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "刷新token")
    @GetMapping("refreshToken")
    public BizResponse<Map<String, String>> refreshToken(HttpServletRequest request) {
        String refreshToken = request.getHeader(tokenHead);
        if (null == refreshToken) {
            throw new BizException(TOKEN_EXPIRED);
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return BizResponse.success(tokenMap);
    }

    
}

