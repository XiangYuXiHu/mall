package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.admin.service.UserLoginLogService;
import com.smile.common.util.RequestUtil;
import com.smile.dao.entity.UserLoginLog;
import com.smile.dao.mapper.UserLoginLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 后台用户登录日志表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-08-28
 */
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements UserLoginLogService {

    /**
     * 添加登录记录
     *
     * @param username
     */
    @Override
    public void recordLoginLog(String username) {
        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setUserName(username);
        userLoginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        userLoginLog.setIp(RequestUtil.getRequestIp(request));
        save(userLoginLog);
    }
}
