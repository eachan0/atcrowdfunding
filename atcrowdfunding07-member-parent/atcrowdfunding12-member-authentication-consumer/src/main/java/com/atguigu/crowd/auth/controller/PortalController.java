package com.atguigu.crowd.auth.controller;

import cn.hutool.http.HttpStatus;
import com.atguigu.crowd.api.mysqlremote.MysqlRemoteService;
import com.atguigu.crowd.common.constant.AppConst;
import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PortalController {

	@Autowired
	private MysqlRemoteService mysqlRemoteService;

	@RequestMapping("/")
	public String showPortalPage(Model model) {

		// 1、调用MySQLRemoteService提供的方法查询首页要显示的数据
		AppResult<List<PortalTypeVO>> resultEntity =
				mysqlRemoteService.getPortalTypeProjectDataRemote();
		// 2.检查查询结果
		int status = resultEntity.getStatus();
		if(status == HttpStatus.HTTP_OK) {
			// 3.获取查询结果数据
			List<PortalTypeVO> list = resultEntity.getData();
			// 4.存入模型
			model.addAttribute(AppConst.ATTR_NAME_PORTAL_DATA, list);
		}

		return "portal";
	}

}
