package com.smile.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.dao.entity.RoleResource;

import java.util.List;

/**
 * <p>
 * 后台角色资源关系表 服务类
 * </p>
 *
 * @author smile
 * @since 2022-09-03
 */
public interface RoleResourceService extends IService<RoleResource> {

    /***
     * 根据角色获取资源主键
     * @param roleIds
     * @return
     */
    List<RoleResource> getResourceIds(List<Long> roleIds);
}
