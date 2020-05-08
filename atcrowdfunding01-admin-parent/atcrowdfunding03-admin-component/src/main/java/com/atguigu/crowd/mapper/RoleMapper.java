package com.atguigu.crowd.mapper;

import com.atguigu.crowd.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author zhuyc
 * @since 2020-04-23
 */
public interface RoleMapper extends BaseMapper<RoleEntity> {

    /**
     * 查询已经有的角色
     *
     * @param id 管理员Id
     * @return role list
     */
    List<RoleEntity> selectAssignRole(Integer id);

    /**
     * 查询没有的角色
     *
     * @param id 管理员Id
     * @return role list
     */
    List<RoleEntity> selectUnAssignRole(Integer id);
}
