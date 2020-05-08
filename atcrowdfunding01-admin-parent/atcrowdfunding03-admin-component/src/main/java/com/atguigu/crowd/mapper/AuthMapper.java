package com.atguigu.crowd.mapper;

import com.atguigu.crowd.entity.AuthEntity;
import com.atguigu.crowd.util.Result;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-08
 */
public interface AuthMapper extends BaseMapper<AuthEntity> {

    /**
     * 获取已分配的权限Id
     *
     * @param rId 角色Id
     * @return id list
     */
    List<Integer> selectAuthIdByRoleId(Integer rId);

    /**
     * 删除对应关系
     *
     * @param roleId 角色ID
     */
    void deleteOldRelationship(Integer roleId);

    /**
     * 保存对应关系
     *
     * @param roleId     角色Id
     * @param authIdList 权限ID list
     */
    void insertNewRelationship(@Param("roleId") Integer roleId, @Param("authIdList") List<Integer> authIdList);
}
