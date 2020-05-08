package com.atguigu.crowd.mvc.controller;

import com.atguigu.crowd.entity.AuthEntity;
import com.atguigu.crowd.entity.RoleEntity;
import com.atguigu.crowd.service.AdminService;
import com.atguigu.crowd.service.AuthService;
import com.atguigu.crowd.service.RoleService;
import com.atguigu.crowd.util.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月08日
 * @desc AssignController
 */
@Controller
@RequestMapping("assign")
public class AssignController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthService authService;

    @GetMapping("to/assign/role/page.html")
    public String assignRolePage(Integer id, ModelMap modelMap) {
        List<RoleEntity> assignRoleList = roleService.assignRole(id);
        List<RoleEntity> unAssignRoleList = roleService.unAssignRole(id);
        modelMap.addAttribute("assignRoleList", assignRoleList);
        modelMap.addAttribute("unAssignRoleList", unAssignRoleList);
        return "assign-role";
    }

    @PostMapping("do/role/assign.html")
    public String assignRole(Integer id, Integer pageNum, String keyword,
                             @RequestParam(required = false) List<Integer> roleList) {
        adminService.saveAdminRoleRelationship(id, roleList);
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }

    @GetMapping("get/all/auth.json")
    @ResponseBody
    public Result<List<AuthEntity>> getAllAuth() {
        List<AuthEntity> list = authService.list();
        return Result.success(list,list.size());
    }

    @GetMapping("get/authIdByRoleId.json")
    @ResponseBody
    public Result<List<Integer>> getAuthIdByRoleId(Integer id) {
        return authService.getAuthIdByRoleId(id);
    }

    @PostMapping("do/role/assign/auth.json")
    @ResponseBody
    public Result<String> assignAuth(@RequestBody Map<String, List<Integer>> map){
        authService.saveRoleAuthRelationship(map);
        return Result.success();
    }
}
