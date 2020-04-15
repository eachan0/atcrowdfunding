package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员账户表 服务实现类
 * </p>
 *
 * @author zhuyc
 * @since 2020-04-14
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminEntity> implements AdminService {

}
