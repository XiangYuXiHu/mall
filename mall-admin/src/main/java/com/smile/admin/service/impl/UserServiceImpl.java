package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.admin.bo.MyUserDetails;
import com.smile.admin.dto.request.UserRegisterRequest;
import com.smile.admin.service.ResourceService;
import com.smile.admin.service.UserLoginLogService;
import com.smile.admin.service.UserService;
import com.smile.common.exception.ApiException;
import com.smile.common.exception.Asserts;
import com.smile.dao.entity.Resource;
import com.smile.dao.entity.User;
import com.smile.dao.mapper.UserMapper;
import com.smile.security.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.smile.common.enums.ResultCode.*;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-08-28
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserLoginLogService userLoginLogService;


    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = getOne(queryWrapper);
        return user;
    }

    @Override
    public void register(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterRequest, user);
        user.setCreateTime(new Date());
        user.setStatus(Boolean.TRUE);
        User userExist = getUserByUsername(userRegisterRequest.getUsername());
        if (null != userExist) {
            Asserts.fail(REGISTRY_ALREADY);
        }
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        save(user);
    }

    @Override
    public String login(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            Asserts.fail(PASSWORD_ERROR);
        }
        if (!userDetails.isEnabled()) {
            Asserts.fail(ACCOUNT_FREEZE);
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jwtTokenUtil.generateToken(userDetails);

        userLoginLogService.recordLoginLog(username);
        return token;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = getUserByUsername(username);
        if (null != user) {
            List<Resource> resourceList = resourceService.getResourceList(user.getId());
            return new MyUserDetails(user, resourceList);
        }
        throw new ApiException("用户名或密码错误");
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }
}
