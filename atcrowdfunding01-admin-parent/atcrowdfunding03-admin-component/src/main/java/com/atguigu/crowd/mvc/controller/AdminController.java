package com.atguigu.crowd.mvc.controller;


import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService service;

    @GetMapping("getone.json")
    public AdminEntity getOne(){
        return service.getById(1);
    }
}

