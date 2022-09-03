package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.smile.admin.service.RoleService;
import com.smile.admin.service.UserRoleService;
import com.smile.dao.entity.Role;
import com.smile.dao.entity.UserRole;
import com.smile.dao.mapper.RoleMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public List<Role> getRoleList(Long userId) {
        List<UserRole> userRoleList = userRoleService.getUserRoleList(userId);
        if (CollectionUtils.isNotEmpty(userRoleList)) {
            List<Long> roleIds = userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toList());
            List<Role> roleList = listByIds(roleIds);
            return roleList;
        }
        return Lists.newArrayList();
    }
}
