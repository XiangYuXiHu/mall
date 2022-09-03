package com.smile.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.dao.entity.Role;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据userId获取角色
     *
     * @param userId
     * @return
     */
    List<Role> getRoleList(Long userId);
}
