package com.atguigu.crowd.mysql.service;

import com.atguigu.crowd.entity.po.OrderProjectEntity;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-20
 */
public interface OrderProjectService extends IService<OrderProjectEntity> {

    OrderProjectVO selectOrderProjectVO(Integer returnId);
}
