package com.smile.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.dao.entity.Resource;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author smile
 * @since 2022-08-28
 */
public interface ResourceService extends IService<Resource> {

    /**
     * 根据用户获取的资源
     *
     * @param userId
     * @return
     */
    List<Resource> getResourceList(Long userId);

    /**
     * 根据resourceIds获取资源列表
     *
     * @param resourceIds
     * @return
     */
    List<Resource> getResourceList(List<Long> resourceIds);

}
