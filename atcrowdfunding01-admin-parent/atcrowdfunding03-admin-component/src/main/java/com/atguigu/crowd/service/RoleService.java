package com.atguigu.crowd.service;

import com.atguigu.crowd.entity.RoleEntity;
import com.atguigu.crowd.util.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author zhuyc
 * @since 2020-04-23
 */
public interface RoleService extends IService<RoleEntity> {

    /**
     * 分页获取角色信息
     *
     * @param keyword  关键字
     * @param pageNum  分页数
     * @param pageSize 分页大小
     * @return pageInfo
     */
    Result<Page<RoleEntity>> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 查询已经有的角色
     *
     * @param id 管理员Id
     * @return role list
     */
    List<RoleEntity> assignRole(Integer id);

    /**
     * 查询没有的角色
     *
     * @param id 管理员Id
     * @return role list
     */
    List<RoleEntity> unAssignRole(Integer id);
}
