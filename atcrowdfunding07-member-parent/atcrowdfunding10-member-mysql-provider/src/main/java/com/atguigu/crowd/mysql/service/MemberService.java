package com.atguigu.crowd.mysql.service;

import com.atguigu.crowd.entity.po.MemberEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-13
 */
public interface MemberService extends IService<MemberEntity> {

    /**
     * 获取 会员
     * @param acct 会员账户
     * @return 会员信息
     */
    MemberEntity getByAcct(String acct);
}
