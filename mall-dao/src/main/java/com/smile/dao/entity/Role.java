package com.smile.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 后台用户角色表
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
@TableName("sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 角色名称
     */
      private String roleName;

      /**
     * 启用状态：0->禁用；1->启用
     */
      private Integer status;

      /**
     * 排序
     */
      private Integer sort;

      /**
     * 后台用户数量
     */
      private Integer userCount;

      /**
     * 描述
     */
      private String description;

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
    
    public String getRoleName() {
        return roleName;
    }

      public void setRoleName(String roleName) {
          this.roleName = roleName;
      }
    
    public Integer getStatus() {
        return status;
    }

      public void setStatus(Integer status) {
          this.status = status;
      }
    
    public Integer getSort() {
        return sort;
    }

      public void setSort(Integer sort) {
          this.sort = sort;
      }
    
    public Integer getUserCount() {
        return userCount;
    }

      public void setUserCount(Integer userCount) {
          this.userCount = userCount;
      }
    
    public String getDescription() {
        return description;
    }

      public void setDescription(String description) {
          this.description = description;
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
        return "Role{" +
              "id=" + id +
                  ", roleName=" + roleName +
                  ", status=" + status +
                  ", sort=" + sort +
                  ", userCount=" + userCount +
                  ", description=" + description +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
