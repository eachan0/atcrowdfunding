package com.atguigu.crowd.mysql.controller;

import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.entity.vo.OrderVO;
import com.atguigu.crowd.mysql.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderProviderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/save/order/remote")
	public AppResult<String> saveOrderRemote(@RequestBody OrderVO orderVO) {
		orderService.saveOrder(orderVO);
		return AppResult.success();
	}

	@RequestMapping("/save/address/remote")
	public AppResult<String> saveAddressRemote(@RequestBody AddressVO addressVO) {
		orderService.saveAddress(addressVO);
		return AppResult.success();
	}

	@RequestMapping("/get/address/vo/remote")
	public AppResult<List<AddressVO>> getAddressVORemote(@RequestParam("memberId") Integer memberId) {
		List<AddressVO> addressVOList = orderService.getAddressVOList(memberId);
		return AppResult.success(addressVOList,addressVOList.size());
	}

	@RequestMapping("/get/order/project/vo/remote")
	public AppResult<OrderProjectVO> getOrderProjectVORemote(
			@RequestParam("projectId") Integer projectId,
			@RequestParam("returnId") Integer returnId) {

			OrderProjectVO orderProjectVO = orderService.getOrderProjectVO(projectId, returnId);
			return AppResult.success(orderProjectVO,0);
	}

}
