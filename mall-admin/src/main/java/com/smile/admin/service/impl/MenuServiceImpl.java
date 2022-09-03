package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.smile.admin.dto.domain.MenuDto;
import com.smile.admin.service.MenuService;
import com.smile.admin.service.RoleMenuService;
import com.smile.admin.service.UserRoleService;
import com.smile.dao.entity.Menu;
import com.smile.dao.entity.RoleMenu;
import com.smile.dao.entity.UserRole;
import com.smile.dao.mapper.MenuMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public List<MenuDto> getMenuByUserId(Long userId) {
        List<UserRole> userRoles = userRoleService.getUserRoleList(userId);
        if (CollectionUtils.isNotEmpty(userRoles)) {
            List<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
            List<RoleMenu> roleMenus = roleMenuService.getRoleMenuByRoleId(roleIds);
            if (CollectionUtils.isNotEmpty(roleMenus)) {
                List<Long> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
                List<Menu> menus = listByIds(menuIds);
                return menus.stream().map(menu -> {
                    MenuDto menuDto = MenuDto.builder().title(menu.getTitle())
                            .name(menu.getName()).sort(menu.getSort())
                            .parentId(menu.getParentId()).hidden(menu.getHidden())
                            .level(menu.getLevel()).icon(menu.getIcon()).build();
                    return menuDto;
                }).collect(Collectors.toList());
            }
        }
        return Lists.newArrayList();
    }

    @Override
    public List<Menu> getMenuByRoleId(Long roleId) {
        return null;
    }


}
