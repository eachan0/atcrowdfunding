package com.atguigu.crowd.mysql.service.impl;

import com.atguigu.crowd.entity.po.AddressEntity;
import com.atguigu.crowd.entity.po.OrderEntity;
import com.atguigu.crowd.entity.po.OrderProjectEntity;
import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.entity.vo.OrderVO;
import com.atguigu.crowd.mysql.mapper.OrderMapper;
import com.atguigu.crowd.mysql.service.AddressService;
import com.atguigu.crowd.mysql.service.OrderProjectService;
import com.atguigu.crowd.mysql.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderProjectService orderProjectService;

    @Override
    public OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId) {
        return orderProjectService.selectOrderProjectVO(returnId);
    }

    @Override
    public List<AddressVO> getAddressVOList(Integer memberId) {

        LambdaQueryWrapper<AddressEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AddressEntity::getMemberId,memberId);

        List<AddressEntity> addressEntities = addressService.list(wrapper);

        return addressEntities.stream().map(item -> {
            AddressVO addressVO = new AddressVO();
            BeanUtils.copyProperties(item, addressVO);
            return addressVO;
        }).collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void saveAddress(AddressVO addressVO) {

        AddressEntity address = new AddressEntity();

        BeanUtils.copyProperties(addressVO, address);

        addressService.save(address);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void saveOrder(OrderVO orderVO) {

        OrderEntity orderEntity = new OrderEntity();

        BeanUtils.copyProperties(orderVO, orderEntity);

        OrderProjectEntity orderProjectEntity = new OrderProjectEntity();

        BeanUtils.copyProperties(orderVO.getOrderProjectVO(), orderProjectEntity);

        // 保存orderPO自动生成的主键是orderProjectPO需要用到的外键
        this.save(orderEntity);

        // 从orderPO中获取orderId
        Integer id = orderEntity.getId();

        // 将orderId设置到orderProjectPO
        orderProjectEntity.setOrderId(id);

        orderProjectService.save(orderProjectEntity);
    }
}
