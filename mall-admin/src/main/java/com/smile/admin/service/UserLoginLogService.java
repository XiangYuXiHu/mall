package com.smile.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.dao.entity.UserLoginLog;

/**
 * <p>
 * 后台用户登录日志表 服务类
 * </p>
 *
 * @author smile
 * @since 2022-08-28
 */
public interface UserLoginLogService extends IService<UserLoginLog> {

    /**
     * 添加登陆记录
     *
     * @param username
     */
    void recordLoginLog(String username);
}
