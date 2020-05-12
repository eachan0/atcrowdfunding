package com.atguigu.crowd.mvc.controller;


import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.service.AdminService;
import com.atguigu.crowd.util.constant.CrowConst;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
        Page<AdminEntity> pageInfo = service.getPageInfo(keyword, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin-page");
        modelAndView.addObject(CrowConst.ATTR_ADMIN_PAGE, pageInfo);
        return modelAndView;
    }

    @GetMapping("remove/{id}/{pageNum}/{keyword}.html")
    public String removeAdmin(@PathVariable Integer id, @PathVariable Integer pageNum, @PathVariable String keyword) {
        service.removeById(id);
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }

    @PreAuthorize("hasAuthority('user:add')")
    @PostMapping("save.html")
    public String saveAdmin(AdminEntity entity) {
        service.saveAdmin(entity);
        return "redirect:/admin/get/page.html";
    }

    @GetMapping("to/edit/page.html")
    public String modifyAdmin(Integer id, ModelMap modelMap) {
        AdminEntity entity = service.getById(id);
        modelMap.addAttribute(CrowConst.ATTR_ADMIN_EDIT, entity);
        return "admin-edit";
    }

    @PostMapping("modify.html")
    public String modifyAdmin(AdminEntity entity, Integer pageNum, String keyword) {
        service.modifyAdmin(entity);
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }
}

