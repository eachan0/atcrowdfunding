package com.atguigu.crowd.api.mysqlremote;

import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.entity.po.MemberEntity;
import com.atguigu.crowd.entity.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc MemberService
 */
@FeignClient("atguigu-crowd-mysql")
public interface MysqlRemoteService {

    @GetMapping("/member/remote/acct/{acct}")
    AppResult<MemberEntity> getByAcctRemote(@PathVariable("acct") String acct);

    @PostMapping("/member/remote/save")
    AppResult<String> saveMember(@RequestBody MemberEntity entity);

    @RequestMapping("/save/project/vo/remote")
    AppResult<String> saveProjectRemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId);

    @RequestMapping("/get/portal/type/project/data/remote")
    AppResult<List<PortalTypeVO>> getPortalTypeProjectDataRemote();

    @RequestMapping("/get/project/detail/remote/{projectId}")
    AppResult<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId);

    @RequestMapping("/get/order/project/vo/remote")
    AppResult<OrderProjectVO> getOrderProjectVORemote(@RequestParam("projectId") Integer projectId, @RequestParam("returnId") Integer returnId);

    @RequestMapping("/get/address/vo/remote")
    AppResult<List<AddressVO>> getAddressVORemote(@RequestParam("memberId") Integer memberId);

    @RequestMapping("/save/address/remote")
    AppResult<String> saveAddressRemote(@RequestBody AddressVO addressVO);

    @RequestMapping("/save/order/remote")
    AppResult<String> saveOrderRemote(@RequestBody OrderVO orderVO);
}
