package com.smile.admin.controller;


import com.smile.admin.dto.UmsUserParam;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
     * @param umsUserParam
     * @return
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("register")
    public BizResponse<UmsUser> register(@Validated @RequestBody UmsUserParam umsUserParam) {
        try {
            log.info("注册的请求参数为:{}", umsUserParam);
            umsUserService.register(umsUserParam);
            return BizResponse.success();
        } catch (BizException e) {
            return BizResponse.failure(e);
        }
    }

//    @ApiOperation(value = "登陆返回token")
//    @PostMapping("login")
//    public BizResponse login(@Validated @RequestBody ) {
//
//    }
}

