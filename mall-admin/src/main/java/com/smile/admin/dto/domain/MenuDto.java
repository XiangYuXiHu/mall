package com.smile.admin.dto.domain;

import lombok.*;

import java.io.Serializable;

/**
 * @Description
 * @ClassName MenuDto
 * @Author smile
 * @date 2022.09.03 21:58
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto implements Serializable {

    private Long id;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单级数
     */
    private Integer level;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 前端名称
     */
    private String name;

    /**
     * 前端图标
     */
    private String icon;

    /**
     * 前端隐藏 0:不隐藏 1:隐藏
     */
    private Integer hidden;

    @Override
    public String toString() {
        return "MenuDto{" +
                "parentId=" + parentId +
                ", title='" + title + '\'' +
                ", level=" + level +
                ", sort=" + sort +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", hidden=" + hidden +
                '}';
    }
}
