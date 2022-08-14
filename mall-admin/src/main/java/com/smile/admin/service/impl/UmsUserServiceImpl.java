package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.admin.bo.MyUserDetails;
import com.smile.admin.dto.UmsUserParam;
import com.smile.admin.service.UmsResourceService;
import com.smile.admin.service.UmsUserService;
import com.smile.common.enums.BizEnum;
import com.smile.common.exception.BizException;
import com.smile.dao.entity.UmsResource;
import com.smile.dao.entity.UmsUser;
import com.smile.dao.mapper.UmsUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-07-10
 */
@Service("umsUserService")
public class UmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser> implements UmsUserService {

    @Autowired
    private UmsResourceService umsResourceService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UmsUser getUmsUserByUsername(String username) {
        QueryWrapper<UmsUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        UmsUser umsUser = getOne(queryWrapper);
        return umsUser;
    }

    @Override
    public void register(UmsUserParam umsUserParam) {
        UmsUser umsUser = new UmsUser();
        BeanUtils.copyProperties(umsUserParam, umsUser);
        umsUser.setCreateTime(new Date());
        umsUser.setStatus(Boolean.TRUE);
        UmsUser user = getUmsUserByUsername(umsUserParam.getUsername());
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
}
