package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.admin.service.RoleResourceService;
import com.smile.dao.entity.RoleResource;
import com.smile.dao.mapper.RoleResourceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台角色资源关系表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource> implements RoleResourceService {

    @Override
    public List<RoleResource> getResourceIds(List<Long> roleIds) {
        QueryWrapper<RoleResource> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("role_id", roleIds);
        return list(queryWrapper);
    }
}
