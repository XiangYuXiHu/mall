package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.smile.admin.service.ResourceService;
import com.smile.admin.service.RoleResourceService;
import com.smile.admin.service.UserRoleService;
import com.smile.dao.entity.Resource;
import com.smile.dao.entity.RoleResource;
import com.smile.dao.entity.UserRole;
import com.smile.dao.mapper.ResourceMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-08-28
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleResourceService roleResourceService;


    @Override
    public List<Resource> getResourceList(Long userId) {
        List<UserRole> userRoles = userRoleService.getUserRoleList(userId);
        if (CollectionUtils.isNotEmpty(userRoles)) {
            List<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
            List<RoleResource> roleResources = roleResourceService.getResourceIds(roleIds);
            if (CollectionUtils.isNotEmpty(roleResources)) {
                List<Long> resourceIds = roleResources.stream().map(RoleResource::getResourceId).collect(Collectors.toList());
                return getResourceList(resourceIds);
            }
        }
        return Lists.newArrayList();
    }

    @Override
    public List<Resource> getResourceList(List<Long> resourceIds) {
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", resourceIds);
        return list(queryWrapper);
    }
}
