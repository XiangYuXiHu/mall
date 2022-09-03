package com.smile.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.dao.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 服务类
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 根据userId查询角色列表
     *
     * @param userId
     * @return
     */
    List<UserRole> getRoleIds(Long userId);
}
