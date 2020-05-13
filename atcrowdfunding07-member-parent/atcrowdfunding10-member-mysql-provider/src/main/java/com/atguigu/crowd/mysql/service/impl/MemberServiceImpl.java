package com.atguigu.crowd.mysql.service.impl;

import com.atguigu.crowd.entity.po.MemberEntity;
import com.atguigu.crowd.mysql.mapper.MemberMapper;
import com.atguigu.crowd.mysql.service.MemberService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-13
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberService {

    @Transactional(readOnly = true)
    @Override
    public MemberEntity getByAcct(String acct) {
        LambdaQueryWrapper<MemberEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MemberEntity::getLoginacct, acct);
        return this.getOne(wrapper);
    }
}
