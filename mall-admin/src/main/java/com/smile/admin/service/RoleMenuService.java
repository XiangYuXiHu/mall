package com.smile.admin.service;

import com.smile.dao.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台角色菜单关系表 服务类
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
public interface RoleMenuService extends IService<RoleMenu> {

    /**
     * 根据roleId获取角色菜单
     *
     * @param roleIds
     * @return
     */
    List<RoleMenu> getRoleMenuByRoleId(List<Long> roleIds);
}
