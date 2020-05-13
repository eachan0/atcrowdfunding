package com.atguigu.crowd.api.mysqlremote;

import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.entity.po.MemberEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc MemberService
 */
@FeignClient("atguigu-crowd-mysql")
public interface MemberRemoteService {

    @GetMapping("/member/remote/acct/{acct}")
    AppResult<MemberEntity> getByAcctRemote(@PathVariable("acct") String acct);

    @PostMapping("/member/remote/save")
    AppResult<String> saveMember(@RequestBody MemberEntity entity);
}
