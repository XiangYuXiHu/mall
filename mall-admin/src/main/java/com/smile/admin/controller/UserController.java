package com.smile.admin.controller;


import com.smile.admin.dto.request.UserLoginRequest;
import com.smile.admin.dto.request.UserRegisterRequest;
import com.smile.admin.service.UserService;
import com.smile.common.domain.CommonResult;
import com.smile.common.exception.ApiException;
import com.smile.common.exception.Asserts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import static com.smile.common.enums.ResultCode.*;

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
@Api(tags = "UserController", value = "后台用户管理")
@RequestMapping("/user")
public class UserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param userRegisterRequest
     * @return
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("register")
    public CommonResult register(@Validated @RequestBody UserRegisterRequest userRegisterRequest) {
        log.info("注册请求参数为:{}", userRegisterRequest);
        userService.register(userRegisterRequest);
        return CommonResult.success(REGISTRY_SUCCESS.getMessage());
    }

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "登陆返回token")
    @PostMapping("login")
    public CommonResult<Map<String, String>> login(@Validated @RequestBody UserLoginRequest request) {
        log.info("用户登录请求参数为:{}", request);
        String token = userService.login(request.getUsername(), request.getPassword());

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    /**
     * 刷新token
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "刷新token")
    @GetMapping("refreshToken")
    public CommonResult<Map<String, String>> refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHead);
        String refreshToken = userService.refreshToken(token);
        if (StringUtils.isBlank(refreshToken)) {
            Asserts.fail(TOKEN_EXPIRED);
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
//    @ApiOperation(value = "获取当前登录用户信息")
//    @GetMapping("info")
//    public CommonResult getUserInfo(Principal principal) {
//        if (null == principal) {
//            return CommonResult.unauthorized(UNAUTHORIZED);
//        }
//        String username = principal.getName();
//        UmsUser user = umsUserService.getUmsUserByUsername(username);
//        Map<String, String> data = new HashMap<>();
//        data.put("username", username);
////        data.put("menus",r)
//        data.put("icon", user.getIcon());
//
//        return null;
//    }


}

