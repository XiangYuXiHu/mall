package com.smile.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.dao.entity.UmsUserLoginLog;
import com.smile.dao.mapper.UmsUserLoginLogMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户登录日志表 服务实现类
 * </p>
 *
 * @author smile
 * @since 2022-07-10
 */
@Service
public class UmsUserLoginLogServiceImpl extends ServiceImpl<UmsUserLoginLogMapper, UmsUserLoginLog> implements IService<UmsUserLoginLog> {

}
