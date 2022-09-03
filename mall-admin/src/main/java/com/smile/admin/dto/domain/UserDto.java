package com.smile.admin.dto.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @ClassName AdminDto
 * @Author smile
 * @date 2022.08.28 16:45
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像
     */
    private String icon;

    /**
     * 菜单列表
     */
    private List<MenuDto> menuDtoList;

    /**
     * 菜单名称
     */
    private List<String> roleNameList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuDto> getMenuDtoList() {
        return menuDtoList;
    }

    public void setMenuDtoList(List<MenuDto> menuDtoList) {
        this.menuDtoList = menuDtoList;
    }

    public List<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
    }
}
