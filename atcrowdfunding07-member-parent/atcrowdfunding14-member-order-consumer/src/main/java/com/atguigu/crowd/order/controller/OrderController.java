package com.atguigu.crowd.order.controller;

import cn.hutool.http.HttpStatus;
import com.atguigu.crowd.api.mysqlremote.MysqlRemoteService;
import com.atguigu.crowd.common.constant.AppConst;
import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.MemberVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@Controller
public class OrderController {

    @Autowired
    private MysqlRemoteService mysqlRemoteService;

    @RequestMapping("/save/address")
    public String saveAddress(AddressVO addressVO, HttpSession session) {

        // 1.执行地址信息的保存
        AppResult<String> result = mysqlRemoteService.saveAddressRemote(addressVO);

        log.debug("地址保存处理结果：{}", result.getMessage());

        // 2.从Session域获取orderProjectVO对象
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");

        // 3.从orderProjectVO对象中获取returnCount
        Integer returnCount = orderProjectVO.getReturnCount();

        // 4.重定向到指定地址，重新进入确认订单页面
        return "redirect:http://www.crowd.com/order/confirm/order/" + returnCount;
    }

    @RequestMapping("/confirm/order/{returnCount}")
    public String showConfirmOrderInfo(
            @PathVariable("returnCount") Integer returnCount,
            HttpSession session) {

        // 1.把接收到的回报数量合并到Session域
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");

        orderProjectVO.setReturnCount(returnCount);

        session.setAttribute("orderProjectVO", orderProjectVO);

        // 2.获取当前已登录用户的id
        MemberVO memberLoginVO = (MemberVO) session.getAttribute(AppConst.ATTR_NAME_LOGIN_MEMBER);

        Integer memberId = memberLoginVO.getId();

        // 3.查询目前的收货地址数据
        AppResult<List<AddressVO>> result = mysqlRemoteService.getAddressVORemote(memberId);

        if (result.getStatus() == HttpStatus.HTTP_OK) {
            List<AddressVO> list = result.getData();
            session.setAttribute("addressVOList", list);
        }

        return "confirm_order";
    }

    @RequestMapping("/confirm/return/info/{projectId}/{returnId}")
    public String showReturnConfirmInfo(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("returnId") Integer returnId,
            HttpSession session) {

        AppResult<OrderProjectVO> result =
                mysqlRemoteService.getOrderProjectVORemote(projectId, returnId);

        if (result.getStatus() == HttpStatus.HTTP_OK) {
            OrderProjectVO orderProjectVO = result.getData();

            // 为了能够在后续操作中保持orderProjectVO数据，存入Session域
            session.setAttribute("orderProjectVO", orderProjectVO);
        }

        return "confirm_return";
    }

}
