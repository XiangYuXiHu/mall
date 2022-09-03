package com.smile.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 后台角色菜单关系表
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
@TableName("sys_role_menu")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 角色ID
     */
      private Long roleId;

      /**
     * 菜单ID
     */
      private Long menuId;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 更新时间
     */
      private LocalDateTime updateTime;

    
    public Long getId() {
        return id;
    }

      public void setId(Long id) {
          this.id = id;
      }
    
    public Long getRoleId() {
        return roleId;
    }

      public void setRoleId(Long roleId) {
          this.roleId = roleId;
      }
    
    public Long getMenuId() {
        return menuId;
    }

      public void setMenuId(Long menuId) {
          this.menuId = menuId;
      }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }

      public void setCreateTime(LocalDateTime createTime) {
          this.createTime = createTime;
      }
    
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

      public void setUpdateTime(LocalDateTime updateTime) {
          this.updateTime = updateTime;
      }

    @Override
    public String toString() {
        return "RoleMenu{" +
              "id=" + id +
                  ", roleId=" + roleId +
                  ", menuId=" + menuId +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
