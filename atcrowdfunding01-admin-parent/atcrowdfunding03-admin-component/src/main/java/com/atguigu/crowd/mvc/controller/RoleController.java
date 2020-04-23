package com.atguigu.crowd.mvc.controller;

import com.atguigu.crowd.entity.RoleEntity;
import com.atguigu.crowd.service.RoleService;
import com.atguigu.crowd.util.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author zhuyc
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping(value = "get/page/info.json")
    public Result<Page<RoleEntity>> getPageInfo(String keyword,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize) {
        return service.getPageInfo(keyword, pageNum, pageSize);
    }

    @PostMapping("save.json")
    public Result<String> saveRole(RoleEntity role){
        service.save(role);
        return Result.success();
    }

    @PostMapping("modify.json")
    public Result<String> modifyRole(RoleEntity role){
        service.updateById(role);
        return Result.success();
    }

    @PostMapping("remove.json")
    public Result<String> removeRole(@RequestBody List<Integer> ids){
        service.removeByIds(ids);
        return Result.success();
    }

}

