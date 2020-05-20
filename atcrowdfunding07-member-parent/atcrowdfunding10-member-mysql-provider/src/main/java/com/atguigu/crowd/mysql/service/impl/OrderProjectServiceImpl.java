package com.atguigu.crowd.mysql.service.impl;

import com.atguigu.crowd.entity.po.OrderProjectEntity;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.mysql.mapper.OrderProjectMapper;
import com.atguigu.crowd.mysql.service.OrderProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-20
 */
@Service
public class OrderProjectServiceImpl extends ServiceImpl<OrderProjectMapper, OrderProjectEntity> implements OrderProjectService {

    @Override
    public OrderProjectVO selectOrderProjectVO(Integer returnId) {
        return this.baseMapper.selectOrderProjectVO(returnId);
    }
}
