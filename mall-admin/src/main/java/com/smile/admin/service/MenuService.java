package com.smile.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.admin.dto.domain.MenuDto;
import com.smile.dao.entity.Menu;

import java.util.List;

/**
 * <p>
 * 后台菜单表 服务类
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
public interface MenuService extends IService<Menu> {

    /***
     * 获取用户的菜单
     * @param userId
     * @return
     */
    List<MenuDto> getMenuByUserId(Long userId);

    /**
     * 获取角色关联菜单
     *
     * @param roleId
     * @return
     */
    List<Menu> getMenuByRoleId(Long roleId);
}
