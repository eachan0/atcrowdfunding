package com.atguigu.crowd.mvc.controller;


import com.atguigu.crowd.entity.MenuEntity;
import com.atguigu.crowd.service.MenuService;
import com.atguigu.crowd.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("get/whole/tree.json")
    public Result<MenuEntity> getTreeMenu(){
        return menuService.treeMenu();
    }

    @PostMapping("save.json")
    public Result<String> saveMenu(MenuEntity entity){
        menuService.save(entity);
        return Result.success();
    }

    @PostMapping("modify.json")
    public Result<String> modifyMenu(MenuEntity entity){
        menuService.updateById(entity);
        return Result.success();
    }

    @PostMapping("remove.json")
    public Result<String> removeMenu(Integer id){
        menuService.removeById(id);
        return Result.success();
    }
}

