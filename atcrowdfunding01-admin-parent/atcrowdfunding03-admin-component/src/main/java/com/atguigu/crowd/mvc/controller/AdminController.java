package com.atguigu.crowd.mvc.controller;


import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.service.AdminService;
import com.atguigu.crowd.util.Result;
import com.atguigu.crowd.util.constant.CrowConst;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 管理员账户表 前端控制器
 * </p>
 *
 * @author zhuyc
 * @since 2020-04-14
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService service;


    @PostMapping("do/login.html")
    public String doLong(String username, String password, HttpSession session) {
        AdminEntity entity = service.doLogin(username, password);
        session.setAttribute(CrowConst.ATTR_LOGIN_NAME, entity);
        return "redirect:/admin/to/main/page.html";
    }

    @GetMapping("do/logout.html")
    public String doLong(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }

    @GetMapping(value = "get/page.html")
    public ModelAndView getPageInfo(String keyword,
                                    @RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        Result<List<AdminEntity>> pageInfo = service.getPageInfo(keyword, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin-page");
        modelAndView.addObject(CrowConst.ATTR_ADMIN_PAGE, pageInfo);
        return modelAndView;
    }
}

