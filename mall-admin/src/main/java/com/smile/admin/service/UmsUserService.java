package com.smile.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.admin.dto.UmsUserRegisterRequest;
import com.smile.dao.entity.UmsUser;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author smile
 * @since 2022-07-10
 */
public interface UmsUserService extends IService<UmsUser> {

    /**
     * 根据username获取user
     *
     * @param username
     * @return
     */
    UmsUser getUmsUserByUsername(String username);

    /**
     * 注册成功
     *
     * @param umsUserRegisterRequest
     * @return
     */
    void register(UmsUserRegisterRequest umsUserRegisterRequest);

    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 刷新token的功能
     *
     * @param token
     * @return
     */
    String refreshToken(String token);

}
