package com.smile.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.admin.dto.domain.UserDto;
import com.smile.admin.dto.request.UserRegisterRequest;
import com.smile.dao.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author smile
 * @since 2022-08-28
 */
public interface UserService extends IService<User> {

    /**
     * 根据username获取user
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 注册成功
     *
     * @param userRegisterRequest
     * @return
     */
    boolean register(UserRegisterRequest userRegisterRequest);

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

    /***
     * 分页查询
     * @param username
     * @param nickName
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UserDto> userPage(String username, String nickName, Integer pageSize, Integer pageNum);

}
