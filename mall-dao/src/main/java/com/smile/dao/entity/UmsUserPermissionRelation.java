package com.smile.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)
 * </p>
 *
 * @author smile
 * @since 2022-07-13
 */
public class UmsUserPermissionRelation implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 用户ID
     */
      private Long userId;

      /**
     * 权限主键
     */
      private Long permissionId;

    private Integer type;

    
    public Long getId() {
        return id;
    }

      public void setId(Long id) {
          this.id = id;
      }
    
    public Long getUserId() {
        return userId;
    }

      public void setUserId(Long userId) {
          this.userId = userId;
      }
    
    public Long getPermissionId() {
        return permissionId;
    }

      public void setPermissionId(Long permissionId) {
          this.permissionId = permissionId;
      }
    
    public Integer getType() {
        return type;
    }

      public void setType(Integer type) {
          this.type = type;
      }

    @Override
    public String toString() {
        return "UmsUserPermissionRelation{" +
              "id=" + id +
                  ", userId=" + userId +
                  ", permissionId=" + permissionId +
                  ", type=" + type +
              "}";
    }
}
