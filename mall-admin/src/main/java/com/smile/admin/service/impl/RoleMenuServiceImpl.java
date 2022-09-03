package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.admin.service.RoleMenuService;
import com.smile.dao.entity.RoleMenu;
import com.smile.dao.mapper.RoleMenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台角色菜单关系表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Override
    public List<RoleMenu> getRoleMenuByRoleId(List<Long> roleIds) {
        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("role_id", roleIds);
        return list(queryWrapper);
    }
}
