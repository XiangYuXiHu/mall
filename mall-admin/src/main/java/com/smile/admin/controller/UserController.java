package com.smile.admin.controller;


import com.smile.admin.dto.domain.MenuDto;
import com.smile.admin.dto.domain.UserDto;
import com.smile.admin.dto.request.UserLoginRequest;
import com.smile.admin.dto.request.UserRegisterRequest;
import com.smile.admin.service.MenuService;
import com.smile.admin.service.RoleService;
import com.smile.admin.service.UserService;
import com.smile.common.exception.Asserts;
import com.smile.common.vo.BaseVo;
import com.smile.common.vo.PageVo;
import com.smile.dao.entity.Role;
import com.smile.dao.entity.User;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.smile.common.enums.ResultCode.TOKEN_EXPIRED;
import static com.smile.common.enums.ResultCode.UNAUTHORIZED;

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
@RequestMapping("/admin")
public class UserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    /**
     * 用户注册
     *
     * @param userRegisterRequest
     * @return
     */
    @PostMapping("register")
    public BaseVo register(@Validated @RequestBody UserRegisterRequest userRegisterRequest) {
        log.info("注册请求参数为:{}", userRegisterRequest);
        boolean isRegister = userService.register(userRegisterRequest);
        return BaseVo.success(isRegister);
    }

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    @PostMapping("login")
    public BaseVo<Map<String, String>> login(@Validated @RequestBody UserLoginRequest request) {
        log.info("用户登录请求参数为:{}", request);
        String token = userService.login(request.getUsername(), request.getPassword());

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return BaseVo.success(tokenMap);
    }

    /**
     * 刷新token
     *
     * @param request
     * @return
     */
    @GetMapping("refreshToken")
    public BaseVo<Map<String, String>> refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = userService.refreshToken(token);
        if (StringUtils.isBlank(refreshToken)) {
            Asserts.fail(TOKEN_EXPIRED);
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return BaseVo.success(tokenMap);
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    @GetMapping("info")
    public BaseVo getUserInfo(Principal principal) {
        if (null == principal) {
            Asserts.fail(UNAUTHORIZED);
        }
        String username = principal.getName();
        User user = userService.getUserByUsername(username);

        HashMap<String, Object> data = new HashMap<>();
        data.put("username", user.getUsername());
        data.put("icon", user.getIcon());
        List<MenuDto> menuList = menuService.getMenuByUserId(user.getId());
        data.put("menus", menuList);
        List<Role> roleList = roleService.getRoleList(user.getId());
        List<String> roleNames = roleList.stream().map(Role::getRoleName).collect(Collectors.toList());
        data.put("roles", roleNames);
        return BaseVo.success(data);
    }


    /**
     * 登出功能
     *
     * @return
     */
    @PostMapping(value = "/logout")
    public BaseVo logout() {
        return BaseVo.success(null);
    }


    /**
     * 根据用户名或者姓名分页查询
     *
     * @param username
     * @param nickName
     * @param pageSize
     * @param pageNum
     * @return
     */
    @GetMapping("list")
    public BaseVo getUserPage(@RequestParam("username") String username,
                              @RequestParam("nickName") String nickName,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UserDto> userDtos = userService.userPage(username, nickName, pageSize, pageNum);
        return BaseVo.success(PageVo.pageInfo(userDtos));
    }

    
}

