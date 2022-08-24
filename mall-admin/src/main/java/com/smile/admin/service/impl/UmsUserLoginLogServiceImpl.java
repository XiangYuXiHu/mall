package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.admin.service.UmsUserLoginLogService;
import com.smile.common.util.RequestUtil;
import com.smile.dao.entity.UmsUserLoginLog;
import com.smile.dao.mapper.UmsUserLoginLogMapper;
import lombok.extern.slf4j.Slf4j;
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
 * @since 2022-07-10
 */
@Slf4j
@Service
public class UmsUserLoginLogServiceImpl extends ServiceImpl<UmsUserLoginLogMapper, UmsUserLoginLog> implements UmsUserLoginLogService {

    /**
     * 添加登录记录
     *
     * @param username
     */
    @Override
    public void recordLoginLog(String username) {
        UmsUserLoginLog umsUserLoginLog = new UmsUserLoginLog();
        umsUserLoginLog.setUserName(username);
        umsUserLoginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        umsUserLoginLog.setIp(RequestUtil.getRequestIp(request));
        save(umsUserLoginLog);
    }
}
