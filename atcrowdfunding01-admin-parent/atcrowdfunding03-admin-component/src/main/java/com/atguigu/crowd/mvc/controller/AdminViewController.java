package com.atguigu.crowd.mvc.controller;


import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员账户表 前端控制器
 * </p>
 *
 * @author zhuyc
 * @since 2020-04-14
 */
@Controller
@RequestMapping("/admin")
public class AdminViewController {


    @Autowired
    private AdminService service;

    @GetMapping("test.html")
    public String getOne(ModelMap map){
        AdminEntity entity = service.getById(1);
        map.addAttribute("admin", entity);
        return "target";
    }
}

