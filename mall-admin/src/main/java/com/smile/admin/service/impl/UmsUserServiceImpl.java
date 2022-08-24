package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.admin.bo.MyUserDetails;
import com.smile.admin.dto.UmsUserRegisterRequest;
import com.smile.admin.service.UmsResourceService;
import com.smile.admin.service.UmsUserLoginLogService;
import com.smile.admin.service.UmsUserService;
import com.smile.common.enums.BizEnum;
import com.smile.common.exception.BizException;
import com.smile.dao.entity.UmsResource;
import com.smile.dao.entity.UmsUser;
import com.smile.dao.mapper.UmsUserMapper;
import com.smile.security.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.smile.common.enums.BizEnum.ACCOUNT_FREEZE;
import static com.smile.common.enums.BizEnum.PASSWORD_ERROR;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-07-10
 */
@Slf4j
@Service("umsUserService")
public class UmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser> implements UmsUserService {

    @Autowired
    private UmsResourceService umsResourceService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UmsUserLoginLogService umsUserLoginLogService;


    @Override
    public UmsUser getUmsUserByUsername(String username) {
        QueryWrapper<UmsUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        UmsUser umsUser = getOne(queryWrapper);
        return umsUser;
    }

    @Override
    public void register(UmsUserRegisterRequest umsUserRegisterRequest) {
        UmsUser umsUser = new UmsUser();
        BeanUtils.copyProperties(umsUserRegisterRequest, umsUser);
        umsUser.setCreateTime(new Date());
        umsUser.setStatus(Boolean.TRUE);
        UmsUser user = getUmsUserByUsername(umsUserRegisterRequest.getUsername());
        if (null != user) {
            throw new BizException(BizEnum.REGISTRY_ALREADY);
        }
        String encodePassword = passwordEncoder.encode(umsUser.getPassword());
        umsUser.setPassword(encodePassword);
        save(umsUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsUser user = getUmsUserByUsername(username);
        if (null != user) {
            List<UmsResource> resourceList = umsResourceService.getResourceList(user.getId());
            return new MyUserDetails(user, resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public String login(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BizException(PASSWORD_ERROR);
        }
        if (!userDetails.isEnabled()) {
            throw new BizException(ACCOUNT_FREEZE);
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jwtTokenUtil.generateToken(userDetails);

        umsUserLoginLogService.recordLoginLog(username);
        return token;
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }


}
