package com.atguigu.crowd.mysql.controller;

import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.entity.po.MemberEntity;
import com.atguigu.crowd.mysql.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc MemberController
 */
@RestController
@RequestMapping("member/remote")
public class MemberRemoteController {

    @Autowired
    private MemberService memberService;

    @GetMapping("acct/{acct}")
    public AppResult<MemberEntity> getByAcctRemote(@PathVariable String acct){
        MemberEntity byAcct = memberService.getByAcct(acct);
        return AppResult.success(byAcct, 0);
    }

    @PostMapping("save")
    public AppResult<String> saveMember(@RequestBody MemberEntity entity){
       memberService.save(entity);
        return AppResult.success();
    }

}
